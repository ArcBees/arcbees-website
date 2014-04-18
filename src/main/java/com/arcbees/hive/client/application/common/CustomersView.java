package com.arcbees.hive.client.application.common;

import javax.inject.Inject;

import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.user.client.ui.Widget;
import com.gwtplatform.mvp.client.ViewImpl;

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
                {auto:{enabled:false, interval:15000},
                    navigation:{next:"#sliderCustomersNext", prev:"#sliderCustomersPrev"},
                    width:190,
                    height:45,
                    visible:4,
                    step:4,
                    speed:600});
    }-*/;
}
