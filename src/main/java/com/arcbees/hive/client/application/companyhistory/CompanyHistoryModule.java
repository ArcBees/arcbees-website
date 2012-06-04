package com.arcbees.hive.client.application.companyhistory;

import com.gwtplatform.mvp.client.gin.AbstractPresenterModule;

public class CompanyHistoryModule extends AbstractPresenterModule {
    @Override
    protected void configure() {
        bindPresenter(CompanyHistoryPresenter.class, CompanyHistoryPresenter.MyView.class, CompanyHistoryView.class,
                CompanyHistoryPresenter.MyProxy.class);
    }
}
