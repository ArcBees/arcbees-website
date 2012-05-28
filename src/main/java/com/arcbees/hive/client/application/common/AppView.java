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

import com.arcbees.core.client.mvp.ViewImpl;
import com.arcbees.hive.client.application.common.AppPresenter.MyView;
import com.arcbees.hive.client.place.AppIds;

import static com.google.gwt.query.client.GQuery.$;
import static com.google.gwt.query.client.plugins.Effects.Effects;

import com.google.gwt.dom.client.Element;
import com.google.gwt.query.client.Function;
import com.google.gwt.query.client.Properties;
import com.google.gwt.query.client.plugins.effects.PropertiesAnimation.Easing;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.user.client.ui.Widget;
import com.google.inject.Inject;

/**
 * @author Christian Goudreau
 */
public class AppView extends ViewImpl implements MyView {
    /**
     * {@link AppView}'s {@link UiBinder}.
     */
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
    HTMLPanel footer;

    private Integer delay = 300;
    private Boolean blockFade = false;
    private Widget lastWidget;

    /**
     * {@link Function} that insure that we wait until every fade animation is
     * finished before unblocking upcoming fade animation.
     */
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
    public void setInSlot(Object slot, Widget content) {
        if (slot == AppPresenter.TYPE_SetMainContent) {
            fadeWidget(content);
        } else if (slot == AppPresenter.TYPE_setHeader) {
            header.clear();
            header.add(content, header.getElement());
        } else if (slot == AppPresenter.TYPE_setFooter) {
            footer.clear();
            footer.add(content, footer.getElement());
        }
    }

    @Override
    public void resizeSlot(Object slot, Integer size) {
        if (slot == AppPresenter.TYPE_SetMainContent) {
            resize(mainContent, size);
        }
    }

    private void fadeWidget(Widget content) {
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

    /**
     * Used to start the animation that switch the opacity of the two fade block.
     *
     * @param fadeBlock The fade block to show.
     * @param element   The {@link Element} of the second block to hide.
     */
    private void switchFade(HTMLPanel fadeBlock, Element element, Widget content) {
        fadeBlock.clear();
        fadeBlock.add(content);

        if (fadeBlock.isAttached()) {
            blockFade = true;

            if ($("#" + AppIds.getIframeId()).visible()) {
                $("#" + AppIds.getIframeId()).hide();
            } else {
                $("#" + AppIds.getIframeId()).show();
            }

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