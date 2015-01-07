package com.arcbees.seo;

import com.arcbees.seo.widget.OgImage;

public class Image {
    private final String url;
    private final Integer width;
    private final Integer height;
    private final String mimeType;

    public Image(String url, Integer height, Integer width, OgImage.MimeType type) {
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
