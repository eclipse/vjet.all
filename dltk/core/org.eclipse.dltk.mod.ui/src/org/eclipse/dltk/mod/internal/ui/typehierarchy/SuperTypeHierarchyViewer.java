/*******************************************************************************
 * Copyright (c) 2000, 2012 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 
 *******************************************************************************/
package org.eclipse.dltk.mod.internal.ui.typehierarchy;

import java.util.List;

import org.eclipse.dltk.mod.core.IType;
import org.eclipse.dltk.mod.core.ITypeHierarchy;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.IWorkbenchPart;

/**
 * A viewer including the content provider for the supertype hierarchy.
 * Used by the TypeHierarchyViewPart which has to provide a TypeHierarchyLifeCycle
 * on construction (shared type hierarchy)
 */
public class SuperTypeHierarchyViewer extends TypeHierarchyViewer {
	
	public SuperTypeHierarchyViewer(Composite parent, TypeHierarchyLifeCycle lifeCycle, IWorkbenchPart part, IPreferenceStore store) {
		super(parent, new SuperTypeHierarchyContentProvider(lifeCycle), lifeCycle, part, store);
	}

	/*
	 * @see TypeHierarchyViewer#getTitle
	 */	
	public String getTitle() {
		if (isMethodFiltering()) {
			return TypeHierarchyMessages.SuperTypeHierarchyViewer_filtered_title; 
		} else {
			return TypeHierarchyMessages.SuperTypeHierarchyViewer_title; 
		}
	}

	/*
	 * @see TypeHierarchyViewer#updateContent
	 */	
	public void updateContent(boolean expand) {
		getTree().setRedraw(false);
		refresh();
		if (expand) {
			expandAll();
		}
		getTree().setRedraw(true);
	}
	
	/*
	 * Content provider for the supertype hierarchy
	 */
	public static class SuperTypeHierarchyContentProvider extends TypeHierarchyContentProvider {
		public SuperTypeHierarchyContentProvider(TypeHierarchyLifeCycle lifeCycle) {
			super(lifeCycle);
		}
		
		protected final void getTypesInHierarchy(IType type, List res) {
			ITypeHierarchy hierarchy= getHierarchy();
			if (hierarchy != null) {
				IType[] types= hierarchy.getSupertypes(type);
				if( types != null ) {
					for (int i= 0; i < types.length; i++) {
						res.add(types[i]);
					}
				}
			}
		}
		
		protected IType[] getParentType(IType type) {
			return null;
		}
	}		

}
