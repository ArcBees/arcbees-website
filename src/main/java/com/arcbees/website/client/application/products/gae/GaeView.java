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

package com.arcbees.website.client.application.products.gae;

import com.arcbees.website.client.resources.AppResources;
import com.arcbees.website.client.resources.PageProductResources;
import com.google.gwt.dom.client.AnchorElement;
import com.google.gwt.dom.client.DivElement;
import com.google.gwt.dom.client.Element;
import com.google.gwt.query.client.Function;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Widget;
import com.google.inject.Inject;
import com.gwtplatform.mvp.client.ViewImpl;

import static com.google.gwt.query.client.GQuery.$;

public class GaeView extends ViewImpl implements GaePresenter.MyView {
    interface Binder extends UiBinder<Widget, GaeView> {
    }

    private static final int SLIDE_DELAY = 250;

    @UiField
    AnchorElement favLanguageBtn;
    @UiField
    DivElement favLanguageMore;
    @UiField
    AnchorElement chooseWantSeeBtn;
    @UiField
    DivElement chooseWantSeeMore;
    @UiField
    AnchorElement strugglingDataEditBtn;
    @UiField
    DivElement strugglingDataEditMore;
    @UiField
    AnchorElement yourMetricAtWorkBtn;
    @UiField
    DivElement yourMetricAtWorkMore;
    @UiField
    AnchorElement takeLookUnderHoodBtn;
    @UiField
    DivElement takeLookUnderHoodMore;

    private final PageProductResources pageResources;

    @Inject
    GaeView(
            AppResources appResources,
            PageProductResources pageResources,
            Binder binder) {
        initWidget(binder.createAndBindUi(this));

        this.pageResources = pageResources;

        bind();
    }

    private void bind() {
        bindFavLanguage();
        bindChooseWantSee();
        bindStrugglingDataEdit();
        bindYourMetricAtWork();
        bindTakeLookUnderHood();
    }

    private void bindFavLanguage() {
        $(favLanguageMore).hide();
        $(favLanguageBtn).click(new Function() {
            public void f(Element e) {
                $(favLanguageMore).slideToggle(SLIDE_DELAY);
                $(favLanguageBtn).toggleClass(pageResources.style().collapsible());
            }
        });
    }

    private void bindChooseWantSee() {
        $(chooseWantSeeMore).hide();
        $(chooseWantSeeBtn).click(new Function() {
            public void f(Element e) {
                $(chooseWantSeeMore).slideToggle(SLIDE_DELAY);
                $(chooseWantSeeBtn).toggleClass(pageResources.style().collapsible());
            }
        });
    }

    private void bindStrugglingDataEdit() {
        $(strugglingDataEditMore).hide();
        $(strugglingDataEditBtn).click(new Function() {
            public void f(Element e) {
                $(strugglingDataEditMore).slideToggle(SLIDE_DELAY);
                $(strugglingDataEditBtn).toggleClass(pageResources.style().collapsible());
            }
        });
    }

    private void bindYourMetricAtWork() {
        $(yourMetricAtWorkMore).hide();
        $(yourMetricAtWorkBtn).click(new Function() {
            public void f(Element e) {
                $(yourMetricAtWorkMore).slideToggle(SLIDE_DELAY);
                $(yourMetricAtWorkBtn).toggleClass(pageResources.style().collapsible());
            }
        });
    }

    private void bindTakeLookUnderHood() {
        $(takeLookUnderHoodMore).hide();
        $(takeLookUnderHoodBtn).click(new Function() {
            public void f(Element e) {
                $(takeLookUnderHoodMore).slideToggle(SLIDE_DELAY);
                $(takeLookUnderHoodBtn).toggleClass(pageResources.style().collapsible());
            }
        });
    }
}
