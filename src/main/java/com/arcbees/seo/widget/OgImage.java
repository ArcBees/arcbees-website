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

public class OgImage extends TextNode {
    public enum MimeType {
        GIF("image/gif"),
        JPEG("image/jpeg"),
        PJPEG("image/pjpeg"),
        PNG("image/png"),
        SVG("image/svg+xml"),
        TIFF("image/tiff"),
        DJVU("image/vnd.djvu");

        private final String value;

        MimeType(String value) {
            this.value = value;
        }

        public String getValue() {
            return value;
        }
    }

    private Integer height;
    private Integer width;
    private MimeType mimeType;

    public Integer getHeight() {
        return height;
    }

    public void setHeight(Integer height) {
        this.height = height;
    }

    public Integer getWidth() {
        return width;
    }

    public void setWidth(Integer width) {
        this.width = width;
    }

    public MimeType getMimeType() {
        return mimeType;
    }

    public void setMimeType(MimeType mimeType) {
        this.mimeType = mimeType;
    }
}
