/*******************************************************************************
 * Copyright (c) 2012 eBay Inc. and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     eBay Inc. - initial API and implementation
 *******************************************************************************/
package org.eclipse.vjet.vsf.resource.pattern.js.resolution;

import org.eclipse.vjet.dsf.resource.pattern.BaseResourceKey;
import org.eclipse.vjet.dsf.resource.permutation.Permutation;

public class DefaultJsResourceKey 
	extends BaseResourceKey 
	implements IJsResourceKey
{
	private String m_resourceGroupId;

	//
	// Constructor(s)
	//
	public DefaultJsResourceKey(
	    final Class<?> anchorClass,
	    final String resourceName,
	    final Permutation permutationCtx,
	    final String resourceGroupId)
	{
		super(anchorClass, resourceName, permutationCtx) ;
		m_resourceGroupId = resourceGroupId;
	}

	public String getResourceGroupId() {
		return m_resourceGroupId;
	}
}
