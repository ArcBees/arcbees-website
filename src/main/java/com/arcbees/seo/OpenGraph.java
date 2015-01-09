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
