/*
 * Copyright 2014 ArcBees Inc.
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

package com.arcbees.hive.client.application.team;

import javax.inject.Inject;

import com.arcbees.hive.client.application.common.AppPresenter;
import com.arcbees.hive.client.application.common.event.ResizeEvent;
import com.arcbees.hive.client.place.NameTokens;
import com.google.web.bindery.event.shared.EventBus;
import com.gwtplatform.mvp.client.Presenter;
import com.gwtplatform.mvp.client.View;
import com.gwtplatform.mvp.client.annotations.NameToken;
import com.gwtplatform.mvp.client.annotations.ProxyStandard;
import com.gwtplatform.mvp.client.proxy.ProxyPlace;

public class TeamPresenter extends Presenter<TeamPresenter.MyView, TeamPresenter.MyProxy> {
    @ProxyStandard
    @NameToken(NameTokens.team)
    public interface MyProxy extends ProxyPlace<TeamPresenter> {
    }

    public interface MyView extends View {
    }

    @Inject
    public TeamPresenter(EventBus eventBus, MyView view, MyProxy proxy) {
        super(eventBus, view, proxy, AppPresenter.SLOT_SetMainContent);
    }

    @Override
    protected void onReveal() {
        super.onReveal();

        ResizeEvent.fire(this, AppPresenter.SLOT_SetMainContent, getView().asWidget().getOffsetHeight());
    }
}
