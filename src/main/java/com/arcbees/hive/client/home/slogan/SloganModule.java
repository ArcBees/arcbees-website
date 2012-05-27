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

package com.arcbees.hive.client.home.slogan;

import com.arcbees.hive.client.mvp.strategies.UiHandlersStrategy;
import com.arcbees.hive.client.mvp.strategies.uihandlers.ProviderUiHandlersStrategy;

import com.google.inject.TypeLiteral;

import com.gwtplatform.mvp.client.gin.AbstractPresenterModule;

/**
 * @author Zachary Keatts
 */
public class SloganModule extends AbstractPresenterModule {
  @Override
  protected void configure() {
    bind(new TypeLiteral<UiHandlersStrategy<SloganUiHandlers>>() {
    }).to(
        new TypeLiteral<ProviderUiHandlersStrategy<SloganUiHandlers>>() {
        });

    bindSingletonPresenterWidget(SloganPresenter.class,
        SloganPresenter.MyView.class, SloganView.class);
    bind(SloganUiHandlers.class).to(SloganPresenter.class);
  }

}
