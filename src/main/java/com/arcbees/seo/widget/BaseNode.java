package com.arcbees.seo.widget;

import com.google.gwt.user.client.ui.IsWidget;
import com.google.gwt.user.client.ui.SimplePanel;
import com.google.gwt.user.client.ui.Widget;

public abstract class BaseNode implements IsWidget {
    private final SimplePanel widget;

    public BaseNode() {
        widget = new SimplePanel();
    }

    @Override
    public Widget asWidget() {
        return widget;
    }
}
