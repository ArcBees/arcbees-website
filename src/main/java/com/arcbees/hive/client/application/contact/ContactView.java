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
import com.gwtplatform.mvp.client.ViewWithUiHandlers;

public class ContactView extends ViewWithUiHandlers<ContactUiHandlers> implements MyView {
    public interface Binder extends UiBinder<Widget, ContactView> {
    }

    @UiField
    TextArea contentsTextArea;
    @UiField
    TextBox senderEmailTextBox;
    @UiField
    TextBox senderNameTextBox;
    @UiField
    Button sendButton;
    @UiField(provided = true)
    SocialMediaWidget socialMediaWidget;

    private final Resources resources;

    private String defaultContents;
    private String defaultEmail;
    private String defaultName;

    @Inject
    ContactView(Binder uiBinder,
                MyConstants myConstants,
                SocialMediaWidgetFactory socialMediaWidgetFactory,
                Resources resources) {
        this.resources = resources;

        defaultContents = myConstants.tellUsAboutYourProject();
        defaultEmail = myConstants.yourEmail();
        defaultName = myConstants.yourName();

        socialMediaWidget = socialMediaWidgetFactory.create(SocialMediaWidgetSize.Large);

        initWidget(uiBinder.createAndBindUi(this));

        initUi();
    }

    private void initUi() {
        senderEmailTextBox.setText(defaultEmail);
        contentsTextArea.setText(defaultContents);
        senderNameTextBox.setText(defaultName);

        switchToItalic(contentsTextArea);
        switchToItalic(senderEmailTextBox);
        switchToItalic(senderNameTextBox);
    }

    @UiHandler("sendButton")
    public void onSendButton(ClickEvent event) {
        String senderEmail = senderEmailTextBox.getText();
        String contents = contentsTextArea.getText();
        String senderName = senderNameTextBox.getText();

        getUiHandlers().sendMail(senderEmail, senderName, contents);
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

    @UiHandler("senderEmailTextBox")
    public void onSenderEmailTextBox(FocusEvent event) {
        switchToNormal(senderEmailTextBox);

        if (senderEmailTextBox.getText().equals(defaultEmail)) {
            senderEmailTextBox.setText("");
        }
    }

    @UiHandler("senderEmailTextBox")
    public void onSenderEmailTextBox(BlurEvent event) {
        if (senderEmailTextBox.getText().length() == 0) {
            senderEmailTextBox.setText(defaultEmail);

            switchToItalic(senderEmailTextBox);
        }
    }

    @UiHandler("senderNameTextBox")
    public void onSenderNameTextBox(FocusEvent event) {
        switchToNormal(senderNameTextBox);

        if (senderNameTextBox.getText().equals(defaultName)) {
            senderNameTextBox.setText("");
        }
    }

    @UiHandler("senderNameTextBox")
    public void onSenderNameTextBox(BlurEvent event) {
        if (senderNameTextBox.getText().length() == 0) {
            senderNameTextBox.setText(defaultName);

            switchToItalic(senderNameTextBox);
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
