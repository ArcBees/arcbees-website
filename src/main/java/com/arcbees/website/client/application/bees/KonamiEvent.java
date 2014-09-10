package com.arcbees.website.client.application.bees;

import com.google.gwt.event.shared.EventHandler;
import com.google.gwt.event.shared.GwtEvent;
import com.google.gwt.event.shared.HasHandlers;

public class KonamiEvent extends GwtEvent<KonamiEvent.KonamiHandler> {
    public interface KonamiHandler extends EventHandler {
        public void onKonami(KonamiEvent event);
    }

    public static Type<KonamiHandler> getType() {
        return TYPE;
    }

    public static void fire(HasHandlers source) {
        source.fireEvent(new KonamiEvent());
    }

    private static final Type<KonamiHandler> TYPE = new Type<KonamiHandler>();

    @Override
    public Type<KonamiHandler> getAssociatedType() {
        return TYPE;
    }

    KonamiEvent() {
    }

    @Override
    protected void dispatch(KonamiHandler handler) {
        handler.onKonami(this);
    }
}
