/*
 * Copyright 2014 ArcBees Inc.
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

package com.arcbees.hive.server.guice;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.xml.sax.SAXException;

import com.arcbees.hive.server.handlers.HandlersModule;
import com.arcbees.hive.server.home.HomeModule;
import com.google.inject.Provides;
import com.google.inject.name.Named;
import com.gwtplatform.dispatch.rpc.server.guice.HandlerModule;

public class ServerModule extends HandlerModule {
    private final String arcbeesFetch = "http://arcbees.wordpress.com/feed/";

    @Override
    protected void configureHandlers() {
        install(new HomeModule());
        install(new HandlersModule());
    }

    @Provides
    @Named("arcbeesUrlFetch")
    URL getUrl() throws MalformedURLException {
        return new URL(arcbeesFetch);
    }

    @Provides
    @Named("arcbeesFetch")
    Document getDocument(@Named("arcbeesUrlFetch") final URL url) throws IOException, ParserConfigurationException,
            SAXException {
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        DocumentBuilder db = dbf.newDocumentBuilder();

        return db.parse(url.openStream());
    }
}
