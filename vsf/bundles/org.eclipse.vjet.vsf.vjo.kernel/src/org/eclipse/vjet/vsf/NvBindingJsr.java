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
package org.eclipse.vjet.vsf;

import org.eclipse.vjet.dsf.common.binding.IValueBinding;
import org.eclipse.vjet.dsf.spec.component.IComponentSpec;
import org.eclipse.vjet.vsf.EncJsr;
import org.eclipse.vjet.vsf.IBindingJsr;
import org.eclipse.vjet.vsf.MessageJsr;
import org.eclipse.vjet.vsf.ServiceJsr;
import org.eclipse.vjet.vsf.jsref.JsFunc;
import org.eclipse.vjet.vsf.jsref.JsObj;
import org.eclipse.vjet.vsf.jsref.JsObjData;
import org.eclipse.vjet.vsf.jsref.JsTypeRef;
import org.eclipse.vjet.vsf.jsref.internals.JsCmpMeta;
import org.eclipse.vjet.vsf.resource.pattern.js.IJsResourceRef;
import org.eclipse.vjet.vsf.resource.pattern.js.JsResource;

@org.eclipse.vjet.dsf.resource.utils.CodeGen("JsrGenerator")
public class NvBindingJsr extends JsObj implements IBindingJsr {
    private static final long serialVersionUID = 1L;

    private static final JsObjData S = 
        new JsObjData("vjo.dsf.NvBinding", NvBindingJsr.class, "NvBinding");

    
    public static class ResourceSpec {
        public static IComponentSpec getInstance() {
            return S.getResourceSpec(); 
        }
        public static final JsResource RESOURCE = S.getJsResource();
        public static final IJsResourceRef REF = S.getJsResourceRef();
    }

    public static final IComponentSpec SPEC = S.getResourceSpec()
        .addDependentComponent(IBindingJsr.ResourceSpec.getInstance())
        .addDependentComponent(ServiceJsr.ResourceSpec.getInstance())
        .addDependentComponent(EncJsr.ResourceSpec.getInstance())
        .addDependentComponent(MessageJsr.ResourceSpec.getInstance());

    public NvBindingJsr(){
        super(S.getJsCmpMeta(), true);
    }

    protected NvBindingJsr(JsCmpMeta cmpMeta, boolean isInstance, Object... args) {
        super(cmpMeta, isInstance, args);
    }

    public JsFunc<String> serialize(MessageJsr message){
        return call(String.class, "serialize").with(message);
    }

    public JsFunc<String> serialize(IValueBinding<? extends MessageJsr> message){
        return call(String.class, "serialize").with(message);
    }

    public JsFunc<Void> deserialize(MessageJsr message){
        return call("deserialize").with(message);
    }

    public JsFunc<Void> deserialize(IValueBinding<? extends MessageJsr> message){
        return call("deserialize").with(message);
    }
    
    public static JsTypeRef<NvBindingJsr> prototype = new JsTypeRef<NvBindingJsr>(S);
}