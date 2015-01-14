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

package com.arcbees.website.client.application.services;

import com.arcbees.gquery.appear.client.Appear;
import com.arcbees.website.client.resources.AnimationsResources;
import com.google.gwt.dom.client.DivElement;
import com.google.gwt.dom.client.Element;
import com.google.gwt.query.client.Function;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Widget;
import com.google.inject.Inject;
import com.gwtplatform.mvp.client.ViewImpl;

import static com.google.gwt.query.client.GQuery.$;

public class ServicesView extends ViewImpl implements ServicesPresenter.MyView {
    @UiField
    DivElement partner;
    @UiField
    DivElement iterative;
    @UiField
    DivElement codeReview;
    @UiField
    DivElement costRisk;
    @UiField
    DivElement learnAdapt;
    private AnimationsResources animationResources;

    interface Binder extends UiBinder<Widget, ServicesView> {
    }

    @Inject
    ServicesView(
            Binder binder,
            AnimationsResources animationResources) {
        this.animationResources = animationResources;
        initWidget(binder.createAndBindUi(this));
        bind();
    }

    private void bind() {
        $(partner,iterative,codeReview,costRisk,learnAdapt).as(Appear.Appear).appear(new Function() {
            @Override
            public void f(Element e) {
                $(e).removeClass(animationResources.style().animationStop());
            }
        })
        .disappear(new Function() {
            @Override
            public void f(Element e) {
                $(e).addClass(animationResources.style().animationStop());
            }
        });
    }
}
