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

package com.arcbees.hive.client.application.home;

import com.arcbees.core.client.mvp.uihandlers.ProviderUiHandlersStrategy;
import com.arcbees.core.client.mvp.uihandlers.UiHandlersStrategy;
import com.arcbees.hive.client.application.home.blog.BlogModule;
import com.arcbees.hive.client.application.home.slogan.SloganModule;
import com.google.inject.TypeLiteral;
import com.gwtplatform.mvp.client.gin.AbstractPresenterModule;

public class HomeModule extends AbstractPresenterModule {
    @Override
    protected void configure() {
        bind(new TypeLiteral<UiHandlersStrategy<HomeUiHandlers>>() {
        }).to(
                new TypeLiteral<ProviderUiHandlersStrategy<HomeUiHandlers>>() {
                });

        bindPresenter(HomePresenter.class, HomePresenter.MyView.class,
                HomeView.class, HomePresenter.MyProxy.class);

        bind(HomeUiHandlers.class).to(HomePresenter.class);

        install(new SloganModule());
        install(new BlogModule());
    }
}
