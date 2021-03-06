/*******************************************************************************
 * Copyright (c) 2005, 2012 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 
 *******************************************************************************/
package org.eclipse.dltk.mod.internal.debug.core.model.operations;

import org.eclipse.dltk.mod.dbgp.exceptions.DbgpException;
import org.eclipse.dltk.mod.debug.core.model.IScriptDebugTarget;
import org.eclipse.dltk.mod.debug.core.model.IScriptThread;

public class DbgpResumeOperation extends DbgpOperation {
	private static final String JOB_NAME = Messages.DbgpResumeOperation_resumeOperation;

	private boolean first = true;
	boolean breakOnFirstLine = false;

	public DbgpResumeOperation(IScriptThread thread, IResultHandler finish) {
		super(thread, JOB_NAME, finish);

		breakOnFirstLine = ((IScriptDebugTarget) thread.getDebugTarget())
				.breakOnFirstLineEnabled();
	}

	protected void process() throws DbgpException {
		if (first && breakOnFirstLine) {
			callFinish(getCore().stepInto());
		} else {
			callFinish(getCore().run());
		}

		first = false;
	}
}
