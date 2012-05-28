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
import com.arcbees.hive.client.application.home.consulting.ConsultingPresenter;
import com.arcbees.hive.client.application.home.consulting.ConsultingView;
import com.arcbees.hive.client.application.home.development.DevelopmentPresenter;
import com.arcbees.hive.client.application.home.development.DevelopmentView;
import com.arcbees.hive.client.application.home.slogan.SloganModule;
import com.arcbees.hive.client.application.home.successstory.SuccessStoryPresenter;
import com.arcbees.hive.client.application.home.successstory.SuccessStoryView;
import com.google.inject.TypeLiteral;
import com.gwtplatform.mvp.client.gin.AbstractPresenterModule;

/**
 * @author Christian Goudreau
 */
public class HomeModule extends AbstractPresenterModule {
    @Override
    protected void configure() {
        bind(new TypeLiteral<UiHandlersStrategy<HomeUiHandlers>>() {
        }).to(
                new TypeLiteral<ProviderUiHandlersStrategy<HomeUiHandlers>>() {
                });

        bindPresenter(HomePresenter.class, HomePresenter.MyView.class,
                HomeView.class, HomePresenter.MyProxy.class);
        bindPresenter(ConsultingPresenter.class, ConsultingPresenter.MyView.class,
                ConsultingView.class, ConsultingPresenter.MyProxy.class);
        bindPresenter(DevelopmentPresenter.class,
                DevelopmentPresenter.MyView.class, DevelopmentView.class,
                DevelopmentPresenter.MyProxy.class);
        bindPresenter(SuccessStoryPresenter.class,
                SuccessStoryPresenter.MyView.class, SuccessStoryView.class,
                SuccessStoryPresenter.MyProxy.class);

        bind(HomeUiHandlers.class).to(HomePresenter.class);

        install(new SloganModule());
        install(new BlogModule());
    }
}
