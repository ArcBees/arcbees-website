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
