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
vjo.mtype('syntax.mixintype.Person')
.props({
	
	age : 0, //public int

	//> public void doIt1()
	doIt1:function(){
	}
})
.protos({
	
	name : "HA", //public String

   //> public void doIt2()
	doIt2:function(){
	},
	
	 //> public void mainMtype(String[] args)
	mainMtype : function(args)
	{
	vjo.sysout.println(this.vj$.type.age);
	vjo.sysout.println(this.name);
	vjo.sysout.println("AGE");
	vjo.sysout.println('AGE');
	vjo.sysout.println(45);
	}
})
.endType();
