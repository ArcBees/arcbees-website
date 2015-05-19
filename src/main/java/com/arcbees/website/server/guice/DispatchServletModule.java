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

package com.arcbees.website.server.guice;

import com.arcbees.appengine.mail.guice.EmailModule;
import com.arcbees.guicyresteasy.GuiceRestEasyFilterDispatcher;
import com.arcbees.website.server.HomeServlet;
import com.arcbees.website.server.LocaleExtractor;
import com.arcbees.website.server.SupportResource;
import com.arcbees.website.shared.EndPoints;
import com.google.inject.servlet.ServletModule;
import com.gwtplatform.crawler.server.CrawlFilter;
import com.gwtplatform.crawler.server.ServiceKey;
import com.gwtplatform.crawler.server.ServiceUrl;

public class DispatchServletModule extends ServletModule {
    @Override
    protected void configureServlets() {
        install(new EmailModule());

        filter("/" + EndPoints.ROOT + "*").through(GuiceRestEasyFilterDispatcher.class);

        bind(SupportResource.class);
        bindConstant().annotatedWith(ServiceKey.class).to("ab12cd34");
        bindConstant().annotatedWith(com.gwtplatform.crawlerservice.server.ServiceKey.class).to("ab12cd34");
        bindConstant().annotatedWith(ServiceUrl.class).to("http://arcbeeswebsite.appspot.com/");

        filter("/*").through(CrawlFilter.class);
        filter("/*").through(CrawlerFilter.class);

        serve("/").with(HomeServlet.class);

        for (String locale : LocaleExtractor.SUPPORTED_LOCALES) {
            serveRegex("/" + locale, "/" + locale + "/").with(HomeServlet.class);
        }
    }
}
