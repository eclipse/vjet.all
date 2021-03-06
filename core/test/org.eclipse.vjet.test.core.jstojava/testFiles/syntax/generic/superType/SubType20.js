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
vjo.ctype('syntax.generic.superType.SubType20<T>') //< public
//>needs(syntax.generic.Collection)
.props({
})
.protos({
	//>public void test() 
	test : function(){
		var s = null;//<Collection<? extends SubType20>
		new this.UnmodifiableCollection(s);
	},
	
	UnmodifiableCollection:vjo.ctype() //< public UnmodifiableCollection<E>
    .props({
    })
    .protos({
        c:null, //< Collection<? extends E> 
        //> constructs(Collection<? extends E> )
        constructs:function(c){
            if(c===null){
            }
            this.c=c;
        }
    })
    .endType()
}) 
.endType();