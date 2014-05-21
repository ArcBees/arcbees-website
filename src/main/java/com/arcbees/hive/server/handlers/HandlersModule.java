package com.arcbees.hive.server.handlers;

import com.arcbees.hive.shared.dispatch.SendMail;
import com.gwtplatform.dispatch.rpc.server.guice.HandlerModule;

public class HandlersModule extends HandlerModule {
    @Override
    protected void configureHandlers() {
        bindHandler(SendMail.class, SendMailHandler.class);
    }
}
