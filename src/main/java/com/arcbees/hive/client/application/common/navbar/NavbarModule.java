package com.arcbees.hive.client.application.common.navbar;

import com.gwtplatform.mvp.client.gin.AbstractPresenterModule;

public class NavbarModule extends AbstractPresenterModule {
    @Override
    protected void configure() {
        bindSingletonPresenterWidget(NavbarPresenter.class, NavbarPresenter.MyView.class, NavbarView.class);
    }
}
