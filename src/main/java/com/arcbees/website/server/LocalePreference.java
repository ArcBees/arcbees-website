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

import java.util.Comparator;

public class LocalePreference {
    public static final Comparator<LocalePreference> COMPARATOR = new Comparator<LocalePreference>() {
        @Override
        public int compare(LocalePreference o1, LocalePreference o2) {
            return (int) (o2.priority * 100 - o1.priority * 100);
        }
    };

    public static final int DEFAULT_PRIORITY = 1;
    private final float priority;
    private final String locale;

    public LocalePreference(String value) {
        String[] values = value.split(";");

        locale = parseLocale(values[0]);

        if (values.length == 2) {
            priority = parsePriority(values[1]);
        } else {
            priority = DEFAULT_PRIORITY;
        }
    }

    public String getLocale() {
        return locale;
    }

    private String parseLocale(String locale) {
        return locale.split("-")[0].trim().toLowerCase();
    }

    private float parsePriority(String value) {
        try {
            return Float.parseFloat(value.replace(" ", "").replace("q=", ""));
        } catch (NumberFormatException e) {
            return 0;
        }
    }
}
