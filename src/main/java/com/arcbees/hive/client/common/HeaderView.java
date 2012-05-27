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

package com.arcbees.hive.client.common;

import com.arcbees.hive.client.common.HeaderPresenter.MyView;
import com.arcbees.hive.client.mvp.ViewWithUiHandlers;
import com.arcbees.hive.client.mvp.strategies.UiHandlersStrategy;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.ui.Widget;
import com.google.inject.Inject;
import com.gwtplatform.mvp.client.UiHandlers;

/**
 * @author Christian Goudreau
 * @author Zachary Keatts
 */
public class HeaderView extends ViewWithUiHandlers<HeaderUiHandlers> implements MyView {

  
  /**
   * {@link HeaderView}'s binder.
   */
  public interface Binder extends UiBinder<Widget, HeaderView> {
  }

  @Inject
  public HeaderView(final Binder uiBinder, final UiHandlersStrategy<HeaderUiHandlers> uiHandlersStrategy) {
    super(uiHandlersStrategy);
    
    initWidget(uiBinder.createAndBindUi(this));
  }

  @UiHandler("header")
  void onHeaderClicked(ClickEvent event) {
    getUiHandlers().showHome();
  }
}
