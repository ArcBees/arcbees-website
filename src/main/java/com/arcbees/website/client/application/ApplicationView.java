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

import com.arcbees.analytics.shared.Analytics;
import com.arcbees.website.client.resources.AppResources;
import com.google.gwt.dom.client.AnchorElement;
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
    private static final int STATE_CLOSED = 0;
    private static final int STATE_OPENED = 1;
    private static final int STATE_CLICKED = 2;

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
    @UiField
    AnchorElement githubLink;

    private final AppResources appResources;
    private final Analytics analytics;
    
    public int menuState;

    @Inject
    ApplicationView(
            Binder binder,
            AppResources appResources,
            Analytics analytics) {
        initWidget(binder.createAndBindUi(this));

        this.analytics = analytics;
        this.appResources = appResources;

        setMenuState(STATE_CLOSED);

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

        // Always call watchMenu, the filtering is done by the function, fixing the multiple calls bug
        $(sidebar).hover(new Function() {
            @Override
            public void f() {
                watchMenu();
            }
        }, new Function() {
            @Override
        public void f() {
                watchMenu();
            }
        });

        $("a", sidebar).click(new Function() {
            @Override
            public void f() {
                Window.scrollTo(0, 0);

                removeActiveStyle();

                analytics.sendEvent("Menu", "Click").eventLabel($(this).attr("data-label")).go();

                setMenuState(STATE_CLICKED);
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
                analytics.sendEvent("Meta", "Click").eventLabel("Switch lang").go();

                switchLang();
            }
        });

        $(githubLink).click(new Function() {
            @Override
            public void f() {
                analytics.sendEvent("Meta", "Click").eventLabel("Github").go();
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

    private void watchMenu() {
        // Hack to get the real menu state (on hover, links trigger false data with .hover())
        int hoverState = $("." + appResources.style().sidebar() + ":hover").length();

        // Not tracking mobile as we always need to toggle the menu
        if(! $(sidebar).hasClass(appResources.style().clicked())) {
            if (menuState != hoverState) {
                if (menuState != STATE_CLICKED) {
                    setMenuState(hoverState);
                    if (menuState == STATE_CLOSED) {
                        analytics.sendEvent("Menu", "State").eventLabel("Close, no link clicked").go();
                    } else {
                        analytics.sendEvent("Menu", "State").eventLabel("Open").go();
                    }
                } else {
                    if (menuClosing(hoverState)) {
                        setMenuState(STATE_CLOSED);
                        analytics.sendEvent("Menu", "State").eventLabel("Close, link clicked").go();
                    }
                }
            }
        }
    }

    private void setMenuState(int state) {
        menuState = state;
    }

    private boolean menuClosing(int hoverState) {
        return hoverState == STATE_CLOSED;
    }
}
