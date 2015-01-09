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

public class SeoElements {
    public static class Builder {
        private String title;
        private String description;
        private String keywords;
        private String fbAppId;
        private OpenGraph openGraph;

        public Builder() {
        }

        public Builder withTitle(String title) {
            this.title = title;
            return this;
        }

        public Builder withDescription(String description) {
            this.description = description;
            return this;
        }

        public Builder withKeywords(String keywords) {
            this.keywords = keywords;
            return this;
        }

        public Builder withFbAppId(String fbAppId) {
            this.fbAppId = fbAppId;
            return this;
        }

        public Builder withOpenGraph(OpenGraph openGraph) {
            this.openGraph = openGraph;
            return this;
        }

        public SeoElements build() {
            SeoElements seoElements = new SeoElements();

            seoElements.setTitle(title);
            seoElements.setDescription(description);
            seoElements.setKeywords(keywords);
            seoElements.setFbAppId(fbAppId);
            seoElements.setOpenGraph(openGraph);

            return seoElements;
        }
    }

    private String title;
    private String description;
    private String keywords;
    private String fbAppId;
    private OpenGraph openGraph;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getKeywords() {
        return keywords;
    }

    public void setKeywords(String keywords) {
        this.keywords = keywords;
    }

    public String getFbAppId() {
        return fbAppId;
    }

    public void setFbAppId(String fbAppId) {
        this.fbAppId = fbAppId;
    }

    public OpenGraph getOpenGraph() {
        return openGraph;
    }

    public void setOpenGraph(OpenGraph openGraph) {
        this.openGraph = openGraph;
    }

    @Override
    public String toString() {
        return "SeoElements{" +
                "title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", keywords='" + keywords + '\'' +
                ", fbAppId='" + fbAppId + '\'' +
                ", openGraph=" + openGraph +
                '}';
    }
}
