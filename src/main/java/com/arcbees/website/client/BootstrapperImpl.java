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

package com.arcbees.website.client;

import javax.inject.Inject;

import com.arcbees.analytics.shared.Analytics;
import com.arcbees.analytics.shared.AnalyticsPlugin;
import com.arcbees.website.client.application.maps.GwtMapsLoader;
import com.arcbees.website.shared.NameTokens;
import com.google.common.base.Strings;
import com.google.gwt.i18n.client.LocaleInfo;
import com.google.gwt.user.client.History;
import com.gwtplatform.mvp.client.Bootstrapper;
import com.gwtplatform.mvp.client.proxy.PlaceManager;
import com.gwtplatform.mvp.shared.proxy.PlaceRequest;

public class BootstrapperImpl implements Bootstrapper {
    private final PlaceManager placeManager;
    private final GwtMapsLoader gwtMapsLoader;
    private final Analytics analytics;

    @Inject
    BootstrapperImpl(
            PlaceManager placeManager,
            GwtMapsLoader gwtMapsLoader,
            Analytics analytics) {
        this.placeManager = placeManager;
        this.gwtMapsLoader = gwtMapsLoader;
        this.analytics = analytics;
    }

    @Override
    public void onBootstrap() {
        gwtMapsLoader.loadGwtMaps();

        analytics.create().cookieDomain("arcbees.com").go();
        analytics.enablePlugin(AnalyticsPlugin.DISPLAY);
        analytics.enablePlugin(AnalyticsPlugin.ENHANCED_LINK_ATTRIBUTION);

        validateNameTokenLanguageAndRevealPlace();
    }

    private void validateNameTokenLanguageAndRevealPlace() {
        PlaceRequest currentPlaceRequest = placeManager.getCurrentPlaceRequest();
        String nameToken = Strings.nullToEmpty(History.getToken());
        String currentLocale = LocaleInfo.getCurrentLocale().getLocaleName();

        if ("en".compareToIgnoreCase(currentLocale) == 0) {
            if (!NameTokens.isEn(nameToken)) {
                revealTranslatedNameToken(currentPlaceRequest, nameToken);
                return;
            }
        } else if ("fr".compareToIgnoreCase(currentLocale) == 0) {
            if (NameTokens.isEn(nameToken)) {
                revealTranslatedNameToken(currentPlaceRequest, nameToken);
                return;
            }
        }

        placeManager.revealCurrentPlace();
    }

    private void revealTranslatedNameToken(PlaceRequest currentPlaceRequest, String nameToken) {
        PlaceRequest placeRequest = new PlaceRequest.Builder(currentPlaceRequest)
                .nameToken(NameTokens.translate(nameToken))
                .build();
        placeManager.revealPlace(placeRequest);
    }
}
