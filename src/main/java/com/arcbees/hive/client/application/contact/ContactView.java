/**
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

import com.arcbees.core.client.mvp.ViewWithUiHandlers;
import com.arcbees.core.client.mvp.uihandlers.UiHandlersStrategy;
import com.arcbees.hive.client.application.contact.ContactPresenter.MyView;
import com.arcbees.hive.client.resource.constants.MyConstants;
import com.google.gwt.event.dom.client.BlurEvent;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.FocusEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.TextArea;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.Widget;
import com.google.inject.Inject;

public class ContactView extends ViewWithUiHandlers<ContactUiHandlers> implements MyView {
    public interface Binder extends UiBinder<Widget, ContactView> {
    }

    @UiField
    TextArea contentsTextArea;
    @UiField
    TextBox senderTextBox;
    @UiField
    Button sendButton;

    private String defaultContents;
    private String defaultEmail;

    @Inject
    public ContactView(final Binder uiBinder,
                       final UiHandlersStrategy<ContactUiHandlers> uiHandlersStrategy,
                       final MyConstants myConstants) {
        super(uiHandlersStrategy);

        defaultContents = myConstants.tellUsAboutYourProject();
        defaultEmail = myConstants.yourEmail();

        initWidget(uiBinder.createAndBindUi(this));

        initUi();
    }

    private void initUi() {
        senderTextBox.setText(defaultEmail);
        contentsTextArea.setText(defaultContents);
    }

    @UiHandler("sendButton")
    public void onSendButton(ClickEvent event) {
        String sender = senderTextBox.getText();
        String contents = contentsTextArea.getText();

        getUiHandlers().sendMail(sender, contents);
    }

    @UiHandler("contentsTextArea")
    public void onContentsTextArea(FocusEvent event) {
        if (contentsTextArea.getText().equals(defaultContents)) {
            contentsTextArea.setText("");
        }
    }

    @UiHandler("contentsTextArea")
    public void onContentsTextArea(BlurEvent event) {
        if (contentsTextArea.getText().length() == 0) {
            contentsTextArea.setText(defaultContents);
        }
    }

    @UiHandler("senderTextBox")
    public void onSenderTextBox(FocusEvent event) {
        if (senderTextBox.getText().equals(defaultEmail)) {
            senderTextBox.setText("");
        }
    }

    @UiHandler("senderTextBox")
    public void onSenderTextBox(BlurEvent event) {
        if (senderTextBox.getText().length() == 0) {
            senderTextBox.setText(defaultEmail);
        }
    }
}
