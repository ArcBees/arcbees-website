package com.arcbees.website.client;

import javax.inject.Inject;

import com.arcbees.analytics.shared.Analytics;
import com.google.gwt.place.shared.PlaceHistoryHandler.Historian;
import com.google.web.bindery.event.shared.EventBus;
import com.gwtplatform.mvp.client.annotations.DefaultPlace;
import com.gwtplatform.mvp.client.annotations.ErrorPlace;
import com.gwtplatform.mvp.client.annotations.UnauthorizedPlace;
import com.gwtplatform.mvp.client.proxy.DefaultPlaceManager;
import com.gwtplatform.mvp.shared.proxy.TokenFormatter;

public class PlaceManagerImpl extends DefaultPlaceManager {
    private final Analytics analytics;

    @Inject
    public PlaceManagerImpl(
            EventBus eventBus,
            TokenFormatter tokenFormatter,
            Analytics analytics,
            @DefaultPlace String defaultPlaceNameToken,
            @ErrorPlace String errorPlaceNameToken,
            @UnauthorizedPlace String unauthorizedPlaceNameToken,
            Historian historian) {
        super(eventBus, tokenFormatter, defaultPlaceNameToken, errorPlaceNameToken, unauthorizedPlaceNameToken,
                historian);

        this.analytics = analytics;
    }

    @Override
    public void revealErrorPlace(String invalidHistoryToken) {
        super.revealErrorPlace(invalidHistoryToken);

        // TODO : Do analytics with invalidHistoryToken
    }
}
