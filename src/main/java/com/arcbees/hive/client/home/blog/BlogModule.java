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

package com.arcbees.hive.client.home.blog;

import com.arcbees.core.client.mvp.uihandlers.ProviderUiHandlersStrategy;
import com.arcbees.core.client.mvp.uihandlers.UiHandlersStrategy;
import com.arcbees.hive.client.home.blog.ui.BlogItemWidgetFactory;
import com.google.gwt.i18n.client.DateTimeFormat;
import com.google.gwt.inject.client.assistedinject.GinFactoryModuleBuilder;
import com.google.inject.Provides;
import com.google.inject.Singleton;
import com.google.inject.TypeLiteral;
import com.google.inject.name.Named;
import com.gwtplatform.mvp.client.gin.AbstractPresenterModule;

/**
 * @author Christian Goudreau
 */
public class BlogModule extends AbstractPresenterModule {
  @Override
  protected void configure() {
    bind(new TypeLiteral<UiHandlersStrategy<BlogUiHandlers>>() {
    }).to(
        new TypeLiteral<ProviderUiHandlersStrategy<BlogUiHandlers>>() {
        });
    
    bindPresenter(BlogPresenter.class, BlogPresenter.MyView.class,
        BlogView.class, BlogPresenter.MyProxy.class);
    
    bind(BlogView.Binder.class).in(Singleton.class);
    
    bind(BlogUiHandlers.class).to(BlogPresenter.class);
    
    install(new GinFactoryModuleBuilder().build(BlogItemWidgetFactory.class));
  }
  
  @Provides @Named("BlogPostFormat")
  DateTimeFormat getDateTimeFormat() {
    return DateTimeFormat.getFormat("MMMM dd, yyyy");
  }
}
