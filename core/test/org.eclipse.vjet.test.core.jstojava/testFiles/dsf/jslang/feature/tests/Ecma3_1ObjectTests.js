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
vjo.ctype("dsf.jslang.feature.tests.Ecma3_1ObjectTests")
.inherits("dsf.jslang.feature.tests.BaseTest")
.protos({
//-----------------------------------------------------------------------------
test_regress__444787:function(){

var BUGNUMBER = 444787;
var summary = 'Object.getPrototypeOf';
var actual = '';
var expect = '';


//-----------------------------------------------------------------------------
test();
//-----------------------------------------------------------------------------

function test()
{
//   enterFunc ('test');
//   printBugNumber(BUGNUMBER);
//   printStatus (summary);
var reportCompare = null;
var i;
var type;
var instance;
var types = [
Array,
Boolean,
Date,
Error,
Function,
Math,
Number,
Object,
RegExp,
String
];

for (i = 0; i < types.length; i++)
{
type = types[i];

if (typeof type.__proto__ != 'undefined')
{
expect = type.__proto__;
actual = Object.getPrototypeOf(type);
reportCompare(expect, actual, summary + ': ' + type.name);
}

try
{
eval('instance = new ' + type.name);
expect = type.prototype;
actual = Object.getPrototypeOf(instance);
reportCompare(expect, actual, summary + ': new ' + type.name);
}
//   catch(ex)
//   {
//       print('Ignore ' + ex);
//    }
catch(ex)
{
actual = ex + '';
reportCompare(expect, actual, summary + ': new ' + type.name);
}

}

types = [null, undefined];

for (i = 0; i < types.length; i++)
{
type = types[i];
expect = 'TypeError: Object.getPrototype is not a function';
try
{
actual = Object.getPrototype(null);
}
catch(ex)
{
actual = ex + '';
}
reportCompare(expect, actual, summary + ': ' + type);
}

var objects = [
{instance: [0], type: Array},
{instance: true, type: Boolean},
{instance: false, type: Boolean},
{instance: (function () {}), type: Function},
{instance: eval, type: Function},
{instance: parseInt, type: Function},
{instance: 1.0, type: Number},
{instance: Infinity, type: Number},
{instance: NaN, type: Number},
{instance: Math.PI, type: Number},
{instance: {a: ''}, type: Object},
{instance: /foo/, type: RegExp},
{instance: "bar", type: String}
];

for (i = 0; i < objects.length; i++)
{
instance = objects[i].instance;
type     = objects[i].type;
expect   = type.prototype;
actual   = Object.getPrototypeOf(instance);
reportCompare(expect, actual, summary + ' instance: ' + instance + ', type: ' + type.name);
}

//   exitFunc ('test');
}

}}).endType()
