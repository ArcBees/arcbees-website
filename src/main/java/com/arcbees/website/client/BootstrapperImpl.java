package com.arcbees.website.client;

import java.util.ArrayList;

import javax.inject.Inject;

import com.google.gwt.event.shared.GwtEvent;
import com.google.gwt.event.shared.HasHandlers;
import com.google.gwt.maps.client.LoadApi;
import com.google.web.bindery.event.shared.EventBus;
import com.gwtplatform.mvp.client.Bootstrapper;
import com.gwtplatform.mvp.client.proxy.PlaceManager;

public class BootstrapperImpl implements Bootstrapper, HasHandlers {
    private final PlaceManager placeManager;
    private final EventBus eventBus;

    @Inject
    BootstrapperImpl(PlaceManager placeManager,
                     EventBus eventBus) {
        this.placeManager = placeManager;
        this.eventBus = eventBus;
    }

    @Override
    public void onBootstrap() {
        ArrayList<LoadApi.LoadLibrary> libraries = new ArrayList<>();
        libraries.add(LoadApi.LoadLibrary.ADSENSE);
        libraries.add(LoadApi.LoadLibrary.DRAWING);

        LoadApi.go(new Runnable() {
            @Override
            public void run() {
                GwtMapsLoadedEvent.fire(BootstrapperImpl.this);
            }
        }, libraries, true);

        placeManager.revealCurrentPlace();
    }

    @Override
    public void fireEvent(GwtEvent<?> event) {
        eventBus.fireEvent(event);
    }
}
