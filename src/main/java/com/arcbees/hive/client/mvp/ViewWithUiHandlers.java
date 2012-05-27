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

package com.arcbees.hive.client.mvp;

import com.arcbees.hive.client.mvp.strategies.UiHandlersStrategy;

import com.gwtplatform.mvp.client.UiHandlers;

/**
 * This is a replacement for Gwt-Platform's
 * {@link com.gwtplatform.mvp.client.ViewWithUiHandlers} that add a
 * {@link com.google.gwt.user.client.ui.Composite} like behavior by letting us
 * assigning a widget to the {@link com.gwtplatform.mvp.client.View}.
 * 
 * <b>Important</b> call
 * {@link #initWidget(com.google.gwt.user.client.ui.Widget)} in your
 * {@link com.gwtplatform.mvp.client.View}'s constructor.
 * 
 * @param <H> {@link UiHandlers}'s type.
 * 
 * @author Christian Goudreau
 */
public abstract class ViewWithUiHandlers<H extends UiHandlers> extends ViewImpl
    implements UiHandlersStrategy<H> {
  private UiHandlersStrategy<H> uiHandlersStrategy;

  public ViewWithUiHandlers(final UiHandlersStrategy<H> uiHandlersStrategy) {
    this.uiHandlersStrategy = uiHandlersStrategy;
  }

  @Override
  public H getUiHandlers() {
    return uiHandlersStrategy.getUiHandlers();
  }

  @Override
  public void setUiHandlers(H uiHandlers) {
    uiHandlersStrategy.setUiHandlers(uiHandlers);
  }
}