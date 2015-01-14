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

package com.arcbees.website.client.application.bees.bee.christopher;

import com.arcbees.website.client.Bundles;
import com.arcbees.website.client.application.bees.BeesPresenter;
import com.arcbees.website.shared.NameTokens;
import com.google.inject.Inject;
import com.google.web.bindery.event.shared.EventBus;
import com.gwtplatform.mvp.client.Presenter;
import com.gwtplatform.mvp.client.View;
import com.gwtplatform.mvp.client.annotations.NameToken;
import com.gwtplatform.mvp.client.annotations.ProxyCodeSplitBundle;
import com.gwtplatform.mvp.client.proxy.ProxyPlace;

public class ChristopherPresenter extends Presenter<ChristopherPresenter.MyView, ChristopherPresenter.MyProxy> {
    public interface MyView extends View {
    }

    @ProxyCodeSplitBundle(Bundles.BEES3)
    @NameToken({NameTokens.BEE_CHRISTOPHER, NameTokens.BEE_CHRISTOPHER_FR})
    interface MyProxy extends ProxyPlace<ChristopherPresenter> {
    }

    @Inject
    ChristopherPresenter(
            EventBus eventBus,
            MyView view,
            MyProxy proxy) {
        super(eventBus, view, proxy, BeesPresenter.SLOT_BEE);
    }
}
