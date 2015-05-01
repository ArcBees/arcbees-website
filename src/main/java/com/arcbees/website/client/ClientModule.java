/*
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

import com.arcbees.analytics.client.AnalyticsModule;
import com.arcbees.website.client.application.ApplicationModule;
import com.arcbees.website.client.resources.ResourceLoader;
import com.arcbees.website.shared.NameTokens;
import com.google.gwt.inject.client.AbstractGinModule;
import com.gwtplatform.mvp.client.annotations.DefaultPlace;
import com.gwtplatform.mvp.client.annotations.ErrorPlace;
import com.gwtplatform.mvp.client.annotations.UnauthorizedPlace;
import com.gwtplatform.mvp.client.gin.DefaultModule;
import com.gwtplatform.mvp.client.gin.DefaultModule.Builder;
import com.gwtplatform.mvp.shared.proxy.RouteTokenFormatter;

public class ClientModule extends AbstractGinModule {
    @Override
    protected void configure() {
        DefaultModule defaultModule = new Builder()
                .tokenFormatter(RouteTokenFormatter.class)
                .placeManager(PlaceManagerImpl.class)
                .build();
        install(defaultModule);

        install(new ApplicationModule());
        install(new AnalyticsModule.Builder("UA-41550930-11").autoCreate(false).build());

        bind(ResourceLoader.class).asEagerSingleton();

        bindConstant().annotatedWith(DefaultPlace.class).to(NameTokens.HOME);
        bindConstant().annotatedWith(ErrorPlace.class).to(NameTokens.NOTFOUND);
        bindConstant().annotatedWith(UnauthorizedPlace.class).to(NameTokens.HOME);

        requestStaticInjection(NameTokens.class);
    }
}
