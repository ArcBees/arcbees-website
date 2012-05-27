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

import com.google.gwt.event.shared.EventBus;
import com.google.gwt.event.shared.GwtEvent;
import com.google.gwt.event.shared.HasHandlers;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.inject.Inject;

/**
 * @param <T> Type du callback
 * 
 * @author Christian Goudreau
 */
public abstract class AsyncCallbackImpl<T> implements AsyncCallback<T>, HasHandlers {
  @Inject
  protected static EventBus eventBus;

  public void onFailure(Throwable e) {
  }

  @Override
  public abstract void onSuccess(T result);

    @Override
    public void fireEvent(GwtEvent<?> event) {
      eventBus.fireEvent(event);
    }
}