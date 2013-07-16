/*******************************************************************************
 * Copyright (c) 2005, 2012 eBay Inc.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/
package org.eclipse.vjet.dsf.active.dom.html;

import org.eclipse.vjet.dsf.html.dom.DArea;
import org.eclipse.vjet.dsf.html.dom.EHtmlAttr;
import org.eclipse.vjet.dsf.jsnative.HtmlArea;
import org.eclipse.vjet.dsf.jsnative.anno.BrowserType;

public class AHtmlArea extends AHtmlElement implements HtmlArea {
	
	private static final long serialVersionUID = 1L;
	
	protected AHtmlArea(AHtmlDocument doc, DArea ta) {
		super(doc, ta);
		populateScriptable(AHtmlArea.class, doc == null ? BrowserType.IE_6P : doc.getBrowserType());
	}

	public String getAccessKey() {
		return getDArea().getHtmlAccessKey();
	}

	public String getAlt() {
		return getDArea().getHtmlAlt();
	}

	public String getCoords() {
		return getDArea().getHtmlCoords();
	}

	public String getHref() {
		return getDArea().getHtmlHref();
	}


	public boolean getNoHref() {
		return AHtmlHelper.booleanValueOf(EHtmlAttr.nohref,getHtmlAttribute(EHtmlAttr.nohref));
	}

	public String getShape() {
		return getDArea().getHtmlShape();
	}

	public int getTabIndex() {
		return getDArea().getHtmlTabIndex();
	}

	public String getTarget() {
		return getDArea().getHtmlTarget();
	}

	public void setAccessKey(String accessKey) {
		getDArea().setHtmlAccessKey(accessKey);
		onAttrChange(EHtmlAttr.accesskey, accessKey);
	}

	public void setAlt(String alt) {
		getDArea().setHtmlAlt(alt);
		onAttrChange(EHtmlAttr.alt, alt);
	}

	public void setCoords(String coords) {
		getDArea().setHtmlCoords(coords);
		onAttrChange(EHtmlAttr.coords, coords);
	}

	public void setHref(String href) {
		getDArea().setHtmlHref(href);
		onAttrChange(EHtmlAttr.href, href);
	}

	public void setNoHref(boolean noHref) {
		setHtmlAttribute(EHtmlAttr.nohref, noHref);
		onAttrChange(EHtmlAttr.nohref, noHref);
	}

	public void setShape(String shape) {
		getDArea().setHtmlShape(shape);
		onAttrChange(EHtmlAttr.shape, shape);
	}

	public void setTabIndex(int tabIndex) {
		getDArea().setHtmlTabIndex(tabIndex);
		onAttrChange(EHtmlAttr.tabindex, String.valueOf(tabIndex));
	}

	public void setTarget(String target) {
		getDArea().setHtmlTarget(target);
		onAttrChange(EHtmlAttr.target, target);
	}
	
	// Since property name is 'onblur', Rhino invokes this method.
	public Object getOnblur() {
		return getOnBlur();
	}
	
	// Since property name is 'onfocus', Rhino invokes this method.
	public Object getOnfocus() {
		return getOnFocus();
	}
	
	// For Rhino
	public void setOnblur(Object functionRef) {
		setOnBlur(functionRef);
	}
	
	// For Rhino
	public void setOnfocus(Object functionRef) {
		setOnFocus(functionRef);
	}
	
	// Since property name is 'onkeydown', Rhino invokes this method.
	public Object getOnkeydown() {
		return getOnKeyDown();
	}
	
	// For Rhino
	public void setOnkeydown(Object functionRef) {
		setOnKeyDown(functionRef);
	}
	
	// Since property name is 'onkeypress', Rhino invokes this method.
	public Object getOnkeypress() {
		return getOnKeyPress();
	}
	
	// For Rhino
	public void setOnkeypress(Object functionRef) {
		setOnKeyPress(functionRef);
	}
	
	// Since property name is 'onkeyup', Rhino invokes this method.
	public Object getOnkeyup() {
		return getOnKeyUp();
	}
	
	// For Rhino
	public void setOnkeyup(Object functionRef) {
		setOnKeyUp(functionRef);
	}
	
	// Since property name is 'onclick', Rhino invokes this method.
	public Object getOnclick() {
		return getOnClick();
	}
	
	// For Rhino
	public void setOnclick(Object functionRef) {
		setOnClick(functionRef);
	}
	
	// Since property name is 'ondblclick', Rhino invokes this method.
	public Object getOndblclick() {
		return getOnDblClick();
	}
	
	// For Rhino
	public void setOndblclick(Object functionRef) {
		setOnDblClick(functionRef);
	}
	
	// Since property name is 'onmousedown', Rhino invokes this method.
	public Object getOnmousedown() {
		return getOnMouseDown();
	}
	
	// For Rhino
	public void setOnmousedown(Object functionRef) {
		setOnMouseDown(functionRef);
	}
	
	// Since property name is 'onmousemove', Rhino invokes this method.
	public Object getOnmousemove() {
		return getOnMouseMove();
	}
	
	// For Rhino
	public void setOnmousemove(Object functionRef) {
		setOnMouseMove(functionRef);
	}
	
	// Since property name is 'onmouseout', Rhino invokes this method.
	public Object getOnmouseout() {
		return getOnMouseOut();
	}
	
	// For Rhino
	public void setOnmouseout(Object functionRef) {
		setOnMouseOut(functionRef);
	}
	
	// Since property name is 'onmouseover', Rhino invokes this method.
	public Object getOnmouseover() {
		return getOnMouseOver();
	}
	
	// For Rhino
	public void setOnmouseover(Object functionRef) {
		setOnMouseOver(functionRef);
	}
	
	// Since property name is 'onmouseup', Rhino invokes this method.
	public Object getOnmouseup() {
		return getOnMouseUp();
	}
	
	// For Rhino
	public void setOnmouseup(Object functionRef) {
		setOnMouseUp(functionRef);
	}
	
	private DArea getDArea() {
		return (DArea) getDNode();
	}

}