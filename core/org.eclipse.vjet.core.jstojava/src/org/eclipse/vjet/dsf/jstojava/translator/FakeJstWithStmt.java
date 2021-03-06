/*******************************************************************************
 * Copyright (c) 2005, 2012 eBay Inc.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/
package org.eclipse.vjet.dsf.jstojava.translator;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.vjet.dsf.jst.token.IStmt;

class FakeJstWithStmt {
	private List<IStmt> m_statements = new ArrayList<IStmt>();

	public String toStmtText() {
		return "";
	}

	public List<IStmt> getStatements() {
		return m_statements;
	}
}
