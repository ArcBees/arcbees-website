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

package com.arcbees.website.client.application.ui;

import com.arcbees.website.client.resources.AppResources;
import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.DivElement;
import com.google.gwt.dom.client.Element;
import com.google.gwt.query.client.Function;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.user.client.ui.IsWidget;
import com.google.gwt.user.client.ui.Widget;

import static com.google.gwt.query.client.GQuery.$;

public class ProductsCarousel implements IsWidget {
    interface Binder extends UiBinder<HTMLPanel, ProductsCarousel> {
    }

    private static Binder BINDER = GWT.create(Binder.class);

    private final HTMLPanel root;

    @UiField
    DivElement carousel;
    @UiField
    AppResources res;

    public ProductsCarousel() {
        root = BINDER.createAndBindUi(this);

        bind();
    }

    @Override
    public Widget asWidget() {
        return root;
    }

    public void bind() {
        $("a", carousel).mouseenter(new Function() {
            public void f(Element e) {
                $("a", carousel).removeClass(res.style().active());
                $(this).addClass(res.style().active());
            }
        });
    }
}
