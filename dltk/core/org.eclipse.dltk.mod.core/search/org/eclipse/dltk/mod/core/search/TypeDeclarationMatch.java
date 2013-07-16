/*******************************************************************************
 * Copyright (c) 2000, 2012 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 
 *******************************************************************************/
package org.eclipse.dltk.mod.core.search;

import org.eclipse.core.resources.IResource;
import org.eclipse.dltk.mod.core.IModelElement;


/**
 * A Script search match that represents a type declaration.
 * The element is an <code>IType</code>.
 * <p>
 * This class is intended to be instantiated and subclassed by clients.
 * </p>
 * 
	 *
 */
public class TypeDeclarationMatch extends SearchMatch {

	/**
	 * Creates a new type declaration match.
	 * 
	 * @param element the type declaration
	 * @param accuracy one of A_ACCURATE or A_INACCURATE
	 * @param offset the offset the match starts at, or -1 if unknown
	 * @param length the length of the match, or -1 if unknown
	 * @param participant the search participant that created the match
	 * @param resource the resource of the element
	 */
	public TypeDeclarationMatch(IModelElement element, int accuracy, int offset, int length, SearchParticipant participant, IResource resource) {
		super(element, accuracy, offset, length, participant, resource);
	}

}