/*******************************************************************************
 * Copyright (c) 2005-2012 eBay Inc.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/
package org.eclipse.vjet.dsf.javatojs.tests.exclude.anno.derivedclz;

import org.eclipse.vjet.dsf.javatojs.tests.exclude.TestTargetTranslator;
import org.eclipse.vjet.dsf.javatojs.tests.exclude.TestTargetTranslator.ClassList;



/*
 * Type Error is thrown by Class as when accessing static setFlag() method
 * 
 */
public class TestClass {

	public static void main(String[] args) {
		ClassList sourceList = TestTargetTranslator.getSourceList();
		sourceList
		//TODO: not working
		.addToList(DerivedFromExcludedBase.class)
		
		// working one
		.addToList(UseBaseField.class)
		.addToList(UseBaseStaticField.class)
		.addToList(UseBaseStaticMethod.class)
		.addToList(UseBaseInEmbededType.class)
		.addToList(UseBaseMemberInEmbededType.class)
		;
		
		TestTargetTranslator.translate(sourceList);
		TestTargetTranslator.deleteGenerated(sourceList);
	}
	
	
	
	
	
	
	
}


