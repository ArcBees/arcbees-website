/*
 * Copyright 2014 ArcBees Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */

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
