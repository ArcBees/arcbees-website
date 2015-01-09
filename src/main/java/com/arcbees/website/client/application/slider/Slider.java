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
import com.google.gwt.dom.client.DivElement;
import com.google.gwt.dom.client.Element;
import com.google.gwt.dom.client.NodeList;
import com.google.gwt.event.dom.client.ClickEvent;
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

public class Slider implements IsWidget {
    interface Binder extends UiBinder<HTMLPanel, Slider> {
    }

    private static final String DATA_INDEX = "data-index";

    interface HtmlTemplate extends SafeHtmlTemplates {
        @Template("<a href=\"javascript:;\" " + DATA_INDEX + "=\"{0}\"><span>{0}</span></a>")
        SafeHtml pagerDot(String index);
    }

    private static Binder ourUiBinder = GWT.create(Binder.class);
    private static HtmlTemplate template = GWT.create(HtmlTemplate.class);

    private final HTMLPanel root;

    @UiField
    DivElement contents;
    @UiField
    Anchor prev;
    @UiField
    Anchor next;
    @UiField
    SliderResources carouselRes;
    @UiField
    DivElement pager;

    private NodeList<Element> items;
    private int itemCount;
    private int maxIndex;
    private int index;

    public Slider() {
        root = ourUiBinder.createAndBindUi(this);
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
    }

    @UiHandler("prev")
    void onPrev(ClickEvent event) {
        GQuery.console.info("prev");
        prev();
    }

    @UiHandler("next")
    void onNext(ClickEvent event) {
        GQuery.console.info("next");
        next();
    }

    private void next() {
        if (index < maxIndex) {
            index++;
        }

        displayCurrent();
    }

    private void prev() {
        if (index > 0) {
            index--;
        }

        displayCurrent();
    }

    private void drawDots() {
        for (int i = 0; i < itemCount; i++) {
            SafeHtml dot = template.pagerDot(i + "");
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
        $(contents).append(item);

        if (index == 0) {
            $(prev).addClass(carouselRes.style().disabled());
            $(next).removeClass(carouselRes.style().disabled());
        } else if (index == maxIndex) {
            $(prev).removeClass(carouselRes.style().disabled());
            $(next).addClass(carouselRes.style().disabled());
        } else {
            $(prev).removeClass(carouselRes.style().disabled());
            $(next).removeClass(carouselRes.style().disabled());
        }

        $("." + carouselRes.style().actif(), pager).removeClass(carouselRes.style().actif());
        $(pager).children().eq(index).addClass(carouselRes.style().actif());
    }
}
