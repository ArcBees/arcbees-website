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

package com.arcbees.website.client.application.products.jukito;

import com.arcbees.website.client.Bundles;
import com.arcbees.website.client.application.products.ProductsPresenter;
import com.arcbees.website.shared.NameTokens;
import com.google.inject.Inject;
import com.google.web.bindery.event.shared.EventBus;
import com.gwtplatform.mvp.client.Presenter;
import com.gwtplatform.mvp.client.View;
import com.gwtplatform.mvp.client.annotations.NameToken;
import com.gwtplatform.mvp.client.annotations.ProxyCodeSplitBundle;
import com.gwtplatform.mvp.client.proxy.ProxyPlace;

public class JukitoPresenter extends Presenter<JukitoPresenter.MyView, JukitoPresenter.MyProxy> {
    interface MyView extends View {
    }

    @ProxyCodeSplitBundle(Bundles.PRODUCTS)
    @NameToken({NameTokens.JUKITO, NameTokens.JUKITO_FR})
    interface MyProxy extends ProxyPlace<JukitoPresenter> {
    }

    @Inject
    JukitoPresenter(
            EventBus eventBus,
            MyView view,
            MyProxy proxy) {
        super(eventBus, view, proxy, ProductsPresenter.SLOT_PRODUCTS);
    }
}
