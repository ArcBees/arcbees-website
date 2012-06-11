/*
 * Copyright 2010 ArcBees Inc.
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

package com.arcbees.hive.client.application.products;

import com.arcbees.core.client.mvp.ViewImpl;
import com.arcbees.hive.client.application.products.ProductsPresenter.MyView;
import com.arcbees.hive.client.resource.Resources;
import com.arcbees.hive.client.resource.products.ProductsResources;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.query.client.Function;
import com.google.gwt.query.client.GQuery;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Anchor;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.user.client.ui.Widget;
import com.google.inject.Inject;

import static com.google.gwt.query.client.GQuery.$;

public class ProductsView extends ViewImpl implements MyView {
    @UiField
    Anchor btGWTP;
    @UiField
    Anchor btJukito;
    @UiField
    Anchor btGAE;
    @UiField
    Anchor btBH;
    @UiField
    HTMLPanel productsTextContainer;

    private final Resources resources;
    private final ProductsResources productsResources;
    private final Resources.Style resourcesStyle;
    private final ProductsResources.Style productsStyle;

    public interface Binder extends UiBinder<Widget, ProductsView> {
    }

    @Inject
    public ProductsView(final Binder uiBinder,
                        final ProductsResources productsResources,
                        final Resources resources) {
        this.resources = resources;
        this.productsResources = productsResources;
        this.productsStyle = productsResources.style();
        this.resourcesStyle = resources.style();
        initWidget(uiBinder.createAndBindUi(this));
    }

    @UiHandler("btGWTP")
    public void onBtGWTP(ClickEvent event) {
        changeProduct(0);
    }

    @UiHandler("btJukito")
    public void onBtJukito(ClickEvent event) {
        changeProduct(1);
    }

    @UiHandler("btGAE")
    public void onBtGAE(ClickEvent event) {
        changeProduct(2);
    }

    @UiHandler("btBH")
    public void onBtBH(ClickEvent event) {
        changeProduct(3);
    }

    private void changeProduct(int index) {
        switchImg(index);
        switchTxt(index);
    }

    private void switchTxt(int index) {
        Widget widgetSelected = productsTextContainer.getWidget(index);
        final Resources.Style style = resources.style();
        if (!widgetSelected.getStyleName().equals(style.textOn())) {
            widgetSelected.setStyleName(style.textOnBack());
            widgetSelected.getElement().setAttribute("style", "display:none");
            $("." + style.textOn()).fadeOut(500, new Function() {
                @Override
                public void f() {
                    int widgetCount = productsTextContainer.getWidgetCount();
                    GQuery widgetOnBack = $("." + style.textOnBack());

                    for (int i = 0; i < widgetCount; i++) {
                        Widget currentWidget = productsTextContainer.getWidget(i);
                        currentWidget.getElement().setAttribute("style", "display:none");

                        if (!currentWidget.getStyleName().equals(style.textOnBack())) {
                            currentWidget.getElement().setClassName("");
                        }
                    }
                    widgetOnBack.fadeIn(500, new Function() {
                        @Override
                        public void f() {

                            GQuery widgetOnBack = $("." + style.textOnBack());
                            widgetOnBack.removeClass(style.textOnBack());
                            widgetOnBack.addClass(style.textOn());
                        }
                    });
                }
            });
        }
    }
    private void switchImg(int index) {
        disableAll();
        switch (index) {
            case 0:
                btGWTP.setStyleName(productsStyle.productsGWTPOn());
                break;
            case 1:
                btJukito.setStyleName(productsStyle.productsJukitoOn());
                break;
            case 2:
                btGAE.setStyleName(productsStyle.productsGAEOn());
                break;
            case 3:
                btBH.setStyleName(productsStyle.productsBHOn());
                break;
            default:
                Window.alert("wrong index: " + index);
                break;
        }
    }

    private void disableAll() {
        btGWTP.setStyleName(productsStyle.productsGWTP());
        btJukito.setStyleName(productsStyle.productsJukito());
        btGAE.setStyleName(productsStyle.productsGAE());
        btBH.setStyleName(productsStyle.productsBH());
    }
}


