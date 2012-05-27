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

package com.arcbees.hive.client.home;

import com.arcbees.hive.client.common.AppPresenter;
import com.arcbees.hive.client.home.event.ResizeEvent;
import com.arcbees.hive.client.home.event.ResizeEvent.ResizeHandler;
import com.arcbees.hive.client.home.slogan.SloganPresenter;
import com.arcbees.hive.client.place.NameTokens;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.event.shared.GwtEvent.Type;
import com.google.inject.Inject;
import com.gwtplatform.mvp.client.Presenter;
import com.gwtplatform.mvp.client.View;
import com.gwtplatform.mvp.client.annotations.ContentSlot;
import com.gwtplatform.mvp.client.annotations.ProxyEvent;
import com.gwtplatform.mvp.client.annotations.ProxyStandard;
import com.gwtplatform.mvp.client.proxy.*;

/**
 * @author Christian Goudreau
 */
public class HomePresenter extends
    Presenter<HomePresenter.MyView, HomePresenter.MyProxy> implements
        HomeUiHandlers, ResizeHandler, NavigationHandler {
  /**
   * {@link HomePresenter}'s proxy.
   */
  @ProxyStandard
  public interface MyProxy extends Proxy<HomePresenter> {
  }

  /**
   * {@link HomePresenter}'s view.
   */
  public interface MyView extends View {
    void resizeSlot(Object slot, Integer size);
  }

  @ContentSlot
  public static final Type<RevealContentHandler<?>> TYPE_SetBottomContent1 = new Type<RevealContentHandler<?>>();
  @ContentSlot
  public static final Type<RevealContentHandler<?>> TYPE_SetBottomContent2 = new Type<RevealContentHandler<?>>();
  @ContentSlot
  public static final Type<RevealContentHandler<?>> TYPE_SetBottomContent3 = new Type<RevealContentHandler<?>>();
  @ContentSlot
  public static final Type<RevealContentHandler<?>> TYPE_SetBottomContent4 = new Type<RevealContentHandler<?>>();

  public static final Object TYPE_SetTopContent = new Object();

  private final SloganPresenter sloganPresenter;
  private final Integer bottomMargin = 41;
  private final Integer minSize = 827;

  @Inject
  public HomePresenter(final EventBus eventBus, final MyView view,
      final MyProxy proxy, final SloganPresenter sloganPresenter) {
    super(eventBus, view, proxy);

    this.sloganPresenter = sloganPresenter;
  }

  @Override
  protected void revealInParent() {
    RevealContentEvent.fire(this, AppPresenter.TYPE_SetMainContent, this);
  }

  @Override
  protected void onBind() {
    super.onBind();

    setInSlot(TYPE_SetTopContent, sloganPresenter);

    addRegisteredHandler(ResizeEvent.getType(), this);
  }

  @Override
  public void onResize(ResizeEvent event) {
    if (event.getSlot().equals(TYPE_SetBottomContent1) || event.getSlot().equals(TYPE_SetBottomContent2) || event.getSlot().equals(TYPE_SetBottomContent3) || event.getSlot().equals(TYPE_SetBottomContent4)) {
      Integer size = event.getSize() + bottomMargin;
      getView().resizeSlot(event.getSlot(), size);
    }
  }

  @Override
  @ProxyEvent
  public void onNavigation(NavigationEvent navigationEvent) {
    if (navigationEvent.getRequest().matchesNameToken(NameTokens.blog)) {
      sloganPresenter.defaultDescription();
    } else if (navigationEvent.getRequest().matchesNameToken(NameTokens.consulting)) {
      sloganPresenter.showConsulting();
    } else if (navigationEvent.getRequest().matchesNameToken(NameTokens.development)) {
      sloganPresenter.showDevelopment();
    } else if (navigationEvent.getRequest().matchesNameToken(NameTokens.successStory)) {
      sloganPresenter.showSuccess();
    }
  }

  @Override
  public void resize(int height) {
    ResizeEvent.fire(this, AppPresenter.TYPE_SetMainContent, height);
  }
  
  @Override
  protected void onReveal() {
    super.onReveal();

    ResizeEvent.fire(this, AppPresenter.TYPE_SetMainContent, minSize);
  }
}
