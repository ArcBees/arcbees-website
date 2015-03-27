/*
 * Copyright 2014 ArcBees Inc.
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

package com.arcbees.website.client.application.slider;

import com.arcbees.website.client.resources.SliderResources;
import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.Element;
import com.google.gwt.dom.client.NodeList;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.logical.shared.AttachEvent;
import com.google.gwt.query.client.Function;
import com.google.gwt.query.client.GQuery;
import com.google.gwt.safehtml.client.SafeHtmlTemplates;
import com.google.gwt.safehtml.shared.SafeHtml;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiChild;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.ui.Anchor;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.user.client.ui.IsWidget;
import com.google.gwt.user.client.ui.Widget;

import static com.google.gwt.query.client.GQuery.$;

public class Slider implements IsWidget, AttachEvent.Handler {
    interface Binder extends UiBinder<HTMLPanel, Slider> {
    }

    interface HtmlTemplate extends SafeHtmlTemplates {
        @Template("<a href=\"javascript:;\" " + DATA_INDEX + "=\"{0}\"><span>{0}</span></a>")
        SafeHtml pagerDot(int index);
    }

    private static final String DATA_INDEX = "data-index";
    private static final String TRANSITION_END = "transitionend webkitTransitionEnd oTransitionEnd MSTransitionEnd";

    private static Binder BINDER = GWT.create(Binder.class);
    private static HtmlTemplate TEMPLATE = GWT.create(HtmlTemplate.class);

    @UiField
    HTMLPanel contents;
    @UiField
    Anchor prev;
    @UiField
    Anchor next;
    @UiField
    SliderResources sliderResources;
    @UiField
    HTMLPanel pager;
    @UiField
    HTMLPanel nav;

    private final HTMLPanel root;

    private NodeList<Element> items;
    private int itemCount;
    private int maxIndex;
    private int index;
    private boolean activeAnimation;

    public Slider() {
        root = BINDER.createAndBindUi(this);
    }

    @Override
    public Widget asWidget() {
        return root;
    }

    @UiChild(limit = 1, tagname = "content")
    public void setContent(IsWidget content) {
        items = $(content).children().get();
        itemCount = items.getLength();
        maxIndex = itemCount - 1;

        drawDots();

        displayCurrent();

        asWidget().addAttachHandler(this);
    }

    @Override
    public void onAttachOrDetach(AttachEvent event) {
        if (event.isAttached()) {
            index = 0;
            displayCurrent();
            $(contents).on(TRANSITION_END, new Function() {
                @Override
                public void f() {
                    GQuery.console.log("TRANSITION_END");
                    activeAnimation = false;
                    $("[data-remove]", contents).remove();
                }
            });
        } else {
            $(contents).off(TRANSITION_END);
        }
    }

    public void setAddStyleNames(String style) {
        asWidget().addStyleName(style);
    }

    public void setAddContentStyleName(String style) {
        contents.addStyleName(style);
    }

    public void setAddPagerStyleName(String style) {
        pager.addStyleName(style);
    }

    public void setAddNavStyleName(String style) {
        nav.addStyleName(style);
    }

    @UiHandler("prev")
    void onPrev(ClickEvent event) {
        if (!activeAnimation) {
            prev();
        }
    }

    @UiHandler("next")
    void onNext(ClickEvent event) {
        if (!activeAnimation) {
            next();
        }
    }

    private void next() {
        if (index < maxIndex) {
            index++;
        } else {
            index = 0;
        }

        displayCurrent(false);
    }

    private void prev() {
        if (index > 0) {
            index--;
        } else {
            index = maxIndex;
        }

        displayCurrent(true);
    }

    private void drawDots() {
        for (int i = 0; i < itemCount; i++) {
            SafeHtml dot = TEMPLATE.pagerDot(i);
            $(pager).append(dot.asString());
        }

        $(pager).children().click(new Function() {
            @Override
            public void f() {
                index = Integer.parseInt($(this).attr(DATA_INDEX));

                displayCurrent();
            }
        });
    }

    private void displayCurrent() {
        Element item = items.getItem(index);

        $(contents).children().remove();
        $(contents).append($(item).clone());

        setCurrentActive();
    }

    private void displayCurrent(boolean previous) {
        activeAnimation = true;

        Element item = items.getItem(index);

        $(contents).children().attr("data-remove", true);
        if (previous) {
            $(contents).prepend($(item).clone());

            final GQuery element = $(contents).children().first();
            element.css("marginLeft", "-100%")
                    .addClass(sliderResources.style().contentTransition())
                    .delay(100)
                    .promise()
                    .done(new Function() {
                        @Override
                        public void f() {
                            element.css("marginLeft", "0");
                        }
                    });
        } else {
            $(contents).append($(item).clone());
            $(contents).children()
                    .first()
                    .addClass(sliderResources.style().contentTransition())
                    .css("marginLeft", "-100%");
        }

        setCurrentActive();
    }

    private void setCurrentActive() {
        String active = sliderResources.style().active();
        $("." + active, pager).removeClass(active);
        $(pager).children().eq(index).addClass(active);
    }
}
