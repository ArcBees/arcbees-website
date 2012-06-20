package com.arcbees.hive.client.application.common.navbar;

import com.google.web.bindery.event.shared.EventBus;
import com.gwtplatform.mvp.client.PresenterWidget;
import com.gwtplatform.mvp.client.View;
import com.gwtplatform.mvp.client.proxy.NavigationEvent;
import com.gwtplatform.mvp.client.proxy.NavigationHandler;

import javax.inject.Inject;

public class NavbarPresenter extends PresenterWidget<NavbarPresenter.MyView> implements NavigationHandler {
    public interface MyView extends View {
        void activateCurrentLink(String nameToken);
    }

    @Inject
    public NavbarPresenter(final EventBus eventBus, final MyView view) {
        super(eventBus, view);

        eventBus.addHandler(NavigationEvent.getType(), this);
    }

    @Override
    public void onNavigation(NavigationEvent navigationEvent) {
        String nameToken = navigationEvent.getRequest().getNameToken();

        getView().activateCurrentLink(nameToken);
    }
}
