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

package com.arcbees.hive.client.application.home.development;

import com.arcbees.hive.client.application.home.HomePresenter;
import com.arcbees.hive.client.application.home.event.ResizeEvent;
import com.arcbees.hive.client.place.NameTokens;
import com.google.inject.Inject;
import com.google.web.bindery.event.shared.EventBus;
import com.gwtplatform.mvp.client.Presenter;
import com.gwtplatform.mvp.client.View;
import com.gwtplatform.mvp.client.annotations.NameToken;
import com.gwtplatform.mvp.client.annotations.ProxyStandard;
import com.gwtplatform.mvp.client.proxy.ProxyPlace;
import com.gwtplatform.mvp.client.proxy.RevealContentEvent;

/**
 * @author Christian Goudreau
 */
public class DevelopmentPresenter extends
        Presenter<DevelopmentPresenter.MyView, DevelopmentPresenter.MyProxy> {
    /**
     * {@link DevelopmentPresenter}'s {@link View}.
     */
    public interface MyView extends View {
    }

    /**
     * {@link DevelopmentPresenter}'s {@link ProxyPlace}.
     */
    @ProxyStandard
    @NameToken(NameTokens.development)
    public interface MyProxy extends ProxyPlace<DevelopmentPresenter> {
    }

    @Inject
    public DevelopmentPresenter(final EventBus eventBus, final MyView view,
                                final MyProxy proxy) {
        super(eventBus, view, proxy);
    }

    @Override
    protected void revealInParent() {
        RevealContentEvent.fire(this, HomePresenter.TYPE_SetBottomContent3, this);
    }

    @Override
    protected void onReveal() {
        super.onReveal();

        ResizeEvent.fire(this, HomePresenter.TYPE_SetBottomContent3,
                getView().asWidget().getOffsetHeight());
    }
}
