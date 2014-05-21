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

package com.arcbees.hive.client.application.products;

import com.arcbees.hive.client.application.products.ProductsPresenter.MyView;
import com.arcbees.hive.client.resource.products.ProductsResources;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.ui.Anchor;
import com.google.gwt.user.client.ui.Widget;
import com.google.inject.Inject;
import com.gwtplatform.mvp.client.ViewImpl;

import static com.google.gwt.query.client.GQuery.$;

public class ProductsView extends ViewImpl implements MyView {
    @UiField
    Anchor btGWTP;
    @UiField
    Anchor btJukito;
    @UiField
    Anchor btGAE;

    private final ProductsResources.Style productsStyle;

    public interface Binder extends UiBinder<Widget, ProductsView> {
    }

    private String previousProductId = ProductIds.gwtp();

    @Inject
    public ProductsView(final Binder uiBinder,
                        final ProductsResources productsResources) {
        this.productsStyle = productsResources.style();
        initWidget(uiBinder.createAndBindUi(this));
    }

    @UiHandler("btGWTP")
    public void onBtGWTP(ClickEvent event) {
        switchTo(btGWTP, productsStyle.productsGWTPOn(), ProductIds.gwtp());
    }

    @UiHandler("btJukito")
    public void onBtJukito(ClickEvent event) {
        switchTo(btJukito, productsStyle.productsJukitoOn(), ProductIds.jukito());
    }

    @UiHandler("btGAE")
    public void onBtGAE(ClickEvent event) {
        switchTo(btGAE, productsStyle.productsGAEOn(), ProductIds.gaeStudio());
    }

    private void switchTo(Anchor anchor, String style, String productId) {
        disableAll();
        anchor.setStyleName(style);
        switchText(productId);
    }

    private void switchText(String productId) {
        stopAllAnimations();

        $("#" + productId).fadeIn(500);
        $("#" + previousProductId).fadeOut(100);

        previousProductId = productId;
    }

    private void stopAllAnimations() {
        $("#productsTextContainer > div").stop(true, true);
    }

    private void disableAll() {
        btGWTP.setStyleName(productsStyle.productsGWTP());
        btJukito.setStyleName(productsStyle.productsJukito());
        btGAE.setStyleName(productsStyle.productsGAE());
    }
}
