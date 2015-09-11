/*
 * Copyright 2015 ArcBees Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except in compliance with
 * the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License is distributed on
 * an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations under the License.
 */

package com.arcbees.website.server.guice;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

import com.gwtplatform.crawler.server.ServiceKey;

public class CrawlerRequest extends HttpServletRequestWrapper {
    @Inject
    @ServiceKey
    private static String serviceKey;

    public CrawlerRequest(HttpServletRequest request) {
        super(request);
    }

    @Override
    public String getParameter(String name) {
        if ("url".equals(name.toLowerCase())) {
            int port = getRequest().getServerPort();
            return getScheme() + "://" + getHeader("Host") + (port == 0 ? "" : ":" + port + "/#!"
                    + getParameter(CrawlerFilter.ESCAPED_FRAGMENT));
        } else if ("key".equals(name.toLowerCase())) {
            return serviceKey;
        }

        return super.getParameter(name);
    }
}
