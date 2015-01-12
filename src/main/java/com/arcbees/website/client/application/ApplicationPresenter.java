/**
 * Copyright 2015 ArcBees Inc.
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

package com.arcbees.website.client.application;

import com.arcbees.analytics.shared.Analytics;
import com.google.gwt.event.shared.GwtEvent;
import com.google.inject.Inject;
import com.google.web.bindery.event.shared.EventBus;
import com.gwtplatform.mvp.client.Presenter;
import com.gwtplatform.mvp.client.View;
import com.gwtplatform.mvp.client.annotations.ContentSlot;
import com.gwtplatform.mvp.client.annotations.ProxyStandard;
import com.gwtplatform.mvp.client.proxy.NavigationEvent;
import com.gwtplatform.mvp.client.proxy.NavigationHandler;
import com.gwtplatform.mvp.client.proxy.PlaceManager;
import com.gwtplatform.mvp.client.proxy.Proxy;
import com.gwtplatform.mvp.client.proxy.RevealContentHandler;

public class ApplicationPresenter extends Presenter<ApplicationPresenter.MyView, ApplicationPresenter.MyProxy>
        implements NavigationHandler {
    @ProxyStandard
    interface MyProxy extends Proxy<ApplicationPresenter> {
    }

    interface MyView extends View {
    }

    @ContentSlot
    public static final GwtEvent.Type<RevealContentHandler<?>> SLOT_MAIN = new GwtEvent.Type<>();

    private final PlaceManager placeManager;
    private final Analytics analytics;

    @Inject
    ApplicationPresenter(
            EventBus eventBus,
            MyView view,
            MyProxy proxy,
            PlaceManager placeManager,
            Analytics analytics) {
        super(eventBus, view, proxy, RevealType.Root);

        this.placeManager = placeManager;
        this.analytics = analytics;

        addRegisteredHandler(NavigationEvent.getType(), this);
    }

    @Override
    public void onNavigation(NavigationEvent navigationEvent) {
        trackPageView();
    }

    @Override
    protected void onReveal() {
        super.onReveal();

        trackPageView();
    }

    private void trackPageView() {
        String historyToken = placeManager.buildHistoryToken(placeManager.getCurrentPlaceRequest());

        analytics.sendPageView()
                .documentPath(historyToken)
                .go();
    }
}
