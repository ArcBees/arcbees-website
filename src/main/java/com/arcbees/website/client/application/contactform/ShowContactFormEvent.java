/**
 * Copyright 2015 ArcBees Inc.
 * <p/>
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except in compliance with
 * the License. You may obtain a copy of the License at
 * <p/>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p/>
 * Unless required by applicable law or agreed to in writing, software distributed under the License is distributed on
 * an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations under the License.
 */

package com.arcbees.website.client.application.contactform;

import com.google.gwt.event.shared.EventHandler;
import com.google.gwt.event.shared.GwtEvent;
import com.google.gwt.event.shared.HasHandlers;

public class ShowContactFormEvent extends GwtEvent<ShowContactFormEvent.ShowContactFormHandler> {
    public interface ShowContactFormHandler extends EventHandler {
        void onShowContactForm(ShowContactFormEvent event);
    }

    private static final Type<ShowContactFormHandler> TYPE = new Type<>();

    ShowContactFormEvent() {
    }

    public static Type<ShowContactFormHandler> getType() {
        return TYPE;
    }

    public static void fire(HasHandlers source) {
        source.fireEvent(new ShowContactFormEvent());
    }

    @Override
    public Type<ShowContactFormHandler> getAssociatedType() {
        return TYPE;
    }

    @Override
    protected void dispatch(ShowContactFormHandler handler) {
        handler.onShowContactForm(this);
    }
}
