/*******************************************************************************
 * Copyright (c) 2005, 2012 eBay Inc.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/
package org.eclipse.vjet.dsf.jsnative;

import org.eclipse.vjet.dsf.javatojs.anno.AJavaOnly;
import org.eclipse.vjet.dsf.javatojs.anno.ARename;
import org.eclipse.vjet.dsf.jsnative.anno.Alias;
import org.eclipse.vjet.dsf.jsnative.anno.DOMSupport;
import org.eclipse.vjet.dsf.jsnative.anno.DomLevel;
import org.eclipse.vjet.dsf.jsnative.anno.Function;
import org.eclipse.vjet.dsf.jsnative.anno.JsMetatype;
import org.eclipse.vjet.dsf.jsnative.anno.Property;

/**
 * http://www.w3.org/TR/REC-html40/struct/tables.html#edef-TR
 */
@Alias("HTMLTableRowElement")
@DOMSupport(DomLevel.ONE)
@JsMetatype
public interface HtmlTableRow extends HtmlElement {
	
	/** "left" */
	@AJavaOnly @ARename(name="'left'")
	String ALIGN_LEFT =    "left" ;
	/** "center" */
	@AJavaOnly @ARename(name="'center'")
	String ALIGN_CENTER =  "center" ; // ignoreHtmlKeyword
	/** "right" */
	@AJavaOnly @ARename(name="'right'")
	String ALIGN_RIGHT =   "right" ;
	/** "justify" */
	@AJavaOnly @ARename(name="'justify'")
	String ALIGN_JUSTIFY = "justify" ;
	/** "char" */
	@AJavaOnly @ARename(name="'char'")
	String ALIGN_CHAR =    "char" ;

	/** "top" */
	@AJavaOnly @ARename(name="'top'")
	String VALIGN_TOP =      "top" ;
	/** "middle" */
	@AJavaOnly @ARename(name="'middle'")
	String VALIGN_MIDDLE =   "middle" ;
	/** "bottom" */
	@AJavaOnly @ARename(name="'bottom'")
	String VALIGN_BOTTOM =   "bottom" ;
	/** "baseline" */
	@AJavaOnly @ARename(name="'baseline'")
	String VALIGN_BASELINE = "baseline" ;
	
	@Property int getRowIndex();

    @Property int getSectionRowIndex();

    @Property HtmlCollection getCells();

    @Property String getAlign();
    @Property void setAlign(String align);

    @Property String getBgColor();
    @Property void setBgColor(String bgColor);

    @Property String getCh();
    @Property void setCh(String ch);

    @Property String getChOff();
    @Property void setChOff(String chOff);

    @Property String getVAlign();
    @Property void setVAlign(String vAlign);
    
	
	@DOMSupport(DomLevel.ZERO)
	@Property(name="onblur")
	Object getOnBlur();
	
	
	@DOMSupport(DomLevel.ZERO)
	@Property(name="onblur")
	void setOnBlur(Object functionRef);
	
	
	@DOMSupport(DomLevel.ZERO)
	@Property(name="onfocus")
	Object getOnFocus();
	
	
	@DOMSupport(DomLevel.ZERO)
	@Property(name="onfocus")
	void setOnFocus(Object functionRef);
	
	
	@DOMSupport(DomLevel.ZERO)
	@Property(name="onkeydown")
	Object getOnKeyDown();
	
	
	@DOMSupport(DomLevel.ZERO)
	@Property(name="onkeydown")
	void setOnKeyDown(Object functionRef);
	
	
	@DOMSupport(DomLevel.ZERO)
	@Property(name="onkeypress")
	Object getOnKeyPress();
	
	
	@DOMSupport(DomLevel.ZERO)
	@Property(name="onkeypress")
	void setOnKeyPress(Object functionRef);
	
	
	@DOMSupport(DomLevel.ZERO)
	@Property(name="onkeyup")
	Object getOnKeyUp();
	
	
	@DOMSupport(DomLevel.ZERO)
	@Property(name="onkeyup")
	void setOnKeyUp(Object functionRef);
	
	
	@DOMSupport(DomLevel.ZERO)
	@Property(name="onclick")
	Object getOnClick();
	
	
	@DOMSupport(DomLevel.ZERO)
	@Property(name="onclick")
	void setOnClick(Object functionRef);
	
	
	@DOMSupport(DomLevel.ZERO)
	@Property(name="ondblclick")
	Object getOnDblClick();
	
	
	@DOMSupport(DomLevel.ZERO)
	@Property(name="ondblclick")
	void setOnDblClick(Object functionRef);
	
	
	@DOMSupport(DomLevel.ZERO)
	@Property(name="onmousedown")
	Object getOnMouseDown();
	
	
	@DOMSupport(DomLevel.ZERO)
	@Property(name="onmousedown")
	void setOnMouseDown(Object functionRef);
	
	
	@DOMSupport(DomLevel.ZERO)
	@Property(name="onmouseup")
	Object getOnMouseUp();
	
	
	@DOMSupport(DomLevel.ZERO)
	@Property(name="onmouseup")
	void setOnMouseUp(Object functionRef);
	
	
	@DOMSupport(DomLevel.ZERO)
	@Property(name="onmousemove")
	Object getOnMouseMove();
	
	
	@DOMSupport(DomLevel.ZERO)
	@Property(name="onmousemove")
	void setOnMouseMove(Object functionRef);
	
	
	@DOMSupport(DomLevel.ZERO)
	@Property(name="onmouseout")
	Object getOnMouseOut();
	
	
	@DOMSupport(DomLevel.ZERO)
	@Property(name="onmouseout")
	void setOnMouseOut(Object functionRef);
	
	
	@DOMSupport(DomLevel.ZERO)
	@Property(name="onmouseover")
	Object getOnMouseOver();
	
	
	@DOMSupport(DomLevel.ZERO)
	@Property(name="onmouseover")
	void setOnMouseOver(Object functionRef);

    @Function HtmlTableCell insertCell(int index);

    @Function void deleteCell(int index);

}
