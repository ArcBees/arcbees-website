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

package com.arcbees.website.client.application.products;

import com.arcbees.website.client.resources.PageProductResources;
import com.google.gwt.dom.client.Element;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.IsWidget;
import com.google.gwt.user.client.ui.SimplePanel;
import com.google.gwt.user.client.ui.Widget;
import com.google.inject.Inject;
import com.gwtplatform.mvp.client.ViewImpl;

import static com.google.gwt.query.client.GQuery.$;

public class ProductsView extends ViewImpl implements ProductsPresenter.MyView {
    interface Binder extends UiBinder<Widget, ProductsView> {
    }

    @UiField
    SimplePanel products;
    @UiField
    Element productHead;

    private final String headClassNames;
    private final PageProductResources pageProductResources;

    @Inject
    ProductsView(
            Binder binder,
            PageProductResources pageProductResources) {
        initWidget(binder.createAndBindUi(this));

        this.pageProductResources = pageProductResources;

        headClassNames = $(productHead).attr("class");
    }

    @Override
    public void setInSlot(Object slot, IsWidget content) {
        products.setWidget(content);
    }

    @Override
    public void selectProduct(String nameToken) {
        String className = $("a[href=#" + nameToken + "]", productHead).attr("data-style");

        $(productHead).find("a").removeClass(pageProductResources.style().active());
        $("a[href=#" + nameToken + "]", productHead).addClass(pageProductResources.style().active());

        $(productHead).removeClass();
        $(productHead).addClass(headClassNames);
        $(productHead).addClass(className);
    }
}
