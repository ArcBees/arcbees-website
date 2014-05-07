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

package com.arcbees.hive.server.home.blog;

import javax.inject.Inject;

import com.arcbees.hive.shared.home.blog.GetBlogPosts;
import com.arcbees.hive.shared.home.blog.GetBlogPostsResult;
import com.google.common.collect.Lists;
import com.gwtplatform.dispatch.rpc.server.ExecutionContext;
import com.gwtplatform.dispatch.rpc.server.actionhandler.AbstractActionHandler;
import com.gwtplatform.dispatch.shared.ActionException;

public class GetBlogPostsHandler extends
        AbstractActionHandler<GetBlogPosts, GetBlogPostsResult> {
    private final BlogPostParser blogPostParser;

    @Inject
    GetBlogPostsHandler(BlogPostParser blogPostParser) {
        super(GetBlogPosts.class);

        this.blogPostParser = blogPostParser;
    }

    @Override
    public GetBlogPostsResult execute(GetBlogPosts action,
                                      ExecutionContext context) throws ActionException {

        return new GetBlogPostsResult(Lists.newArrayList(blogPostParser.parse()));
    }

    @Override
    public void undo(GetBlogPosts action, GetBlogPostsResult result,
                     ExecutionContext context) throws ActionException {
    }
}
