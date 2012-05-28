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

package com.arcbees.hive.client.application.home.blog;

import com.arcbees.core.client.mvp.ViewWithUiHandlers;
import com.arcbees.core.client.mvp.uihandlers.UiHandlersStrategy;
import com.arcbees.hive.client.application.home.blog.BlogPresenter.MyView;
import com.arcbees.hive.client.application.home.blog.ui.BlogItemWidget;
import com.arcbees.hive.client.application.home.blog.ui.BlogItemWidgetFactory;
import com.arcbees.hive.shared.home.blog.BlogItem;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.user.client.ui.Widget;
import com.google.inject.Inject;

import java.util.List;

/**
 * @author Christian Goudreau
 */
public class BlogView extends ViewWithUiHandlers<BlogUiHandlers>
        implements MyView {
    /**
     * {@link BlogView}'s {@link UiBinder}.
     */
    public interface Binder extends UiBinder<Widget, BlogView> {
    }

    @UiField
    HTMLPanel blogItemsLeftPanel;
    @UiField
    HTMLPanel blogItemsRightPanel;
    @UiField
    HTMLPanel blogPanel;
    @UiField
    HTMLPanel session;

    final Integer maxItems = 4;
    final Integer animationDelay = 500;
    private final BlogItemWidgetFactory blogItemWidgetFactory;
    private final Integer marginCorrection = 80;

    @Inject
    public BlogView(final Binder uiBinder,
                    final BlogItemWidgetFactory blogItemWidgetFactory,
                    final UiHandlersStrategy<BlogUiHandlers> uiHandlersStrategy) {
        super(uiHandlersStrategy);

        initWidget(uiBinder.createAndBindUi(this));

        this.blogItemWidgetFactory = blogItemWidgetFactory;
    }

    @Override
    public void setBlogItems(final List<BlogItem> blogItems) {
        if (blogItems != null && blogItems.size() > 0 && blogItemsLeftPanel.getWidgetCount() <= 0) {
            Boolean alternate = true;
            blogItemsRightPanel.clear();
            blogItemsLeftPanel.clear();

            Integer blogItemsLeftPanelOffset = 0;
            Integer blogItemsRightPanelOffset = 0;

            for (Integer i = 0; i < blogItems.size() && i < maxItems; i++) {
                BlogItem blogItem = blogItems.get(i);

                BlogItemWidget blogItemWidget = blogItemWidgetFactory.create(blogItem);

                if (alternate) {
                    blogItemsLeftPanel.add(blogItemWidget,
                            blogItemsLeftPanel.getElement());

                    blogItemsLeftPanelOffset += blogItemWidget.getOffsetHeight();
                } else {
                    blogItemsRightPanel.add(blogItemWidget,
                            blogItemsRightPanel.getElement());

                    blogItemsRightPanelOffset += blogItemWidget.getOffsetHeight();
                }

                alternate = !alternate;
            }

            blogItemsLeftPanel.setHeight(blogItemsLeftPanelOffset + "px");
            blogItemsRightPanel.setHeight(blogItemsRightPanelOffset + "px");

            Integer height = blogItemsLeftPanelOffset > blogItemsRightPanelOffset
                    ? blogItemsLeftPanelOffset : blogItemsRightPanelOffset;

            height += marginCorrection + session.getOffsetHeight();

            blogPanel.setHeight(height + "px");

            getUiHandlers().resize(height);
        } else if (blogItemsLeftPanel.getWidgetCount() > 0) {
            getUiHandlers().resize(asWidget().getOffsetHeight());
        }
    }
}
