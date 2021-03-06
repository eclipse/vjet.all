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
vjo.ctype('vjoPro.samples.dom.HTMLandDomEx41') //< public
.needs('vjoPro.dsf.document.Element')
.protos({

/**
* @return void
* @access public
* @param {String} psId
*
*/
//> public constructs(String psId)
constructs:function(psId) {
this.sId = psId;
},

/**
* @return boolean
* @access public
*
*/
//> public boolean showLayer()
showLayer:function(){
var E = vjoPro.dsf.document.Element;
E.toggleVisibility(this.sId);
}

})
.endType();
