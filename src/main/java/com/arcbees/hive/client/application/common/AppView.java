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

package com.arcbees.hive.client.application.common;

import javax.inject.Inject;

import com.arcbees.hive.client.application.common.AppPresenter.MyView;
import com.google.gwt.dom.client.Element;
import com.google.gwt.query.client.Function;
import com.google.gwt.query.client.Properties;
import com.google.gwt.query.client.plugins.effects.PropertiesAnimation.Easing;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.user.client.ui.IsWidget;
import com.google.gwt.user.client.ui.SimplePanel;
import com.google.gwt.user.client.ui.Widget;
import com.gwtplatform.mvp.client.ViewImpl;

import static com.google.gwt.query.client.GQuery.$;
import static com.google.gwt.query.client.plugins.Effects.Effects;

public class AppView extends ViewImpl implements MyView {
    public interface Binder extends UiBinder<Widget, AppView> {
    }

    @UiField
    HTMLPanel mainContent;
    @UiField
    HTMLPanel mainContent1;
    @UiField
    HTMLPanel mainContent2;
    @UiField
    HTMLPanel header;
    @UiField
    SimplePanel customers;
    @UiField
    HTMLPanel footer;
    @UiField
    SimplePanel navbarPanel;

    private Integer delay = 300;
    private Boolean blockFade = false;
    private IsWidget lastWidget;

    private Function fadeFunction = new Function() {
        @Override
        public void f(Element e) {
            blockFade = false;
        }
    };

    @Inject
    public AppView(final Binder uiBinder) {
        initWidget(uiBinder.createAndBindUi(this));
    }

    @Override
    public void setInSlot(Object slot, IsWidget content) {
        if (slot == AppPresenter.SLOT_SetMainContent) {
            fadeWidget(content);
        } else if (slot == AppPresenter.SLOT_setHeader) {
            header.clear();
            header.add(content.asWidget(), header.getElement());
        } else if (slot == AppPresenter.SLOT_setCustomers) {
            customers.clear();
            customers.setWidget(content);
        } else if (slot == AppPresenter.SLOT_setFooter) {
            footer.clear();
            footer.add(content.asWidget(), footer.getElement());
        } else if(slot == AppPresenter.SLOT_setNavbar){
            navbarPanel.clear();
            navbarPanel.setWidget(content);
        }
    }

    @Override
    public void resizeSlot(Object slot, Integer size) {
        if (slot == AppPresenter.SLOT_SetMainContent) {
            resize(mainContent, size);
        }
    }

    private void fadeWidget(IsWidget content) {
        // Make sure that fading effect isn't blocked.
        if (!blockFade && !content.equals(lastWidget)) {
            lastWidget = content;

            if (mainContent2.isVisible() && !mainContent1.isVisible()) {
                switchFade(mainContent1, mainContent2.getElement(), content);
            } else if (!mainContent2.isVisible()) {
                switchFade(mainContent2, mainContent1.getElement(), content);
            }
        }
    }

    private void switchFade(HTMLPanel fadeBlock, Element element, IsWidget content) {
        fadeBlock.clear();
        fadeBlock.add(content);

        if (fadeBlock.isAttached()) {
            blockFade = true;

            $(fadeBlock).fadeIn(delay, fadeFunction);
            $(element).fadeOut(delay, fadeFunction);
        } else {
            mainContent1.setVisible(false);
            mainContent2.setVisible(false);

            fadeBlock.setVisible(true);
        }
    }

    private void resize(HTMLPanel resizablePanel, Integer height) {
        $(resizablePanel).as(Effects).animate(
                Properties.create("{ " + "height: '" + String.valueOf(height) + "px'}"),
                delay, Easing.LINEAR, new Function() {
            @Override
            public void f(Element e) {
            }
        });
    }
}
