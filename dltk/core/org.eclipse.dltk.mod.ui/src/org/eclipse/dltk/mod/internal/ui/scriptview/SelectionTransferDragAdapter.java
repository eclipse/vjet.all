/*******************************************************************************
 * Copyright (c) 2000, 2012 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 
 *******************************************************************************/
package org.eclipse.dltk.mod.internal.ui.scriptview;

import org.eclipse.dltk.mod.internal.ui.dnd.BasicSelectionTransferDragAdapter;
import org.eclipse.jface.viewers.ISelectionProvider;


public class SelectionTransferDragAdapter extends BasicSelectionTransferDragAdapter {
		
	public SelectionTransferDragAdapter(ISelectionProvider provider) {
		super(provider);
	}
}
