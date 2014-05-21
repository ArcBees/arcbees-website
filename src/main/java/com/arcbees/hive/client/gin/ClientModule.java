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

package com.arcbees.hive.client.gin;

import com.arcbees.hive.client.application.blog.BlogModule;
import com.arcbees.hive.client.application.companyhistory.CompanyHistoryModule;
import com.arcbees.hive.client.application.team.TeamModule;
import com.arcbees.hive.client.resource.Resources;
import com.arcbees.hive.client.application.common.CommonModule;
import com.arcbees.hive.client.application.contact.ContactModule;
import com.arcbees.hive.client.application.home.HomeModule;
import com.arcbees.hive.client.application.jobs.JobsModule;
import com.arcbees.hive.client.place.NameTokens;
import com.arcbees.hive.client.application.products.ProductsModule;
import com.arcbees.hive.client.application.service.ServiceModule;

import com.arcbees.hive.client.resource.ResourcesLoader;
import com.arcbees.hive.client.resource.socialmedia.SocialMediaResources;
import com.google.gwt.inject.client.AbstractGinModule;
import com.google.inject.Singleton;

import com.gwtplatform.dispatch.client.actionhandler.caching.Cache;
import com.gwtplatform.dispatch.client.actionhandler.caching.DefaultCacheImpl;
import com.gwtplatform.mvp.client.annotations.DefaultPlace;
import com.gwtplatform.mvp.client.annotations.ErrorPlace;
import com.gwtplatform.mvp.client.annotations.GaAccount;
import com.gwtplatform.mvp.client.annotations.UnauthorizedPlace;
import com.gwtplatform.mvp.client.gin.DefaultModule;
import com.gwtplatform.mvp.client.googleanalytics.GoogleAnalyticsNavigationTracker;
import com.gwtplatform.mvp.client.proxy.DefaultPlaceManager;

public class ClientModule extends AbstractGinModule {
    @Override
    protected void configure() {
        // Singleton resources
        bind(Cache.class).to(DefaultCacheImpl.class).in(Singleton.class);
        bind(Resources.class).in(Singleton.class);
        bind(SocialMediaResources.class).in(Singleton.class);
        bind(GoogleAnalyticsNavigationTracker.class).asEagerSingleton();

        // Constants
        bindConstant().annotatedWith(DefaultPlace.class).to(NameTokens.home);
        bindConstant().annotatedWith(ErrorPlace.class).to(NameTokens.home);
        bindConstant().annotatedWith(UnauthorizedPlace.class).to(NameTokens.home);
        bindConstant().annotatedWith(GaAccount.class).to("UA-19115423-2");

        bind(ResourcesLoader.class).asEagerSingleton();

        // Modules
        install(new DefaultModule(DefaultPlaceManager.class));
        install(new CommonModule());
        install(new HomeModule());
        install(new ServiceModule());
        install(new ProductsModule());
        install(new JobsModule());
        install(new TeamModule());
        install(new ContactModule());
        install(new CompanyHistoryModule());
        install(new BlogModule());
        install(new ClientDispatchModule());
    }
}
