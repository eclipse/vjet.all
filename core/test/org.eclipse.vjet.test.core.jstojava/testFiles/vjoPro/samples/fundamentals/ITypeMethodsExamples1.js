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
vjo.itype('vjoPro.samples.fundamentals.ITypeMethodsExamples1')
.props({
//> void cool()
cool: function() {},

//> public void hot(boolean v)
hot:	function(v) {}
})
.protos ({
//> void foo()
foo: vjo.NEEDS_IMPL,

//> public boolean bar(int x)
bar: vjo.NEEDS_IMPL
})
.endType();
