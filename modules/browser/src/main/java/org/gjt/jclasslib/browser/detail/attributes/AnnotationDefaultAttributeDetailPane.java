/*
    This library is free software; you can redistribute it and/or
    modify it under the terms of the GNU General Public
    License as published by the Free Software Foundation; either
    version 2 of the license, or (at your option) any later version.
*/
package org.gjt.jclasslib.browser.detail.attributes;

import org.gjt.jclasslib.browser.BrowserServices;
import org.gjt.jclasslib.browser.detail.FixedListDetailPane;
import org.gjt.jclasslib.structures.attributes.AnnotationDefaultAttribute;
import org.gjt.jclasslib.util.ExtendedJLabel;

import javax.swing.tree.TreePath;

/**
 * Detail pane showing <tt>AnnotationDefault</tt>  attribute.
 *
 * @author <a href="mailto:vitor.carreira@gmail.com">Vitor Carreira</a>
 *
 */
public class AnnotationDefaultAttributeDetailPane extends FixedListDetailPane {

    private ExtendedJLabel lblTag;
    private ExtendedJLabel lblTagVerbose;

    public AnnotationDefaultAttributeDetailPane(BrowserServices services) {
        super(services);
    }

    protected void setupLabels() {
        addDetailPaneEntry(normalLabel("Default value:"),
                lblTag = highlightLabel(),
                lblTagVerbose = highlightLabel());
    }

    public void show(TreePath treePath) {
        AnnotationDefaultAttribute ada = (AnnotationDefaultAttribute)findAttribute(treePath);

        String name = ada.getDefaultValue().getEntryName();
        lblTag.setText(name);
        lblTagVerbose.setText("<" + ada.getDefaultValue().getElementValueType().getVerbose() + ">");

        super.show(treePath);
    }
}
