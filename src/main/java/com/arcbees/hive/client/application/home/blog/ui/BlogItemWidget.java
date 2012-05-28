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

package com.arcbees.hive.client.application.home.blog.ui;

import com.arcbees.hive.shared.home.blog.BlogItem;

import com.google.gwt.i18n.client.DateTimeFormat;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.Widget;
import com.google.inject.Inject;
import com.google.inject.assistedinject.Assisted;
import com.google.inject.name.Named;

public class BlogItemWidget extends Composite {
    public interface Binder extends UiBinder<Widget, BlogItemWidget> {
    }

    @UiField
    HTML blogPostTitle;
    @UiField
    HTML blogPostDateAuthor;
    @UiField
    HTML blogPostContent;
    @UiField
    HTML blogPostLink;

    private final DateTimeFormat dateTimeFormat;

    @Inject
    public BlogItemWidget(final Binder uiBinder,
                          @Assisted final BlogItem blogItem,
                          @Named("BlogPostFormat") final DateTimeFormat dateTimeFormat) {
        initWidget(uiBinder.createAndBindUi(this));

        this.dateTimeFormat = dateTimeFormat;

        refresh(blogItem);
    }

    private void refresh(BlogItem blogItem) {
        blogPostTitle.setHTML(blogItem.getTitle());
        blogPostDateAuthor.setHTML(dateTimeFormat.format(blogItem.getPubDate())
                + " : by " + blogItem.getCreator());
        blogPostContent.setHTML(blogItem.getDescription());
        blogPostLink.setHTML("<a href=" + blogItem.getLink()
                + " target=\"_blank\">Read the full article</a>");
    }
}
