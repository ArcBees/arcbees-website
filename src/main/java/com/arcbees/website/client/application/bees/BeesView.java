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

package com.arcbees.website.client.application.bees;

import com.arcbees.website.client.resources.PageBeesResources;
import com.google.gwt.dom.client.AnchorElement;
import com.google.gwt.dom.client.BrowserEvents;
import com.google.gwt.dom.client.DivElement;
import com.google.gwt.dom.client.Element;
import com.google.gwt.dom.client.HeadingElement;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.logical.shared.AttachEvent;
import com.google.gwt.query.client.Function;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.Event;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.user.client.ui.IsWidget;
import com.google.gwt.user.client.ui.Widget;
import com.google.inject.Inject;
import com.gwtplatform.mvp.client.ViewWithUiHandlers;

import static com.google.gwt.query.client.GQuery.$;

public class BeesView extends ViewWithUiHandlers<BeesUiHandlers> implements BeesPresenter.MyView, AttachEvent.Handler {
    interface Binder extends UiBinder<Widget, BeesView> {
    }

    private final PageBeesResources pageBeesResources;

    @UiField
    DivElement popup;
    @UiField
    Element bees;
    @UiField
    HTMLPanel bee;
    @UiField
    AnchorElement popupClose;
    @UiField
    Button initQuizButton;
    @UiField
    HTMLPanel quizSection;
    @UiField
    HeadingElement quizTitle;

    @Inject
    BeesView(
            Binder binder,
            final PageBeesResources pageBeesResources) {
        this.pageBeesResources = pageBeesResources;
        pageBeesResources.style().ensureInjected();

        initWidget(binder.createAndBindUi(this));

        asWidget().addAttachHandler(this);
    }

    @Override
    public void setInSlot(Object slot, IsWidget content) {
        if (slot == BeesPresenter.SLOT_BEE) {
            bee.clear();

            $(popup).toggleClass(pageBeesResources.style().active(), content != null);
            if (content != null) {
                bee.add(content);
            }
        } else if (slot == BeesPresenter.SLOT_QUIZ) {
            quizSection.clear();
            quizSection.add(content);
        }
    }

    @Override
    public void onAttachOrDetach(AttachEvent event) {
        if (event.isAttached()) {
            $(popup).click(new Function() {
                public void f() {
                    getUiHandlers().hidePopup();
                }
            });
            $(popupClose).click(new Function() {
                public boolean f(Event e) {
                    getUiHandlers().hidePopup();
                    return false;
                }
            });
            $(bee).click(new Function() {
                @Override
                public boolean f(Event e) {
                    e.stopPropagation();
                    return true;
                }
            });

            $("." + pageBeesResources.style().beeHolder2() + " > a").click(new Function() {
                @Override
                public void f() {
                    int offsetTop = Window.getScrollTop();
                    $(bee).css("margin-top", (offsetTop + 30) + "px");
                }
            });
        } else {
            $(popup).unbind(BrowserEvents.CLICK);
            $(bee).unbind(BrowserEvents.CLICK);
        }
    }

    @Override
    public void konami() {
        $("img", bees).css("display", "none");
    }

    @Override
    public void initQuiz() {
        $(initQuizButton).hide();
    }

    @UiHandler("initQuizButton")
    void onInitQuizButton(ClickEvent event) {
        $(quizTitle).hide();
        getUiHandlers().onInitQuiz();
    }
}
