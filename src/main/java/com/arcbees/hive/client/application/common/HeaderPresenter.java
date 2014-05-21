/*
 * Copyright 2010 ArcBees Inc.
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

package com.arcbees.hive.client.application.common;

import javax.inject.Inject;

import com.google.gwt.i18n.client.LocaleInfo;
import com.google.gwt.user.client.Window;
import com.google.web.bindery.event.shared.EventBus;
import com.gwtplatform.mvp.client.HasUiHandlers;
import com.gwtplatform.mvp.client.PresenterWidget;
import com.gwtplatform.mvp.client.View;
import com.gwtplatform.mvp.client.proxy.PlaceManager;

public class HeaderPresenter extends PresenterWidget<HeaderPresenter.MyView> implements HeaderUiHandlers {
    interface MyView extends View, HasUiHandlers<HeaderUiHandlers> {
    }

    private final PlaceManager placeManager;

    @Inject
    HeaderPresenter(EventBus eventBus,
                    MyView view,
                    PlaceManager placeManager) {
        super(eventBus, view);

        this.placeManager = placeManager;

        getView().setUiHandlers(this);
    }

    @Override
    public void switchLocale() {
        LocaleInfo currentLocale = LocaleInfo.getCurrentLocale();

        String newLocale;

        if (currentLocale.getLocaleName().equals("fr")) {
            newLocale = "en";
        } else {
            newLocale = "fr";
        }

        Window.Location.assign(Window.Location.createUrlBuilder()
                .setParameter(LocaleInfo.getLocaleQueryParam(), newLocale)
                .buildString());
    }
}
