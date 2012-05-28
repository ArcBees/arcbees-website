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

package com.arcbees.hive.server.home;

import com.arcbees.hive.server.home.blog.BlogPostParser;
import com.arcbees.hive.server.home.blog.BlogPostParserImpl;
import com.arcbees.hive.server.home.blog.GetBlogPostsHandler;
import com.arcbees.hive.shared.home.blog.GetBlogPosts;

import com.google.inject.Singleton;

import com.gwtplatform.dispatch.server.guice.HandlerModule;

public class HomeModule extends HandlerModule {
    @Override
    protected void configureHandlers() {
        bindHandler(GetBlogPosts.class, GetBlogPostsHandler.class);

        bind(BlogPostParser.class).to(BlogPostParserImpl.class).in(Singleton.class);
    }
}
