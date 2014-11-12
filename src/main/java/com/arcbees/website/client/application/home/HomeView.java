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

package com.arcbees.website.client.application.home;

import com.arcbees.website.client.resources.AppResources;
import com.arcbees.website.client.resources.PageHomeResources;
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

public class HomeView extends ViewImpl implements HomePresenter.MyView {
    interface Binder extends UiBinder<Widget, HomeView> {
    }

    @UiField
    AnchorElement successStoryBtn;
    @UiField
    DivElement successStoryMore;
    @UiField
    AnchorElement successStoryCloser;
    @UiField
    AnchorElement beesBtn;
    @UiField
    DivElement beesMore;
    @UiField
    DivElement bees;
    @UiField
    AnchorElement beesCloser;

    private final AppResources appResources;
    private final PageHomeResources pageResources;

    @Inject
    HomeView(
            AppResources appResources,
            PageHomeResources pageResources,
            Binder binder) {
        initWidget(binder.createAndBindUi(this));

        this.appResources = appResources;
        this.pageResources = pageResources;

        bind();
    }

    public void bind() {
        $(successStoryMore).hide();
        $(beesMore).hide();

        $(successStoryBtn).click(new Function() {
            public void f(Element e) {
                $(this).toggleClass(appResources.style().collapsable());
                if ($(this).hasClass(appResources.style().collapsable())) {
                    $(successStoryMore).slideDown(250);
                } else {
                    $(successStoryMore).slideUp(250);
                }
            }
        });

        $(successStoryCloser).click(new Function() {
           public void f(Element e) {
               $(successStoryMore).slideUp(250);
               $(successStoryBtn).removeClass(appResources.style().collapsable());
           }
        });

        $(beesBtn).click(new Function() {
            public void f(Element e) {
                $(this).toggleClass(appResources.style().collapsable());
                $(bees).toggleClass(pageResources.style().opened());
                if ($(this).hasClass(appResources.style().collapsable())) {
                    $(beesMore).slideDown(250);
                } else {
                    $(beesMore).slideUp(250);
                }
            }
        });

        $(beesCloser).click(new Function() {
            public void f(Element e) {
                $(beesMore).slideUp(250);
                $(beesBtn).removeClass(appResources.style().collapsable());
                $(bees).removeClass(pageResources.style().opened());
            }
        });
    }
}
