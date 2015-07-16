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

import com.arcbees.analytics.shared.Analytics;
import com.arcbees.website.client.resources.ContactFormResources;
import com.google.common.base.Strings;
import com.google.gwt.core.client.Scheduler;
import com.google.gwt.dom.client.*;
import com.google.gwt.query.client.Function;
import com.google.gwt.query.client.GQuery;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Widget;
import com.google.web.bindery.event.shared.EventBus;
import com.gwtplatform.mvp.client.PopupViewWithUiHandlers;
//import org.vectomatic.dom.svg.OMSVGAnimateElement;
//import org.vectomatic.dom.svg.OMSVGAnimateMotionElement;
//import org.vectomatic.dom.svg.OMSVGAnimateTransformElement;

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
    @UiField
    ButtonElement begin;
//    @UiField
//    OMSVGAnimateMotionElement motion;
//    @UiField
//    OMSVGAnimateTransformElement transform;
//    @UiField
//    OMSVGAnimateElement animation;
    @UiField
    DivElement serverError;

    private final EmailValidator emailValidator;
    private final Analytics analytics;

    @Inject
    ContactFormView(
            EventBus eventBus,
            Binder binder,
            EmailValidator emailValidator,
            Analytics analytics) {
        super(eventBus);

        this.emailValidator = emailValidator;
        this.analytics = analytics;

        initWidget(binder.createAndBindUi(this));

        hideServerError();
    }

    @Override
    public void hide() {
        super.hide();

        reset();
    }

    @Override
    public void showServerError() {
        $(serverError).show();
    }

    @Override
    protected void onAttach() {
        $(formPanel).submit(new Function() {
            @Override
            public void f() {
                submit();
            }
        });

        $(cancel).click(new Function() {
            @Override
            public void f() {
                analytics.sendEvent("Support", "Click").eventLabel("Form - Cancel").go();
                hide();
            }
        });
    }

    @Override
    protected void onDetach() {
        $(formPanel).unbind("submit");
        $(cancel).unbind("click");
    }

    private void hideServerError() {
        $(serverError).hide();
    }

//    private void startAnimation() {
//        motion.beginElement();
//        transform.beginElement();
//        animation.beginElement();
//    }

    private void submit() {
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

//                if (validateRequired && validateEmail) {
//                    analytics.sendEvent("Support", "Click").eventLabel("Form - Send").go();
//                    startAnimation();
//                    getUiHandlers().sendRequest(name.getValue(), email.getValue(), message.getValue());
//                }
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
        hideServerError();
    }
}
