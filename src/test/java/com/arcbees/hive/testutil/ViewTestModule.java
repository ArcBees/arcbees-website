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

package com.arcbees.hive.testutil;

import com.google.gwt.junit.GWTMockUtilities;

import com.gwtplatform.tester.MockFactory;

import org.jukito.JukitoModule;

/**
 * Base module to use while testing views. Your configuration module must
 * extends this class.
 *
 * @author Christian Goudreau
 */
public abstract class ViewTestModule extends JukitoModule {
    @Override
    protected void configureTest() {
        GWTMockUtilities.disarm();

        bind(MockFactory.class).to(MockitoMockFactory.class);

        configureViewTest();
    }

    protected abstract void configureViewTest();
}
