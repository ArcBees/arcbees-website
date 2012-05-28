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

package com.arcbees.hive.client.application.service;

import com.arcbees.core.client.mvp.ViewImpl;
import com.arcbees.hive.client.application.service.ServicePresenter.MyView;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.user.client.ui.Widget;
import com.google.inject.Inject;

/**
 * @author Zachary Keatts
 */
public class ServiceView extends ViewImpl implements MyView {

  /**
   * This will provide a way to automatically create and inject the
   * {@link com.gwtplatform.mvp.client.View} instead of using directly
   * <code>gwt.create()</code>. You only have to inject it in the ctor.
   */
  public interface Binder extends UiBinder<Widget, ServiceView> {
  }

  @Inject
  public ServiceView(final Binder uiBinder) {
    initWidget(uiBinder.createAndBindUi(this));
  }
}
