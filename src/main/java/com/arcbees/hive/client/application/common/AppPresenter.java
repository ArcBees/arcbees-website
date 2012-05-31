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

import com.arcbees.hive.client.application.common.event.ResizeEvent;
import com.arcbees.hive.client.application.common.event.ResizeEvent.ResizeHandler;
import com.google.gwt.event.shared.GwtEvent.Type;
import com.google.inject.Inject;
import com.google.web.bindery.event.shared.EventBus;
import com.gwtplatform.mvp.client.Presenter;
import com.gwtplatform.mvp.client.View;
import com.gwtplatform.mvp.client.annotations.ContentSlot;
import com.gwtplatform.mvp.client.annotations.ProxyStandard;
import com.gwtplatform.mvp.client.proxy.Proxy;
import com.gwtplatform.mvp.client.proxy.RevealContentHandler;
import com.gwtplatform.mvp.client.proxy.RevealRootContentEvent;

public class AppPresenter extends
        Presenter<AppPresenter.MyView, AppPresenter.MyProxy> implements ResizeHandler {
    @ProxyStandard
    public interface MyProxy extends Proxy<AppPresenter> {
    }

    public interface MyView extends View {
        void resizeSlot(Object slot, Integer size);
    }

    @ContentSlot
    public static final Type<RevealContentHandler<?>> TYPE_SetMainContent = new Type<RevealContentHandler<?>>();

    public static Object TYPE_setHeader = new Object();
    public static Object TYPE_setCustomers = new Object();
    public static Object TYPE_setFooter = new Object();

    private final HeaderPresenter headerPresenter;
    private final FooterPresenter footerPresenter;
    private final CustomersPresenter customersPresenter;

    private final Integer bottomMargin = 0;

    @Inject
    public AppPresenter(final EventBus eventBus,
                        final MyView view,
                        final MyProxy proxy,
                        final HeaderPresenter headerPresenter,
                        final FooterPresenter footerPresenter,
                        final CustomersPresenter customersPresenter) {
        super(eventBus, view, proxy);

        this.headerPresenter = headerPresenter;
        this.footerPresenter = footerPresenter;
        this.customersPresenter = customersPresenter;
    }

    @Override
    public void onResize(ResizeEvent event) {
        Integer size = event.getSize() + bottomMargin;
        getView().resizeSlot(event.getSlot(), size);
    }


    @Override
    protected void revealInParent() {
        RevealRootContentEvent.fire(this, this);
    }

    @Override
    protected void onBind() {
        super.onBind();

        setInSlot(TYPE_setHeader, headerPresenter);
        setInSlot(TYPE_setCustomers, customersPresenter);
        setInSlot(TYPE_setFooter, footerPresenter);

        addRegisteredHandler(ResizeEvent.getType(), this);
    }
}
