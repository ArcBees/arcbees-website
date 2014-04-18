package com.arcbees.hive.client.application.companyhistory;

import javax.inject.Inject;

import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.user.client.ui.Widget;
import com.gwtplatform.mvp.client.ViewImpl;

public class CompanyHistoryView extends ViewImpl implements CompanyHistoryPresenter.MyView {
    public interface Binder extends UiBinder<Widget, CompanyHistoryView> {
    }

    @Inject
    public CompanyHistoryView(final Binder binder) {
        initWidget(binder.createAndBindUi(this));
    }
}
