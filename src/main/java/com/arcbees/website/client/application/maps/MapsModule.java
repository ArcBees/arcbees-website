package com.arcbees.website.client.application.maps;

import javax.inject.Singleton;

import com.google.gwt.inject.client.AbstractGinModule;

public class MapsModule extends AbstractGinModule {
    @Override
    protected void configure() {
        bind(GwtMapsLoader.class).to(GwtMapsLoaderImpl.class).in(Singleton.class);
    }
}
