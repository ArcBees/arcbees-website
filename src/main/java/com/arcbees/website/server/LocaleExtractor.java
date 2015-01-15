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

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.common.base.Function;
import com.google.common.base.Joiner;
import com.google.common.base.Predicate;
import com.google.common.base.Strings;
import com.google.common.collect.FluentIterable;
import com.google.common.collect.Lists;
import com.google.common.net.HttpHeaders;

public class LocaleExtractor {
    public static final String LOCALE_COOKIE_NAME = "locale";
    public static final List<String> SUPPORTED_LOCALES = Lists.newArrayList("en", "fr");

    private static final String DEFAULT_LOCALE = "en";
    private static final Pattern EXTRACT_LOCALE_PATTERN;

    static {
        String locales = Joiner.on('|').join(SUPPORTED_LOCALES);
        EXTRACT_LOCALE_PATTERN = Pattern.compile("^/(" + locales + ")(?:/.*)?");
    }

    private final HttpServletRequest request;
    private final HttpServletResponse response;

    public LocaleExtractor(
            HttpServletRequest request,
            HttpServletResponse response) {
        this.request = request;
        this.response = response;
    }

    public String extractLocale() {
        String locale = getLocaleFromPath();

        if (locale == null) {
            locale = getLocaleFromCookie();
        }
        if (locale == null) {
            locale = getLocaleFromHeader();
        }
        if (locale == null) {
            locale = DEFAULT_LOCALE;
        }

        storeLocale(locale);
        return locale;
    }

    private String getLocaleFromPath() {
        String path = Strings.nullToEmpty(request.getRequestURI());
        Matcher matcher = EXTRACT_LOCALE_PATTERN.matcher(path);

        String locale = null;
        if (matcher.find()) {
            locale = matcher.group(1).toLowerCase();
        }

        return locale;
    }

    private String getLocaleFromCookie() {
        Cookie[] cookies = request.getCookies();
        return cookies == null ? null : FluentIterable.of(cookies)
                .firstMatch(new Predicate<Cookie>() {
                    @Override
                    public boolean apply(Cookie cookie) {
                        return LOCALE_COOKIE_NAME.equals(cookie.getName())
                                && SUPPORTED_LOCALES.contains(cookie.getValue());
                    }
                })
                .transform(new Function<Cookie, String>() {
                    @Override
                    public String apply(Cookie cookie) {
                        return cookie.getValue().toLowerCase();
                    }
                })
                .orNull();
    }

    /**
     * Returns the locale from Accept-Language with the higher priority. Disregards country information and not
     * supported locales. ie: <code>Accept-Language: da, en-gb;q=0.8, FR-CA;q=0.7</code> will return "en".
     */
    private String getLocaleFromHeader() {
        String header = request.getHeader(HttpHeaders.ACCEPT_LANGUAGE);

        if (header != null) {
            String[] headerParts = header.split(",");
            List<LocalePreference> localePreferences = FluentIterable.of(headerParts)
                    .transform(new Function<String, LocalePreference>() {
                        @Override
                        public LocalePreference apply(String locale) {
                            return new LocalePreference(locale);
                        }
                    })
                    .filter(new Predicate<LocalePreference>() {
                        @Override
                        public boolean apply(LocalePreference preference) {
                            return SUPPORTED_LOCALES.contains(preference.getLocale());
                        }
                    })
                    .toSortedList(LocalePreference.COMPARATOR);

            return localePreferences.isEmpty() ? null : localePreferences.get(0).getLocale();
        }

        return null;
    }

    private void storeLocale(String locale) {
        Cookie cookie = new Cookie(LocaleExtractor.LOCALE_COOKIE_NAME, locale);
        cookie.setPath("/");

        response.addCookie(cookie);
    }
}
