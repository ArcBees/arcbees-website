package com.arcbees.hive.client.application.uxdesign;

import com.gwtplatform.mvp.client.gin.AbstractPresenterModule;

public class UxdesignModule extends AbstractPresenterModule {
    @Override
    protected void configure() {
        bindPresenter(UxdesignPresenter.class, UxdesignPresenter.MyView.class, UxdesignView.class,
                UxdesignPresenter.MyProxy.class);
    }
}
