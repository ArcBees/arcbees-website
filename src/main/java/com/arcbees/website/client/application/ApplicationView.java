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

package com.arcbees.website.client.application;

import com.arcbees.website.client.resources.AppResources;
import com.google.gwt.dom.client.DivElement;
import com.google.gwt.dom.client.Element;
import com.google.gwt.i18n.client.LocaleInfo;
import com.google.gwt.query.client.Function;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.Event;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.Window.Location;
import com.google.gwt.user.client.ui.IsWidget;
import com.google.gwt.user.client.ui.SimplePanel;
import com.google.gwt.user.client.ui.Widget;
import com.google.inject.Inject;
import com.gwtplatform.mvp.client.ViewImpl;

import static com.google.gwt.query.client.GQuery.$;

public class ApplicationView extends ViewImpl implements ApplicationPresenter.MyView {

    interface Binder extends UiBinder<Widget, ApplicationView> {
    }

    private static final int ANIMATION_DURATION = 400;

    @UiField
    SimplePanel main;
    @UiField
    DivElement sidebar;
    @UiField
    DivElement menuToggle;
    @UiField
    DivElement content;
    @UiField
    DivElement langToggle;
    @UiField
    Object backTop;

    private final AppResources appResources;

    @Inject
    ApplicationView(
            Binder binder,
            AppResources appResources) {
        initWidget(binder.createAndBindUi(this));

        this.appResources = appResources;

        bind();
    }

    @Override
    public void setInSlot(Object slot, IsWidget content) {
        main.setWidget(content);
        Window.scrollTo(0, 0);
    }

    private void bind() {
        $("a", menuToggle).click(new Function() {
            @Override
            public boolean f(Event event) {
                Window.scrollTo(0, 0);

                $(sidebar).toggleClass(appResources.style().active());

                $(menuToggle).removeClass(appResources.style().active());
                if ($(sidebar).hasClass(appResources.style().active())) {
                    $(menuToggle).addClass(appResources.style().active());
                    $(menuToggle).addClass(appResources.style().clicked());
                    $(sidebar).addClass(appResources.style().clicked());
                }

                return false;
            }
        });

        $("a", sidebar).click(new Function() {
            @Override
            public void f() {
                Window.scrollTo(0, 0);

                removeActiveStyle();
            }
        });

        $(content).click(new Function() {
            @Override
            public void f() {
                removeActiveStyle();
            }
        });

        $(langToggle).click(new Function() {
            @Override
            public void f() {
                switchLang();
            }
        });

        $("#monId").toggleClass("myClass", isFrench());

        $(backTop).click(new Function() {
            @Override
            public void f() {
                $("html, body").each(new Function() {
                    @Override
                    public void f(Element element) {
                        new ScrollTopAnimation(element).run(ANIMATION_DURATION);
                    }
                });
            }
        });
    }

    private void switchLang() {
        Window.Location.assign(Location.createUrlBuilder()
                .setPath(buildPath())
                .removeParameter(LocaleInfo.getLocaleQueryParam())
                .buildString());
    }

    private String buildPath() {
        String newLocale;
        if (isFrench()) {
            newLocale = "en";
        } else {
            newLocale = "fr";
        }

        String path = Location.getPath().replaceFirst("/(en|fr)", "");
        path = "/" + newLocale + path;

        return path;
    }

    private void removeActiveStyle() {
        $(sidebar).removeClass(appResources.style().active());
        $(menuToggle).removeClass(appResources.style().active());
    }

    private boolean isFrench() {
        LocaleInfo currentLocale = LocaleInfo.getCurrentLocale();
        return currentLocale.getLocaleName().equals("fr");
    }
}
