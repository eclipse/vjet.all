/*******************************************************************************
 * Copyright (c) 2005-2012 eBay Inc.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/

package org.eclipse.vjet.test.core.ecma.jst.validation;




import java.util.List;

import org.eclipse.vjet.dsf.jsgen.shared.ids.VarProbIds;
import org.eclipse.vjet.dsf.jsgen.shared.validation.vjo.VjoSemanticProblem;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;




/**
 * EcmaBooleanTests.java
 * 
 * @author <a href="mailto:liama@ebay.com">liama</a>
 * @since JDK 1.5
 */
//@Category( { P3, FAST, UNIT })
//@ModuleInfo(value="DsfPrebuild",subModuleId="JsToJava")
public class EcmaBooleanTests extends VjoValidationBaseTester {

    @Before
    public void setUp() {
        expectProblems.clear();
        expectProblems.add(createNewProblem(VarProbIds.LooseVarDecl, 53, 0));
        expectProblems.add(createNewProblem(VarProbIds.LooseVarDecl, 455, 0));
        expectProblems.add(createNewProblem(VarProbIds.LooseVarDecl, 554, 0));
        expectProblems.add(createNewProblem(VarProbIds.LooseVarDecl, 555, 0));
        expectProblems.add(createNewProblem(VarProbIds.LooseVarDecl, 604, 0));
        expectProblems.add(createNewProblem(VarProbIds.LooseVarDecl, 684, 0));
        expectProblems.add(createNewProblem(VarProbIds.LooseVarDecl, 685, 0));
        expectProblems.add(createNewProblem(VarProbIds.LooseVarDecl, 688, 0));
        expectProblems.add(createNewProblem(VarProbIds.LooseVarDecl, 689, 0));
        expectProblems.add(createNewProblem(VarProbIds.LooseVarDecl, 740, 0));

    }

    @Test
    //@Category( { P3, FAST, UNIT })
    //@Description("Test DSF project, To validate false positive ")
    @Ignore("Bug8436" + "Bug 8437")
    public void testEcmaBooleanTests() {
        List<VjoSemanticProblem> problems = getVjoSemanticProblem(
                "vjet.dsf.jslang.feature.tests.", "EcmaBooleanTests.js", this
                        .getClass());
        assertProblemEquals(expectProblems, problems);
    }
}
