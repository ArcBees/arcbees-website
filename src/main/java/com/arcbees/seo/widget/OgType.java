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

package com.arcbees.seo.widget;

import com.google.gwt.uibinder.client.UiConstructor;

public class OgType extends BaseNode {
    public enum TypeValue {
        WEBSITE("website"),
        SONG("music.song"),
        ALBUM("music.album"),
        PLAYLIST("music.playlist"),
        RADIO_STATION("music.radio_station"),
        MOVIE("video.movie"),
        EPISODE("video.episode"),
        TV_SHOW("video.tv_show"),
        VIDEO_OTHER("video.other"),
        ARTICLE("article"),
        BOOK("book"),
        PROFILE("profile");

        private final String value;

        TypeValue(String value) {
            this.value = value;
        }

        public String getValue() {
            return value;
        }
    }

    private final TypeValue typeValue;

    @UiConstructor
    public OgType(TypeValue typeValue) {
        this.typeValue = typeValue;
    }

    public String getValue() {
        return typeValue.getValue();
    }
}
