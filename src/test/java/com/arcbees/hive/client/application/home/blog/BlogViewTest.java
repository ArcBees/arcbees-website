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

import com.arcbees.core.client.mvp.uihandlers.UiHandlersStrategy;
import com.arcbees.hive.client.application.home.blog.BlogView.Binder;
import com.arcbees.hive.client.application.home.blog.ui.BlogItemWidget;
import com.arcbees.hive.client.application.home.blog.ui.BlogItemWidgetFactory;
import com.arcbees.hive.shared.home.blog.BlogItem;
import com.arcbees.hive.testutil.MockitoMockFactory;
import com.arcbees.hive.testutil.ViewTestBase;
import com.arcbees.hive.testutil.ViewTestModule;
import com.google.gwt.dom.client.Element;
import com.google.gwt.user.client.ui.Widget;
import com.google.inject.Inject;
import com.gwtplatform.tester.MockingBinder;
import org.jukito.JukitoRunner;
import org.jukito.TestSingleton;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.BDDMockito.given;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

/**
 * Test class for {@link BlogView}.
 * 
 * @author Christian Goudreau
 */
@RunWith(JukitoRunner.class)
public class BlogViewTest extends ViewTestBase {
  /**
   * Guice test module.
   */
  public static class Module extends ViewTestModule {
    /**
     * Test {@link Binder} delegating createAndBindUi to {@link MockingBinder}.
     */
    static class MyTestBinder extends MockingBinder<Widget, BlogView> implements Binder {
      @Inject
      public MyTestBinder(final MockitoMockFactory mockitoMockFactory) {
        super(Widget.class, mockitoMockFactory);
      }
    }

    @Override
    protected void configureViewTest() {
      bind(Binder.class).to(MyTestBinder.class);

      bindMock(BlogItemWidget.class).in(TestSingleton.class);
    }
  }

  // SUT
  @Inject
  BlogView view;

  @Inject
  BlogItemWidgetFactory blogItemWidgetFactory;
  @Inject
  BlogItemWidget blogItemWidget;

  @Test
  public void setBlogItemsTest(UiHandlersStrategy<BlogUiHandlers> uiHandlersStrategy, BlogUiHandlers myUiHandlers) {
    // given
    List<BlogItem> blogItems = createSomeBlogItems();

    given(blogItemWidgetFactory.create(any(BlogItem.class))).willReturn(
        blogItemWidget);
    given(blogItemWidget.getOffsetHeight()).willReturn(50);
    given(uiHandlersStrategy.getUiHandlers()).willReturn(myUiHandlers);

    Integer nbColElement = view.maxItems / 2;

    // when
    view.setBlogItems(blogItems);

    // then
    // Let's see if every items are created.
    verify(blogItemWidgetFactory, times(view.maxItems)).create(
        any(BlogItem.class));

    // Let's see if we add half items in the left panel and the other half in
    // right panel.
    verify(view.blogItemsLeftPanel, times(nbColElement)).add(
        any(BlogItemWidget.class), any(Element.class));
    verify(view.blogItemsRightPanel, times(nbColElement)).add(
        any(BlogItemWidget.class), any(Element.class));
  }

  private List<BlogItem> createSomeBlogItems() {
    List<BlogItem> blogItems = new ArrayList<BlogItem>();

    for (Integer i = 0; i < 10; i++) {
      BlogItem blogItem = new BlogItem();

      blogItems.add(blogItem);
    }

    return blogItems;
  }
}
