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

import javax.inject.Inject;

import com.arcbees.hive.client.application.common.AppPresenter;
import com.arcbees.hive.client.application.common.event.ResizeEvent;
import com.arcbees.hive.client.application.common.event.ResizeEvent.ResizeHandler;
import com.arcbees.hive.client.place.NameTokens;
import com.google.web.bindery.event.shared.EventBus;
import com.gwtplatform.mvp.client.HasUiHandlers;
import com.gwtplatform.mvp.client.Presenter;
import com.gwtplatform.mvp.client.View;
import com.gwtplatform.mvp.client.annotations.NameToken;
import com.gwtplatform.mvp.client.annotations.ProxyStandard;
import com.gwtplatform.mvp.client.proxy.ProxyPlace;
import com.gwtplatform.mvp.client.proxy.RevealContentEvent;

public class HomePresenter extends Presenter<HomePresenter.MyView, HomePresenter.MyProxy>
        implements HomeUiHandlers, ResizeHandler {
    @ProxyStandard
    @NameToken(NameTokens.home)
    public interface MyProxy extends ProxyPlace<HomePresenter> {
    }

    public interface MyView extends View, HasUiHandlers<HomeUiHandlers> {
        void startTimer();

        void stopTimer();
    }

    @Inject
    HomePresenter(EventBus eventBus,
                  MyView view,
                  MyProxy proxy) {
        super(eventBus, view, proxy);

        getView().setUiHandlers(this);
    }

    @Override
    protected void revealInParent() {
        RevealContentEvent.fire(this, AppPresenter.SLOT_SetMainContent, this);
    }

    @Override
    protected void onBind() {
        super.onBind();

        addRegisteredHandler(ResizeEvent.getType(), this);
    }

    @Override
    public void onResize(ResizeEvent event) {
    }

    @Override
    protected void onReveal() {
        super.onReveal();

        ResizeEvent.fire(this, AppPresenter.SLOT_SetMainContent, getView().asWidget().getOffsetHeight());

        getView().startTimer();
    }


    @Override
    protected void onHide() {
        super.onHide();

        getView().stopTimer();
    }
}
