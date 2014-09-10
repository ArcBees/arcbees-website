package com.arcbees.website.client;

import com.google.gwt.event.shared.EventHandler;
import com.google.gwt.event.shared.GwtEvent;
import com.google.gwt.event.shared.HasHandlers;

public class GwtMapsLoadedEvent extends GwtEvent<GwtMapsLoadedEvent.GwtMapsLoadedHandler> {
    public interface GwtMapsLoadedHandler extends EventHandler {
        void onGwtMaps(GwtMapsLoadedEvent event);
    }

    public static final Type<GwtMapsLoadedHandler> TYPE = new Type<>();

    public static void fire(HasHandlers source) {
        source.fireEvent(new GwtMapsLoadedEvent());
    }

    private GwtMapsLoadedEvent() {
    }

    @Override
    public Type<GwtMapsLoadedHandler> getAssociatedType() {
        return TYPE;
    }

    @Override
    protected void dispatch(GwtMapsLoadedHandler handler) {
        handler.onGwtMaps(this);
    }
}
