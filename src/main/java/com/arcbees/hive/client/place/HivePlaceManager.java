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

package com.arcbees.hive.client.place;

import com.arcbees.hive.client.gin.DefaultPlace;

import com.google.gwt.event.shared.EventBus;
import com.google.gwt.user.client.History;
import com.google.inject.Inject;

import com.gwtplatform.mvp.client.proxy.PlaceManagerImpl;
import com.gwtplatform.mvp.client.proxy.PlaceRequest;
import com.gwtplatform.mvp.client.proxy.TokenFormatter;

/**
 * @author Christian Goudreau
 */
public class HivePlaceManager extends PlaceManagerImpl {
  private final PlaceRequest defaultPlaceRequest;

  @Inject
  public HivePlaceManager(EventBus eventBus, TokenFormatter tokenFormatter,
      @DefaultPlace String defaultPlaceNameToken) {
    super(eventBus, tokenFormatter);

    this.defaultPlaceRequest = new PlaceRequest(defaultPlaceNameToken);
  }

  @Override
  public void revealDefaultPlace() {
    if (History.getToken().isEmpty()) {
      revealPlace(defaultPlaceRequest, false);
    } else {
      revealPlace(defaultPlaceRequest);
    }
  }

  @Override
  public void revealErrorPlace(String invalidHistoryToken) {
  }

  @Override
  public void revealUnauthorizedPlace(String unauthorizedHistoryToken) {
  }
}
