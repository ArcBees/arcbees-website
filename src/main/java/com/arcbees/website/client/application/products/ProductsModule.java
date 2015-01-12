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

package com.arcbees.website.client.application.products;

import com.arcbees.website.client.application.products.chosen.ChosenModule;
import com.arcbees.website.client.application.products.gae.GaeModule;
import com.arcbees.website.client.application.products.gquery.GqueryModule;
import com.arcbees.website.client.application.products.gwtp.GwtpModule;
import com.arcbees.website.client.application.products.jukito.JukitoModule;
import com.gwtplatform.mvp.client.gin.AbstractPresenterModule;

public class ProductsModule extends AbstractPresenterModule {
    @Override
    protected void configure() {
        install(new JukitoModule());
        install(new ChosenModule());
        install(new GqueryModule());
        install(new GaeModule());
        install(new GwtpModule());

        bindPresenter(ProductsPresenter.class, ProductsPresenter.MyView.class, ProductsView.class,
                ProductsPresenter.MyProxy.class);
    }
}
