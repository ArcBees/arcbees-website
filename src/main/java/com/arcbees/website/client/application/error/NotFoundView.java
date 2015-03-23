/**
 * Copyright 2015 ArcBees Inc.
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

package com.arcbees.website.client.application.error;

import com.google.gwt.event.logical.shared.ResizeEvent;
import com.google.gwt.event.logical.shared.ResizeHandler;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.query.client.GQuery;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.user.client.ui.Widget;
import com.google.inject.Inject;
import com.gwtplatform.mvp.client.ViewImpl;

import static com.google.gwt.query.client.GQuery.$;

public class NotFoundView extends ViewImpl implements NotFoundPresenter.MyView, ResizeHandler {
    interface Binder extends UiBinder<Widget, NotFoundView> {
    }

    @UiField
    HTMLPanel error;

    private HandlerRegistration resizeHandler;

    @Inject
    NotFoundView(
            Binder binder) {
        initWidget(binder.createAndBindUi(this));
    }

    @Override
    protected void onAttach() {
        resizeHandler = Window.addResizeHandler(this);
        updateHeight();
    }

    @Override
    protected void onDetach() {
        resizeHandler.removeHandler();
        resizeHandler = null;
    }

    @Override
    public void onResize(ResizeEvent event) {
        updateHeight();
    }

    private GQuery updateHeight() {
        return $(error).height(Window.getClientHeight() - 113);
    }
}