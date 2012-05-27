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

package com.arcbees.hive.client.home.blog.ui;

import com.arcbees.hive.client.home.blog.ui.BlogItemWidget.Binder;
import com.arcbees.hive.shared.home.blog.BlogItem;
import com.arcbees.hive.testutil.MockitoMockFactory;
import com.arcbees.hive.testutil.ViewTestBase;
import com.arcbees.hive.testutil.ViewTestModule;

import com.google.gwt.i18n.client.DateTimeFormat;
import com.google.gwt.user.client.ui.Widget;
import com.google.inject.Inject;
import com.google.inject.name.Named;

import com.gwtplatform.tester.MockingBinder;

import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.verify;

import org.jukito.JukitoRunner;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.Date;

/**
 * Test class for {@link BlogItemWidgetFactory}.
 * 
 * @author Christian Goudreau
 */
@RunWith(JukitoRunner.class)
public class BlogItemWidgetTest extends ViewTestBase {
  /**
   * Guice test module.
   */
  public static class Module extends ViewTestModule {
    /**
     * Test {@link Binder} delegating createAndBindUi to {@link MockingBinder}.
     */
    static class MyTestBinder extends MockingBinder<Widget, BlogItemWidget>
        implements Binder {
      @Inject
      public MyTestBinder(final MockitoMockFactory mockitoMockFactory) {
        super(Widget.class, mockitoMockFactory);
      }
    }

    @Override
    protected void configureViewTest() {
      bind(Binder.class).to(MyTestBinder.class);
      bindNamedMock(DateTimeFormat.class, "BlogPostFormat");
    }
  }

  @Inject
  Binder binder;
  @Inject @Named("BlogPostFormat")
  DateTimeFormat dateTimeFormat;

  private Date testDate = new Date();

  @Test
  public void createTest() {
    // when
    BlogItemWidget blogItemWidget = new BlogItemWidget(binder, createBlogItem(), dateTimeFormat);
    
    // then
    verify(blogItemWidget.blogPostContent).setHTML(anyString());
    verify(blogItemWidget.blogPostDateAuthor).setHTML(anyString());
    verify(blogItemWidget.blogPostLink).setHTML(anyString());
    verify(blogItemWidget.blogPostTitle).setHTML(anyString());
  }

  private BlogItem createBlogItem() {
    BlogItem blogItem = new BlogItem();

    blogItem.setCreator("Sydney Crosby");
    blogItem.setDescription("Alexander Ovechkin");
    blogItem.setLink("Yaroslav Halak");
    blogItem.setPubDate(testDate);
    blogItem.setTitle("Bob Gainey");

    return blogItem;
  }
}
