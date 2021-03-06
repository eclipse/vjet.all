/*******************************************************************************
 * Copyright (c) 2000, 2012 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 
 *******************************************************************************/
package org.eclipse.dltk.mod.internal.debug.ui.interpreters;

import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.dltk.mod.core.DLTKCore;
import org.eclipse.dltk.mod.core.IScriptModel;
import org.eclipse.dltk.mod.core.environment.EnvironmentManager;
import org.eclipse.dltk.mod.core.environment.IEnvironment;
import org.eclipse.dltk.mod.debug.ui.DLTKDebugUIPlugin;
import org.eclipse.dltk.mod.debug.ui.IDLTKDebugUIConstants;
import org.eclipse.dltk.mod.debug.ui.interpreters.InterpretersUpdater;
import org.eclipse.dltk.mod.internal.debug.ui.IScriptDebugHelpContextIds;
import org.eclipse.dltk.mod.launching.IInterpreterInstall;
import org.eclipse.dltk.mod.launching.ScriptRuntime;
import org.eclipse.dltk.mod.launching.ScriptRuntime.DefaultInterpreterEntry;
import org.eclipse.jface.dialogs.ErrorDialog;
import org.eclipse.jface.dialogs.IDialogSettings;
import org.eclipse.jface.preference.PreferencePage;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.swt.custom.BusyIndicator;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPreferencePage;
import org.eclipse.ui.PlatformUI;

/**
 * The Installed InterpreterEnvironments preference page.
 */
public abstract class ScriptInterpreterPreferencePage extends PreferencePage
		implements IWorkbenchPreferencePage {

	// InterpreterEnvironment Block
	private InterpretersBlock fInterpretersBlock;

	public ScriptInterpreterPreferencePage() {
		super();

		// only used when page is shown programatically
		setTitle(InterpretersMessages.InterpretersPreferencePage_1);

		setDescription(InterpretersMessages.InterpretersPreferencePage_2);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.ui.IWorkbenchPreferencePage#init(org.eclipse.ui.IWorkbench)
	 */
	public void init(IWorkbench workbench) {
	}

	public abstract InterpretersBlock createInterpretersBlock();

	/**
	 * Find & verify the default interpreter.
	 */
	private void initDefaultInterpreter() {
		IEnvironment[] environments = EnvironmentManager.getEnvironments();
		for (int j = 0; j < environments.length; j++) {
			IInterpreterInstall realDefault = ScriptRuntime
					.getDefaultInterpreterInstall(new DefaultInterpreterEntry(
							fInterpretersBlock.getCurrentNature(),
							environments[j].getId()));
			boolean verified = false;

			if (realDefault == null
					&& fInterpretersBlock.getInterpreters().length > 0)
				realDefault = fInterpretersBlock.getInterpreters()[0];

			if (realDefault != null) {
				IInterpreterInstall[] Interpreters = fInterpretersBlock
						.getInterpreters();
				for (int i = 0; i < Interpreters.length; i++) {
					IInterpreterInstall fakeInterpreter = Interpreters[i];
					if (fakeInterpreter.equals(realDefault)) {
						verified = true;
						verifyDefaultInterpreter(fakeInterpreter);
						break;
					}
				}
			}

			if (!verified) {
				if (fInterpretersBlock.getInterpreters().length > 0)
					setErrorMessage(InterpretersMessages.InterpreterPreferencePage_pleaseSetDefaultInterpreter);
				else
					setErrorMessage(InterpretersMessages.InterpreterPreferencePage_addInterpreter);
			}
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.jface.preference.PreferencePage#createContents(org.eclipse.swt.widgets.Composite)
	 */
	protected Control createContents(Composite ancestor) {
		initializeDialogUnits(ancestor);

		noDefaultAndApplyButton();

		GridLayout layout = new GridLayout();
		layout.numColumns = 1;
		layout.marginHeight = 0;
		layout.marginWidth = 0;
		ancestor.setLayout(layout);

		fInterpretersBlock = createInterpretersBlock();
		fInterpretersBlock.createControl(ancestor);
		Control control = fInterpretersBlock.getControl();
		GridData data = new GridData(GridData.FILL_BOTH);
		data.horizontalSpan = 1;
		control.setLayoutData(data);

		fInterpretersBlock.restoreColumnSettings(getDialogSettings(false),
				IScriptDebugHelpContextIds.INTERPRETER_PREFERENCE_PAGE);

		PlatformUI.getWorkbench().getHelpSystem().setHelp(ancestor,
				IScriptDebugHelpContextIds.INTERPRETER_PREFERENCE_PAGE);
		initDefaultInterpreter();
		fInterpretersBlock
				.addSelectionChangedListener(new ISelectionChangedListener() {
					public void selectionChanged(SelectionChangedEvent event) {
						IInterpreterInstall[] install = getCurrentDefaultInterpreters();

						setErrorMessage(null);
						if (fInterpretersBlock.getInterpreters().length > 0
								&& install.length < fInterpretersBlock
										.getEnvironmentsCount()) {
							setErrorMessage(InterpretersMessages.InterpreterPreferencePage_pleaseSetDefaultInterpreter);

						} else if (fInterpretersBlock.getInterpreters().length == 0) {
							setErrorMessage(InterpretersMessages.InterpreterPreferencePage_addInterpreter);
						}
					}
				});
		applyDialogFont(ancestor);
		return ancestor;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.jface.preference.IPreferencePage#performOk()
	 */
	public boolean performOk() {
		final boolean[] canceled = new boolean[] { false };
		BusyIndicator.showWhile(null, new Runnable() {
			public void run() {
				IInterpreterInstall[] defaultInterpreter = getCurrentDefaultInterpreters();
				IInterpreterInstall[] interpreters = fInterpretersBlock
						.getInterpreters();

				InterpretersUpdater updater = new InterpretersUpdater();
				if (!updater.updateInterpreterSettings(fInterpretersBlock
						.getCurrentNature(), interpreters, defaultInterpreter)) {
					canceled[0] = true;
				}
			}
		});

		if (canceled[0]) {
			return false;
		}

		// save column widths
		fInterpretersBlock.saveColumnSettings(getDialogSettings(true),
				IScriptDebugHelpContextIds.INTERPRETER_PREFERENCE_PAGE);

		return super.performOk();
	}

	protected IDialogSettings getDialogSettings(boolean isSaving) {
		final IDialogSettings settings = DLTKDebugUIPlugin.getDefault()
				.getDialogSettings();
		final String nature = fInterpretersBlock.getCurrentNature();
		IDialogSettings section = settings.getSection(nature);
		if (section == null) {
			if (isSaving) {
				section = settings.addNewSection(nature);
			} else {
				section = settings;
			}
		}
		return section;
	}

	protected IScriptModel getScriptModel() {
		return DLTKCore.create(ResourcesPlugin.getWorkspace().getRoot());
	}

	/**
	 * Verify that the specified Interpreter can be a valid default Interpreter.
	 * This amounts to verifying that all of the Interpreter's library locations
	 * exist on the file system. If this fails, remove the Interpreter from the
	 * table and try to set another default.
	 */
	private void verifyDefaultInterpreter(IInterpreterInstall interpreter) {
		if (interpreter != null) {
			boolean exist = true;
			exist = interpreter.getInstallLocation().exists();

			// If all library locations exist, check the corresponding entry in
			// the list,
			// otherwise remove the Interpreter
			if (exist) {
				fInterpretersBlock.setCheckedInterpreter(interpreter);
			} else {
				fInterpretersBlock
						.removeInterpreters(new IInterpreterInstall[] { interpreter });
				IInterpreterInstall def = null;
				def = ScriptRuntime
						.getDefaultInterpreterInstall(new DefaultInterpreterEntry(
								fInterpretersBlock.getCurrentNature(),
								fInterpretersBlock.getCurrentEnvironment()
										.getId()));
				if (def == null) {
					fInterpretersBlock.setCheckedInterpreter(null);
				} else {
					fInterpretersBlock.setCheckedInterpreter(def);
				}
				ErrorDialog
						.openError(
								getControl().getShell(),
								InterpretersMessages.InterpretersPreferencePage_1,
								InterpretersMessages.InterpretersPreferencePage_10,
								new Status(
										IStatus.ERROR,
										DLTKDebugUIPlugin.PLUGIN_ID,
										IDLTKDebugUIConstants.INTERNAL_ERROR,
										InterpretersMessages.InterpretersPreferencePage_11,
										null));
				return;
			}
		} else {
			fInterpretersBlock.setCheckedInterpreter(null);
		}
	}

	private IInterpreterInstall[] getCurrentDefaultInterpreters() {
		return fInterpretersBlock.getCheckedInterpreters();
	}

}
