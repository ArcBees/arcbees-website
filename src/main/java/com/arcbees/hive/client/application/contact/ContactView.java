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
import com.arcbees.hive.client.application.common.socialmedia.SocialMediaWidget;
import com.arcbees.hive.client.application.common.socialmedia.SocialMediaWidgetFactory;
import com.arcbees.hive.client.application.common.socialmedia.SocialMediaWidgetSize;
import com.arcbees.hive.client.application.contact.ContactPresenter.MyView;
import com.arcbees.hive.client.resource.Resources;
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
    @UiField(provided = true)
    SocialMediaWidget socialMediaWidget;

    private String defaultContents;
    private String defaultEmail;
    private final Resources resources;

    @Inject
    public ContactView(final Binder uiBinder,
                       final UiHandlersStrategy<ContactUiHandlers> uiHandlersStrategy,
                       final MyConstants myConstants,
                       final SocialMediaWidgetFactory socialMediaWidgetFactory,
                       final Resources resources) {
        super(uiHandlersStrategy);
        this.resources = resources;

        defaultContents = myConstants.tellUsAboutYourProject();
        defaultEmail = myConstants.yourEmail();
        socialMediaWidget = socialMediaWidgetFactory.create(SocialMediaWidgetSize.Large);

        initWidget(uiBinder.createAndBindUi(this));

        initUi();
    }

    private void initUi() {
        senderTextBox.setText(defaultEmail);
        contentsTextArea.setText(defaultContents);

        switchToItalic(contentsTextArea);
        switchToItalic(senderTextBox);
    }



    @UiHandler("sendButton")
    public void onSendButton(ClickEvent event) {
        String sender = senderTextBox.getText();
        String contents = contentsTextArea.getText();

        getUiHandlers().sendMail(sender, contents);
    }

    @UiHandler("contentsTextArea")
    public void onContentsTextArea(FocusEvent event) {
        switchToNormal(contentsTextArea);

        if (contentsTextArea.getText().equals(defaultContents)) {
            contentsTextArea.setText("");
        }
    }

    @UiHandler("contentsTextArea")
    public void onContentsTextArea(BlurEvent event) {
        if (contentsTextArea.getText().length() == 0) {
            contentsTextArea.setText(defaultContents);

            switchToItalic(contentsTextArea);
        }
    }

    @UiHandler("senderTextBox")
    public void onSenderTextBox(FocusEvent event) {
        switchToNormal(senderTextBox);

        if (senderTextBox.getText().equals(defaultEmail)) {
            senderTextBox.setText("");
        }
    }

    @UiHandler("senderTextBox")
    public void onSenderTextBox(BlurEvent event) {
        if (senderTextBox.getText().length() == 0) {
            senderTextBox.setText(defaultEmail);

            switchToItalic(senderTextBox);
        }
    }

    private void switchToItalic(Widget widget) {
        widget.removeStyleName(resources.style().contactTextNormal());
        widget.addStyleName(resources.style().contactTextItalic());
    }

    private void switchToNormal(Widget widget) {
        widget.removeStyleName(resources.style().contactTextItalic());
        widget.addStyleName(resources.style().contactTextNormal());
    }
}
