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

package com.arcbees.website.client.application.support;

import com.google.gwt.inject.client.multibindings.GinMultibinder;
import com.google.inject.Singleton;
import com.gwtplatform.mvp.client.gin.AbstractPresenterModule;

import static com.google.gwt.inject.client.multibindings.GinMultibinder.newSetBinder;

public class SupportModule extends AbstractPresenterModule {
    @Override
    protected void configure() {
        bind(SupportPresenter.class).in(Singleton.class);
        bind(SupportPresenter.MyProxy.class).asEagerSingleton();

        GinMultibinder<SupportPresenter.MyView> supportBinder = newSetBinder(binder(), SupportPresenter.MyView.class);
        supportBinder.addBinding().to(SupportView.class);
        supportBinder.addBinding().to(SupportABView.class);
        bind(SupportPresenter.MyView.class).toProvider(SupportViewProvider.class);
    }
}
