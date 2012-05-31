package com.arcbees.hive.client.application.common.navbar;

import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;

import javax.inject.Inject;

public class NavbarView extends Composite {
    public interface Binder extends UiBinder<Widget, NavbarView> {
    }

    @Inject
    public NavbarView(final Binder binder) {
        initWidget(binder.createAndBindUi(this));
    }
}