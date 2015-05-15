/*
 * Copyright 2015 ArcBees Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except in compliance with
 * the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License is distributed on
 * an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations under the License.
 */

package com.arcbees.website.client.application.contactform;

import com.arcbees.website.client.application.api.SupportService;
import com.arcbees.website.shared.ContactRequest;
import com.arcbees.website.shared.ContactRequestBuilder;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.inject.Inject;
import com.google.web.bindery.event.shared.EventBus;
import com.gwtplatform.dispatch.rest.client.RestDispatch;
import com.gwtplatform.mvp.client.HasUiHandlers;
import com.gwtplatform.mvp.client.PopupView;
import com.gwtplatform.mvp.client.PresenterWidget;

public class ContactFormPresenter extends PresenterWidget<ContactFormPresenter.MyView>
        implements ContactFormUiHandlers {
    interface MyView extends PopupView, HasUiHandlers<ContactFormUiHandlers> {
        void showServerError();
    }

    private final RestDispatch dispatcher;
    private final SupportService supportService;

    @Inject
    ContactFormPresenter(
            EventBus eventBus,
            MyView view,
            RestDispatch dispatcher,
            SupportService supportService) {
        super(eventBus, view);

        this.dispatcher = dispatcher;
        this.supportService = supportService;

        getView().setUiHandlers(this);
    }

    @Override
    public void sendRequest(String name, String email, String message) {
        ContactRequest contactRequest = ContactRequestBuilder.newRequest()
                .withEmail(email)
                .withName(name)
                .withMessage(message)
                .build();
        dispatcher.execute(supportService.sendEmail(contactRequest), new AsyncCallback<Void>() {
            @Override
            public void onFailure(Throwable caught) {
                getView().showServerError();
            }

            @Override
            public void onSuccess(Void result) {
                getView().hide();
            }
        });
    }
}
