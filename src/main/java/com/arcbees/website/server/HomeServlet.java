/**
 * Copyright 2015 ArcBees Inc.
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

package com.arcbees.website.server;

import java.io.IOException;
import java.net.URL;
import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.VelocityEngine;

import com.google.common.base.Strings;
import com.google.common.io.ByteSource;
import com.google.common.io.Resources;

public class HomeServlet extends HttpServlet {
    private static final String VELOCITY_PROPERTIES = "com/arcbees/website/server/velocity.properties";
    private static final String HOME_TEMPLATE = "com/arcbees/website/server/html/home.vm";
    private static final String DEFAULT_LOCALE = "en";
    private static final Pattern EXTRACT_LOCALE_PATTERN = Pattern.compile("^/(en|fr)(?:/.*)?");

    private VelocityEngine velocityEngine;

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        VelocityContext context = new VelocityContext();
        context.put("locale", extractLocale(request));

        getVelocityEngine().mergeTemplate(HOME_TEMPLATE, "UTF-8", context, response.getWriter());
    }

    private String extractLocale(HttpServletRequest request) {
        String path = Strings.nullToEmpty(request.getRequestURI());
        Matcher matcher = EXTRACT_LOCALE_PATTERN.matcher(path);

        String locale = null;
        if (matcher.find()) {
            locale = matcher.group(1);
        }

        return Strings.isNullOrEmpty(locale) ? DEFAULT_LOCALE : locale;
    }

    private VelocityEngine getVelocityEngine() {
        if (velocityEngine == null) {
            Properties properties = loadVelocityProperties();
            velocityEngine = new VelocityEngine(properties);
        }

        return velocityEngine;
    }

    private Properties loadVelocityProperties() {
        Properties properties = new Properties();

        try {
            URL url = Resources.getResource(VELOCITY_PROPERTIES);
            ByteSource byteSource = Resources.asByteSource(url);

            properties.load(byteSource.openStream());
        } catch (Exception e) {
            throw new RuntimeException("Unable to load velocity properties from '" + VELOCITY_PROPERTIES + "'.", e);
        }

        return properties;
    }
}
