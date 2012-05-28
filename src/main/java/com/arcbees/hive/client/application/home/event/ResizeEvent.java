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

package com.arcbees.hive.client.application.home.event;

import com.google.gwt.event.shared.EventHandler;
import com.google.gwt.event.shared.GwtEvent;
import com.google.gwt.event.shared.HasHandlers;

public class ResizeEvent extends GwtEvent<ResizeEvent.ResizeHandler> {
    public interface ResizeHandler extends EventHandler {
        void onResize(ResizeEvent event);
    }

    private static Type<ResizeHandler> TYPE = new Type<ResizeEvent.ResizeHandler>();

    private final Object slot;
    private final int size;

    public static Type<ResizeHandler> getType() {
        return TYPE;
    }

    public static void fire(HasHandlers source, Object slot, int size) {
        source.fireEvent(new ResizeEvent(slot, size));
    }

    public ResizeEvent(Object slot, int size) {
        this.slot = slot;
        this.size = size;
    }

    @Override
    public Type<ResizeHandler> getAssociatedType() {
        return TYPE;
    }

    public Object getSlot() {
        return slot;
    }

    public int getSize() {
        return size;
    }

    @Override
    protected void dispatch(ResizeHandler handler) {
        handler.onResize(this);
    }
}
