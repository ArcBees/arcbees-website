package com.arcbees.seo.widget;

public class Og extends ContainerNode {
    private OgImage image;
    private OgType ogType;

    public void add(OgImage image) {
        this.image = image;
    }

    public void add(OgType ogType) {
        this.ogType = ogType;
    }

    public OgImage getImage() {
        return image;
    }

    public OgType getOgType() {
        return ogType;
    }
}
