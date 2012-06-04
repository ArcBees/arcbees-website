package com.arcbees.hive.client.application.uxdesign;

import com.arcbees.core.client.mvp.ViewImpl;
import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.user.client.ui.Widget;

import javax.inject.Inject;

public class UxdesignView extends ViewImpl implements UxdesignPresenter.MyView {
    public interface Binder extends UiBinder<Widget, UxdesignView> {
    }

    @Inject
    public UxdesignView(final Binder binder) {
        initWidget(binder.createAndBindUi(this));
    }
}
