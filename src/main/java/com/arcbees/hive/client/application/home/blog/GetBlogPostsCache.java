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

import com.arcbees.hive.shared.home.blog.GetBlogPosts;
import com.arcbees.hive.shared.home.blog.GetBlogPostsResult;

import com.google.inject.Inject;

import com.gwtplatform.dispatch.client.actionhandler.caching.AbstractCachingClientActionHandler;
import com.gwtplatform.dispatch.client.actionhandler.caching.Cache;

/**
 * {@link com.gwtplatform.dispatch.client.actionhandler.ClientActionHandler}
 * that handle how {@link GetBlogPosts}
 * {@link com.gwtplatform.dispatch.shared.Action} are being stored in client
 * side {@link Cache}.
 * 
 * @author Christian Goudreau
 */
public class GetBlogPostsCache extends
    AbstractCachingClientActionHandler<GetBlogPosts, GetBlogPostsResult> {
  @Inject
  GetBlogPostsCache(Cache cache) {
    super(GetBlogPosts.class, cache);
  }

  @Override
  protected GetBlogPostsResult prefetch(GetBlogPosts action) {
    return (GetBlogPostsResult) getCache().get(action);
  }

  @Override
  protected void postfetch(GetBlogPosts action, GetBlogPostsResult result) {
    if (action != null && result != null) {
      getCache().put(action, result);
    }
  }
}
