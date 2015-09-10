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
