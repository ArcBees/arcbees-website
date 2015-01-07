package com.arcbees.seo.widget;

import com.google.gwt.user.client.ui.HasText;

public abstract class TextNode extends BaseNode implements HasText {
    @Override
    public String getText() {
        return asWidget().getElement().getInnerText();
    }

    @Override
    public void setText(String text) {
        asWidget().getElement().setInnerText(text);
    }
}
