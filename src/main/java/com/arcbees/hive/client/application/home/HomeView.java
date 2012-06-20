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
    Anchor btGWTP;
    @UiField
    Anchor btJukito;
    @UiField
    Anchor btGAE;

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
            view.@com.arcbees.hive.client.application.home.HomeView::setEnabled(I)(data.page);
        }

        $wnd.$('#sliderProductsCarousel').rcarousel(
                {auto:{enabled:true, direction:"prev", interval:6000},
                    orientation:"vertical",
                    width:725,
                    height:88,
                    visible:1,
                    step:1,
                    speed:1000,
                    pageLoaded:pageLoaded
                });
    }-*/;

    private void setEnabled(int index) {
        disableAll();

        Anchor selected = btGWTP;

        switch (index) {
            case 0:
                selected = btGWTP;
                break;
            case 2:
                selected = btJukito;
                break;
            case 1:
                selected = btGAE;
                break;
            default:
                Window.alert("wrong index: " + index);
                break;
        }

        enable(selected);
    }

    private void disableAll() {
        disableAnchor(btGWTP);
        disableAnchor(btJukito);
        disableAnchor(btGAE);
    }

    private void disableAnchor(Anchor toDisable) {
        toDisable.setStyleName(homeResources.style().sliderProductsOff());
    }

    private void enable(Anchor selected) {
        selected.setStyleName(homeResources.style().sliderProductsOn());
    }
}
