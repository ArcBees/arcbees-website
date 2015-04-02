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

package com.arcbees.website.client.application.contact.popup;

import com.arcbees.website.shared.NameTokens;
import com.google.gwt.query.client.GQuery;
import com.google.inject.Inject;
import com.google.web.bindery.event.shared.EventBus;
import com.gwtplatform.mvp.client.PopupView;
import com.gwtplatform.mvp.client.Presenter;
import com.gwtplatform.mvp.client.View;
import com.gwtplatform.mvp.client.annotations.NameToken;
import com.gwtplatform.mvp.client.annotations.ProxyStandard;
import com.gwtplatform.mvp.client.proxy.NavigationEvent;
import com.gwtplatform.mvp.client.proxy.NavigationHandler;
import com.gwtplatform.mvp.client.proxy.ProxyPlace;

public class ContactFormPresenter extends Presenter<ContactFormPresenter.MyView, ContactFormPresenter.MyProxy> implements NavigationHandler {
    interface MyView extends PopupView {
    }

    @ProxyStandard
    @NameToken({NameTokens.CONTACT_FORM, NameTokens.CONTACT_FORM_FR})
    interface MyProxy extends ProxyPlace<ContactFormPresenter> {
    }

    @Inject
    ContactFormPresenter(
            EventBus eventBus,
            MyView view,
            MyProxy proxy) {
        super(eventBus, view, proxy, RevealType.RootPopup);
    }

    @Override
    public void onNavigation(NavigationEvent navigationEvent) {
        if (navigationEvent.getRequest().matchesNameToken(NameTokens.CONTACT_FORM)
                || navigationEvent.getRequest().matchesNameToken(NameTokens.CONTACT_FORM_FR)) {
            getView().hide();
        }
    }

    @Override
    protected void onBind() {
        super.onBind();

        addVisibleHandler(NavigationEvent.getType(), this);
    }
}
