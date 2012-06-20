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

import com.arcbees.core.client.mvp.uihandlers.ProviderUiHandlersStrategy;
import com.arcbees.core.client.mvp.uihandlers.UiHandlersStrategy;
import com.arcbees.hive.client.application.common.navbar.NavbarModule;
import com.arcbees.hive.client.application.common.socialmedia.SocialMediaModule;
import com.google.inject.TypeLiteral;
import com.gwtplatform.mvp.client.gin.AbstractPresenterModule;

public class CommonModule extends AbstractPresenterModule {
    @Override
    protected void configure() {
        install(new SocialMediaModule());
        install(new NavbarModule());

        bindPresenter(AppPresenter.class, AppPresenter.MyView.class, AppView.class,
                AppPresenter.MyProxy.class);

        bindSingletonPresenterWidget(HeaderPresenter.class,
                HeaderPresenter.MyView.class, HeaderView.class);
        bindSingletonPresenterWidget(FooterPresenter.class,
                FooterPresenter.MyView.class, FooterView.class);
        bindSingletonPresenterWidget(CustomersPresenter.class,
                CustomersPresenter.MyView.class, CustomersView.class);

        bind(HeaderUiHandlers.class).to(HeaderPresenter.class);

        bind(new TypeLiteral<UiHandlersStrategy<HeaderUiHandlers>>() {
        }).to(
                new TypeLiteral<ProviderUiHandlersStrategy<HeaderUiHandlers>>() {
                });
    }
}
