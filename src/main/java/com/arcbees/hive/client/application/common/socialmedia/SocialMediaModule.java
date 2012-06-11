package com.arcbees.hive.client.application.common.socialmedia;

import com.google.gwt.inject.client.AbstractGinModule;
import com.google.gwt.inject.client.assistedinject.GinFactoryModuleBuilder;

public class SocialMediaModule extends AbstractGinModule {
    @Override
    protected void configure() {
        install(new GinFactoryModuleBuilder().build(SocialMediaWidgetFactory.class));
    }
}
