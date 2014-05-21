package com.arcbees.hive.client.application.common.navbar;

import javax.inject.Inject;

import com.google.web.bindery.event.shared.EventBus;
import com.gwtplatform.mvp.client.PresenterWidget;
import com.gwtplatform.mvp.client.View;
import com.gwtplatform.mvp.client.proxy.NavigationEvent;
import com.gwtplatform.mvp.client.proxy.NavigationHandler;
import com.gwtplatform.mvp.client.proxy.PlaceManager;
import com.gwtplatform.mvp.shared.proxy.PlaceRequest;

public class NavbarPresenter extends PresenterWidget<NavbarPresenter.MyView> implements NavigationHandler {
    public interface MyView extends View {
        void activateCurrentLink(String nameToken);
    }

    private final PlaceManager placeManager;

    @Inject
    public NavbarPresenter(final EventBus eventBus, final MyView view,
                           final PlaceManager placeManager) {
        super(eventBus, view);
        this.placeManager = placeManager;

        eventBus.addHandler(NavigationEvent.getType(), this);
    }

    @Override
    protected void onBind() {
        super.onBind();

        PlaceRequest placeRequest = placeManager.getCurrentPlaceRequest();
        String nameToken = placeRequest.getNameToken();

        getView().activateCurrentLink(nameToken);
    }

    @Override
    public void onNavigation(NavigationEvent navigationEvent) {
        String nameToken = navigationEvent.getRequest().getNameToken();

        getView().activateCurrentLink(nameToken);
    }
}
