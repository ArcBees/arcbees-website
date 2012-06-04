package com.arcbees.hive.client.application.companyhistory;

import com.arcbees.core.client.mvp.ViewImpl;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.user.client.ui.Widget;

import javax.inject.Inject;

public class CompanyHistoryView extends ViewImpl implements CompanyHistoryPresenter.MyView {
    public interface Binder extends UiBinder<Widget, CompanyHistoryView> {
    }

    @Inject
    public CompanyHistoryView(final Binder binder) {
        initWidget(binder.createAndBindUi(this));
    }
}
