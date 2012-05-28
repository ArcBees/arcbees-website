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

package com.arcbees.hive.client.application.common;

import java.util.List;

import com.arcbees.hive.client.dispatch.AsyncCallbackImpl;
import com.arcbees.hive.shared.home.blog.BlogItem;
import com.arcbees.hive.shared.home.blog.GetBlogPosts;
import com.arcbees.hive.shared.home.blog.GetBlogPostsResult;
import com.google.inject.Inject;
import com.google.web.bindery.event.shared.EventBus;
import com.gwtplatform.dispatch.shared.DispatchAsync;
import com.gwtplatform.mvp.client.PresenterWidget;
import com.gwtplatform.mvp.client.View;

/**
 * @author Christian Goudreau
 */
public class FooterPresenter extends PresenterWidget<FooterPresenter.MyView> {
    /**
     * {@link FooterPresenter}'s view.
     */
    public interface MyView extends View {
        void buildRecentNewsHyperlink(String display, String link);
    }

    private final DispatchAsync dispatcher;

    @Inject
    public FooterPresenter(final EventBus eventBus, final MyView view,
                           final DispatchAsync dispatcher) {
        super(eventBus, view);

        this.dispatcher = dispatcher;
    }

    @Override
    protected void onBind() {
        super.onBind();

        dispatcher.execute(new GetBlogPosts(),
                new AsyncCallbackImpl<GetBlogPostsResult>() {
                    @Override
                    public void onSuccess(GetBlogPostsResult result) {
                        onGetBlogPostsSucceeded(result.getBlogPosts());
                    }
                });
    }

    private void onGetBlogPostsSucceeded(List<BlogItem> blogPosts) {
        for (BlogItem blogItem : blogPosts) {
            getView().buildRecentNewsHyperlink(blogItem.getTitle(),
                    blogItem.getLink());
        }
    }
}
