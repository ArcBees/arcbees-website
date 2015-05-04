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

import javax.inject.Inject;

import com.arcbees.website.client.resources.ContactFormResources;
import com.google.common.base.Strings;
import com.google.gwt.core.client.Scheduler;
import com.google.gwt.dom.client.ButtonElement;
import com.google.gwt.dom.client.Element;
import com.google.gwt.dom.client.FormElement;
import com.google.gwt.dom.client.InputElement;
import com.google.gwt.dom.client.TextAreaElement;
import com.google.gwt.query.client.Function;
import com.google.gwt.query.client.GQuery;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Widget;
import com.google.web.bindery.event.shared.EventBus;
import com.gwtplatform.mvp.client.PopupViewWithUiHandlers;

import static com.google.gwt.query.client.GQuery.$;

public class ContactFormView extends PopupViewWithUiHandlers<ContactFormUiHandlers>
        implements ContactFormPresenter.MyView {
    interface Binder extends UiBinder<Widget, ContactFormView> {
    }

    @UiField
    FormElement formPanel;
    @UiField
    ContactFormResources form;
    @UiField
    InputElement name;
    @UiField
    InputElement email;
    @UiField
    TextAreaElement message;
    @UiField
    ButtonElement cancel;

    private final EmailValidator emailValidator;

    @Inject
    ContactFormView(
            EventBus eventBus,
            Binder binder,
            EmailValidator emailValidator) {
        super(eventBus);

        this.emailValidator = emailValidator;

        initWidget(binder.createAndBindUi(this));

        bind();
    }

    @Override
    public void hide() {
        super.hide();

        reset();
    }

    private void bind() {
        $(formPanel).submit(new Function() {
            @Override
            public void f() {
                onSubmit();
            }
        });

        $(cancel).click(new Function() {
            @Override
            public void f() {
                hide();
            }
        });
    }

    private void onSubmit() {
        removeErrorStyles();
        validate();
    }

    private void reset() {
        $(name, email, message).val("");
        removeErrorStyles();
    }

    private void validate() {
        Scheduler.get().scheduleDeferred(new Scheduler.ScheduledCommand() {
            @Override
            public void execute() {
                boolean validateRequired = validateRequired(name, email, message);
                boolean validateEmail = validateEmail();

                if (validateRequired && validateEmail) {
                    getUiHandlers().sendRequest(name.getValue(), email.getValue(), message.getValue());
                }
            }
        });
    }

    private boolean validateEmail() {
        boolean isValidEmail = emailValidator.isValid(email.getValue());

        if (!isValidEmail) {
            addError($(email));
        }

        return isValidEmail;
    }

    private boolean validateRequired(Element... elements) {
        boolean valid = true;
        for (Element element : elements) {
            GQuery $element = $(element);
            boolean isEmpty = Strings.isNullOrEmpty($element.val());

            if (isEmpty) {
                addError($element);
            }

            valid &= !isEmpty;
        }

        return valid;
    }

    private GQuery addError(GQuery $element) {
        return $element.parent().addClass(form.style().error());
    }

    private void removeErrorStyles() {
        $(name, email, message).parent().removeClass(form.style().error());
    }
}
