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

package com.arcbees.hive.client.application.home;

import com.arcbees.core.client.mvp.ViewWithUiHandlers;
import com.arcbees.core.client.mvp.uihandlers.UiHandlersStrategy;
import com.arcbees.hive.client.application.home.HomePresenter.MyView;
import com.arcbees.hive.client.resource.home.HomeResources;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Anchor;
import com.google.gwt.user.client.ui.Widget;
import com.google.inject.Inject;

public class HomeView extends ViewWithUiHandlers<HomeUiHandlers> implements
        MyView {
    @UiField
    Anchor btProduct0;
    @UiField
    Anchor btProduct1;
    @UiField
    Anchor btProduct2;

    @UiField
    Anchor btProduct3;

    private final HomeResources homeResources;

    public interface Binder extends UiBinder<Widget, HomeView> {

    }

    @Inject
    public HomeView(final Binder uiBinder,
                    UiHandlersStrategy<HomeUiHandlers> uiHandlersStrategy, HomeResources homeResources) {
        super(uiHandlersStrategy);
        this.homeResources = homeResources;

        initWidget(uiBinder.createAndBindUi(this));
    }

    @Override
    public void startCarousel() {
        startCarouselNative(this);
    }

    public native void startCarouselNative(HomeView view) /*-{
        function pageLoaded(event, data) {
            console.log("hello");
            view.@com.arcbees.hive.client.application.home.HomeView::setEnabled(I)(data.page);
        }

        $wnd.$('#sliderProductsCarousel').rcarousel(
                {auto:{enabled:true, direction:"next", interval:9000},
                    orientation:"vertical",
                    width:725,
                    height:88,
                    visible:1,
                    step:1,
                    speed:2000,
                    pageLoaded:pageLoaded
                });
    }-*/;

    @UiHandler("btProduct0")
    public void onBtProduct0(ClickEvent event) {
        slideToProduct(0);
    }

    @UiHandler("btProduct1")
    public void onBtProduct1(ClickEvent event) {
        slideToProduct(1);
    }

    @UiHandler("btProduct2")
    public void onBtProduct2(ClickEvent event) {
        slideToProduct(2);
    }

    @UiHandler("btProduct3")
    public void onBtProduct3(ClickEvent event) {
        slideToProduct(3);
    }

    private void slideToProduct(int index) {
        setEnabled(index);
        slideToProductNative(index);
    }

    private void setEnabled(int index) {
        disableAll();

        Anchor selected = btProduct0;

        switch (index) {
            case 0:
                selected = btProduct0;
                break;
            case 1:
                selected = btProduct1;
                break;
            case 2:
                selected = btProduct2;
                break;
            case 3:
                selected = btProduct3;
                break;
            default:
                Window.alert("wront index: " + index);
                break;
        }

        enable(selected);
    }

    private void disableAll() {
        disableAnchor(btProduct0);
        disableAnchor(btProduct1);
        disableAnchor(btProduct2);
        disableAnchor(btProduct3);
    }

    private void disableAnchor(Anchor toDisable) {
        toDisable.setStyleName(homeResources.style().sliderPruductsOff());
    }

    private void enable(Anchor selected) {
        selected.setStyleName(homeResources.style().sliderPruductsOn());
    }

    private native void slideToProductNative(int index) /*-{
        $wnd.$('#sliderProductsCarousel').rcarousel("goToPage", index);
    }-*/;
}
