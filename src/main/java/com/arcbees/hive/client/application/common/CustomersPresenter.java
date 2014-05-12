package com.arcbees.hive.client.application.common;

import com.google.web.bindery.event.shared.EventBus;
import com.gwtplatform.mvp.client.PresenterWidget;
import com.gwtplatform.mvp.client.View;

import javax.inject.Inject;

public class CustomersPresenter extends PresenterWidget<CustomersPresenter.MyView> {
    public interface MyView extends View {

        void startCarousel();
    }

    @Inject
    public CustomersPresenter(final EventBus eventBus,
                              final MyView view) {
        super(eventBus, view);
    }

    @Override
    protected void onReveal() {
        super.onReveal();

//        getView().startTimer();
    }
}
