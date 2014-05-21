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

package com.arcbees.hive.client.application.common;

import javax.inject.Inject;

import com.arcbees.hive.client.application.common.HeaderPresenter.MyView;
import com.arcbees.hive.client.application.common.socialmedia.SocialMediaWidget;
import com.arcbees.hive.client.application.common.socialmedia.SocialMediaWidgetFactory;
import com.arcbees.hive.client.application.common.socialmedia.SocialMediaWidgetSize;
import com.google.gwt.dom.client.DivElement;
import com.google.gwt.query.client.Function;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Widget;
import com.gwtplatform.mvp.client.ViewWithUiHandlers;

import static com.google.gwt.query.client.GQuery.$;

public class HeaderView extends ViewWithUiHandlers<HeaderUiHandlers> implements MyView {
    @UiField(provided = true)
    SocialMediaWidget socialMediaWidget;
    @UiField
    DivElement switchLocaleDiv;

    interface Binder extends UiBinder<Widget, HeaderView> {
    }

    @Inject
    HeaderView(Binder uiBinder,
               SocialMediaWidgetFactory socialMediaWidgetFactory) {
        this.socialMediaWidget = socialMediaWidgetFactory.create(SocialMediaWidgetSize.Small);

        initWidget(uiBinder.createAndBindUi(this));

        initHandlers();
    }

    private void initHandlers() {
        $(switchLocaleDiv).click(onClick);
    }

    private Function onClick = new Function() {
        @Override
        public void f() {
            getUiHandlers().switchLocale();
        }
    };
}
