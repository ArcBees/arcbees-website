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

import com.arcbees.hive.client.dispatch.AsyncCallbackImpl;
import com.arcbees.hive.client.application.home.HomePresenter;
import com.arcbees.hive.client.application.home.event.ResizeEvent;
import com.arcbees.hive.client.place.NameTokens;
import com.arcbees.hive.shared.home.blog.BlogItem;
import com.arcbees.hive.shared.home.blog.GetBlogPosts;
import com.arcbees.hive.shared.home.blog.GetBlogPostsResult;
import com.google.inject.Inject;
import com.google.web.bindery.event.shared.EventBus;
import com.gwtplatform.dispatch.shared.DispatchAsync;
import com.gwtplatform.mvp.client.Presenter;
import com.gwtplatform.mvp.client.View;
import com.gwtplatform.mvp.client.annotations.NameToken;
import com.gwtplatform.mvp.client.annotations.ProxyStandard;
import com.gwtplatform.mvp.client.proxy.ProxyPlace;
import com.gwtplatform.mvp.client.proxy.RevealContentEvent;

import java.util.List;

public class BlogPresenter extends
        Presenter<BlogPresenter.MyView, BlogPresenter.MyProxy> implements
        BlogUiHandlers {
    @ProxyStandard
    @NameToken(NameTokens.blog)
    public interface MyProxy extends ProxyPlace<BlogPresenter> {
    }

    public interface MyView extends View {
        void setBlogItems(List<BlogItem> blogItems);
    }

    private final DispatchAsync dispatcher;
    private final Integer minSize = 527;

    @Inject
    public BlogPresenter(final EventBus eventBus, final MyView view,
                         final MyProxy proxy, final DispatchAsync dispatcher) {
        super(eventBus, view, proxy);

        this.dispatcher = dispatcher;
    }

    @Override
    public void resize(final Integer size) {
        ResizeEvent.fire(BlogPresenter.this, HomePresenter.TYPE_SetBottomContent1,
                size);
    }

    @Override
    protected void revealInParent() {
        RevealContentEvent.fire(this, HomePresenter.TYPE_SetBottomContent1, this);
    }

    @Override
    protected void onReveal() {
        super.onReveal();

        dispatcher.execute(new GetBlogPosts(),
                new AsyncCallbackImpl<GetBlogPostsResult>() {
                    @Override
                    public void onSuccess(GetBlogPostsResult result) {
                        getView().setBlogItems(result.getBlogPosts());
                    }

                    @Override
                    public void onFailure(Throwable e) {
                        super.onFailure(e);

                        ResizeEvent.fire(BlogPresenter.this, HomePresenter.TYPE_SetBottomContent1, minSize);
                    }
                });
    }
}
