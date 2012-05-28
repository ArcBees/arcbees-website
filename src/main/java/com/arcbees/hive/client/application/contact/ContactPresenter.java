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

package com.arcbees.hive.client.application.contact;

import com.arcbees.hive.client.application.common.AppPresenter;
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
 * @author Zachary Keatts
 */
public class ContactPresenter extends
        Presenter<ContactPresenter.MyView, ContactPresenter.MyProxy> {

    /**
     * {@link ContactPresenter}'s proxy.
     */
    @ProxyStandard
    @NameToken(NameTokens.contact)
    public interface MyProxy extends ProxyPlace<ContactPresenter> {
    }

    /**
     * {@link ContactPresenter}'s view.
     */
    public interface MyView extends View {
    }

    @Inject
    public ContactPresenter(EventBus eventBus, MyView view, MyProxy proxy) {
        super(eventBus, view, proxy);
    }

    @Override
    protected void revealInParent() {
        RevealContentEvent.fire(this, AppPresenter.TYPE_SetMainContent, this);
    }

    @Override
    protected void onReveal() {
        super.onReveal();

        ResizeEvent.fire(this, AppPresenter.TYPE_SetMainContent,
                getView().asWidget().getOffsetHeight());
    }
}