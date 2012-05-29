package com.arcbees.hive.client.application.common;

import com.arcbees.core.client.mvp.ViewImpl;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.user.client.ui.Widget;

import javax.inject.Inject;

public class CustomersView extends ViewImpl implements CustomersPresenter.MyView {
    public interface Binder extends UiBinder<Widget, CustomersView> {

    }

    @Inject
    public CustomersView(final Binder binder) {
        initWidget(binder.createAndBindUi(this));
    }

    @Override
    public native void startCarousel() /*-{
        $wnd.$('#carousel').rcarousel(
                {
                    width:50,
                    height:50,
                    visible:4,
                    step:4,
                    speed:300});
    }-*/;
}
