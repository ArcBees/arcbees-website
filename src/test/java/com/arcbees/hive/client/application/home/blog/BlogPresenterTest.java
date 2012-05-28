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

import com.arcbees.hive.shared.home.blog.BlogItem;
import com.arcbees.hive.shared.home.blog.GetBlogPosts;
import com.arcbees.hive.shared.home.blog.GetBlogPostsResult;
import com.arcbees.hive.testutil.PresenterTestModule;
import com.arcbees.hive.testutil.PresenterWidgetTestBase;

import com.google.inject.Inject;

import static org.mockito.Matchers.anyListOf;
import static org.mockito.Mockito.verify;

import org.jukito.JukitoRunner;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.ArrayList;

@RunWith(JukitoRunner.class)
public class BlogPresenterTest extends PresenterWidgetTestBase {
    public static class Module extends PresenterTestModule {
        @Override
        protected void configurePresenterTest() {
        }
    }

    // SUT
    @Inject
    BlogPresenter presenter;
    @Inject
    BlogPresenter.MyView view;

    @Test
    public void onBindTest() {
        // given
        dispatcher.when(GetBlogPosts.class).thenSucceed(new GetBlogPostsResult(new ArrayList<BlogItem>()));

        // when
        presenter.onReveal();

        // then
        verify(view).setBlogItems(anyListOf(BlogItem.class));
    }
}
