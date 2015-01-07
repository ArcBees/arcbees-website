package com.arcbees.seo;

public class OpenGraph {
    public static class Builder {
        private String type;
        private Image image;

        public Builder withType(String type) {
            this.type = type;
            return this;
        }

        public Builder withImage(Image image) {
            this.image = image;
            return this;
        }

        public OpenGraph build() {
            OpenGraph openGraph = new OpenGraph();

            openGraph.setType(type);
            openGraph.setImage(image);

            return openGraph;
        }
    }

    private String type;
    private Image image;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
    }

    @Override
    public String toString() {
        return "OpenGraph{" +
                "type='" + type + '\'' +
                ", image=" + image +
                '}';
    }
}
