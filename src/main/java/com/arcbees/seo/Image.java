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

package com.arcbees.seo;

import com.arcbees.seo.widget.OgImage;

public class Image {
    private final String url;
    private final Integer width;
    private final Integer height;
    private final String mimeType;

    public Image(
            String url,
            Integer height,
            Integer width,
            OgImage.MimeType type) {
        this.url = url;
        this.height = height;
        this.width = width;
        this.mimeType = type == null ? null : type.getValue();
    }

    public String getUrl() {
        return url;
    }

    public Integer getWidth() {
        return width;
    }

    public Integer getHeight() {
        return height;
    }

    public String getMimeType() {
        return mimeType;
    }

    @Override
    public String toString() {
        return "Image{" +
                "url='" + url + '\'' +
                ", width=" + width +
                ", height=" + height +
                ", mimeType='" + mimeType + '\'' +
                '}';
    }
}
