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
