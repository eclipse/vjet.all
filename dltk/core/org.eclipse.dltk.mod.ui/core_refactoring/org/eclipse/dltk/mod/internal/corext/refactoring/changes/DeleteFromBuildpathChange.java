/*******************************************************************************
 * Copyright (c) 2000, 2012 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 
 *******************************************************************************/
package org.eclipse.dltk.mod.internal.corext.refactoring.changes;

import java.text.MessageFormat;

import org.eclipse.core.runtime.Assert;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.dltk.mod.core.DLTKCore;
import org.eclipse.dltk.mod.core.IBuildpathEntry;
import org.eclipse.dltk.mod.core.IScriptProject;
import org.eclipse.dltk.mod.core.IProjectFragment;
import org.eclipse.dltk.mod.internal.corext.refactoring.RefactoringCoreMessages;
import org.eclipse.dltk.mod.internal.corext.refactoring.base.DLTKChange;
import org.eclipse.ltk.core.refactoring.Change;
import org.eclipse.ltk.core.refactoring.RefactoringStatus;


public class DeleteFromBuildpathChange extends DLTKChange {

	private final String fProjectHandle;
	private final IPath fPathToDelete;
	
	private IPath fPath;	
	private int fEntryKind;
	
	public DeleteFromBuildpathChange(IProjectFragment root) {
		this(root.getPath(), root.getScriptProject());
	}
	
	DeleteFromBuildpathChange(IPath pathToDelete, IScriptProject project){
		Assert.isNotNull(pathToDelete);
		fPathToDelete= pathToDelete;
		fProjectHandle= project.getHandleIdentifier();
	}
	
	public RefactoringStatus isValid(IProgressMonitor pm) throws CoreException {
		return super.isValid(pm, READ_ONLY | DIRTY);
	}
	
	public Change perform(IProgressMonitor pm)	throws CoreException {
		pm.beginTask(getName(), 1);
		try{
			IScriptProject project= getScriptProject();
			IBuildpathEntry[] cp= project.getRawBuildpath();
			IBuildpathEntry[] newCp= new IBuildpathEntry[cp.length-1];
			int i= 0; 
			int j= 0;
			while (j < newCp.length) {
				IBuildpathEntry current= cp[i];
				if (current != null && toBeDeleted(current)) {
					i++;
					setDeletedEntryProperties(current);
				} 

				newCp[j]= cp[i];
				i++;
				j++;
			}
			
			IBuildpathEntry last= cp[cp.length - 1];
			if (last != null && toBeDeleted(last))
				setDeletedEntryProperties(last);
				
			project.setRawBuildpath(newCp, pm);
			
			return new AddToBuildpathChange(getScriptProject(), fEntryKind, fPath );
		} finally {
			pm.done();
		}
	}
	
	private boolean toBeDeleted(IBuildpathEntry entry){
		if (entry == null) //safety net
			return false; 
		return fPathToDelete.equals(entry.getPath());
	}
	
	private void setDeletedEntryProperties(IBuildpathEntry entry){
		fEntryKind= entry.getEntryKind();
		fPath= entry.getPath();		
	}
	
	private IScriptProject getScriptProject(){
		return (IScriptProject)DLTKCore.create(fProjectHandle);
	}
	
	public String getName() {
		return MessageFormat.format(RefactoringCoreMessages.DeleteFromClassPathChange_remove, new Object[] { getScriptProject().getElementName() }); 
	}

	public Object getModifiedElement() {
		return getScriptProject();
	}
}
