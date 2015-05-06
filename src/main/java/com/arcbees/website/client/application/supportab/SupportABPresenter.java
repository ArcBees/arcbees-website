/**
 * Copyright 2015 ArcBees Inc.
 * <p/>
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except in compliance with
 * the License. You may obtain a copy of the License at
 * <p/>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p/>
 * Unless required by applicable law or agreed to in writing, software distributed under the License is distributed on
 * an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations under the License.
 */

package com.arcbees.website.client.application.supportab;

import com.arcbees.website.client.application.ApplicationPresenter;
import com.arcbees.website.client.application.contactform.ShowContactFormEvent;
import com.arcbees.website.shared.NameTokens;
import com.google.inject.Inject;
import com.google.web.bindery.event.shared.EventBus;
import com.gwtplatform.mvp.client.HasUiHandlers;
import com.gwtplatform.mvp.client.Presenter;
import com.gwtplatform.mvp.client.View;
import com.gwtplatform.mvp.client.annotations.NameToken;
import com.gwtplatform.mvp.client.annotations.ProxyCodeSplit;
import com.gwtplatform.mvp.client.proxy.ProxyPlace;

public class SupportABPresenter extends Presenter<SupportABPresenter.MyView, SupportABPresenter.MyProxy>
        implements SupportABUiHandlers {
    interface MyView extends View, HasUiHandlers<SupportABUiHandlers> {
    }

    @ProxyCodeSplit
    @NameToken({NameTokens.SUPPORTAB, NameTokens.SUPPORTAB_FR})
    interface MyProxy extends ProxyPlace<SupportABPresenter> {
    }

    @Inject
    SupportABPresenter(
            EventBus eventBus,
            MyView view,
            MyProxy proxy) {
        super(eventBus, view, proxy, ApplicationPresenter.SLOT_MAIN);

        getView().setUiHandlers(this);
    }

    @Override
    public void showContactForm() {
        ShowContactFormEvent.fire(this);
    }
}
