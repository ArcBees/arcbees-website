package com.arcbees.hive.client.application.companyhistory;

import javax.inject.Inject;

import com.arcbees.hive.client.application.common.AppPresenter;
import com.arcbees.hive.client.application.common.event.ResizeEvent;
import com.arcbees.hive.client.place.NameTokens;
import com.google.web.bindery.event.shared.EventBus;
import com.gwtplatform.mvp.client.Presenter;
import com.gwtplatform.mvp.client.View;
import com.gwtplatform.mvp.client.annotations.NameToken;
import com.gwtplatform.mvp.client.annotations.ProxyStandard;
import com.gwtplatform.mvp.client.proxy.ProxyPlace;
import com.gwtplatform.mvp.client.proxy.RevealContentEvent;

public class CompanyHistoryPresenter extends Presenter<CompanyHistoryPresenter.MyView, CompanyHistoryPresenter.MyProxy> {
    @ProxyStandard
    @NameToken(NameTokens.companyhistory)
    interface MyProxy extends ProxyPlace<CompanyHistoryPresenter> {
    }

    interface MyView extends View {
    }

    @Inject
    CompanyHistoryPresenter(EventBus eventBus,
                            MyView view,
                            MyProxy proxy) {
        super(eventBus, view, proxy);
    }

    @Override
    protected void revealInParent() {
        RevealContentEvent.fire(this, AppPresenter.SLOT_SetMainContent, this);
    }

    @Override
    protected void onReveal() {
        super.onReveal();

        ResizeEvent.fire(this, AppPresenter.SLOT_SetMainContent,
                getView().asWidget().getOffsetHeight());
    }
}
