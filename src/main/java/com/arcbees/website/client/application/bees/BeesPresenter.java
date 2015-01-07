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

package com.arcbees.website.client.application.bees;

import com.arcbees.website.client.NameTokens;
import com.arcbees.website.client.application.ApplicationPresenter;
import com.google.gwt.event.shared.GwtEvent;
import com.google.inject.Inject;
import com.google.web.bindery.event.shared.EventBus;
import com.gwtplatform.mvp.client.HasUiHandlers;
import com.gwtplatform.mvp.client.Presenter;
import com.gwtplatform.mvp.client.View;
import com.gwtplatform.mvp.client.annotations.ContentSlot;
import com.gwtplatform.mvp.client.annotations.NameToken;
import com.gwtplatform.mvp.client.annotations.ProxyStandard;
import com.gwtplatform.mvp.client.proxy.PlaceManager;
import com.gwtplatform.mvp.client.proxy.ProxyPlace;
import com.gwtplatform.mvp.client.proxy.RevealContentHandler;
import com.gwtplatform.mvp.shared.proxy.PlaceRequest;

public class BeesPresenter extends Presenter<BeesPresenter.MyView, BeesPresenter.MyProxy>
        implements KonamiEvent.KonamiHandler, BeesUiHandlers {
    interface MyView extends View, HasUiHandlers<BeesUiHandlers> {
        void konami();
    }

    @ContentSlot
    public static final GwtEvent.Type<RevealContentHandler<?>> SLOT_BEE = new GwtEvent.Type<>();

    @ProxyStandard
    @NameToken(NameTokens.BEES)
    interface MyProxy extends ProxyPlace<BeesPresenter> {
    }

    private final PlaceManager placeManager;

    @Inject
    BeesPresenter(
            EventBus eventBus,
            MyView view,
            PlaceManager placeManager,
            MyProxy proxy) {
        super(eventBus, view, proxy, ApplicationPresenter.SLOT_MAIN);

        this.placeManager = placeManager;

        getView().setUiHandlers(this);
    }

    @Override
    public void onKonami(KonamiEvent event) {
        getView().konami();
    }

    @Override
    public void hidePopup() {
        clearSlot(SLOT_BEE);
        placeManager.revealPlace(new PlaceRequest.Builder().nameToken(NameTokens.BEES).build());
    }

    @Override
    protected void onBind() {
        super.onBind();

        addRegisteredHandler(KonamiEvent.getType(), this);
    }
}