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

package com.arcbees.hive.client.dispatch;

import com.arcbees.hive.client.application.home.blog.GetBlogPostsCache;

import com.google.inject.Inject;

import com.gwtplatform.dispatch.client.actionhandler.DefaultClientActionHandlerRegistry;

/**
 * Registry that register every
 * {@link com.gwtplatform.dispatch.client.actionhandler.ClientActionHandler} for
 * this application. Every action that need to be cached should use an
 * {@link com.gwtplatform.dispatch.client.actionhandler.caching.AbstractCachingClientActionHandler}
 * and register it here.
 * 
 * @author Christian Goudreau
 */
public class MyClientActionHandlerRegistry extends
    DefaultClientActionHandlerRegistry {
  @Inject
  public MyClientActionHandlerRegistry(GetBlogPostsCache getBlogPostsClientActionHandler) {
    register(getBlogPostsClientActionHandler);
  }
}
