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

import java.util.HashMap;
import java.util.Map;

import com.arcbees.seo.Image;
import com.arcbees.seo.OpenGraph;
import com.arcbees.seo.SeoElements;
import com.google.gwt.dom.client.Document;
import com.google.gwt.dom.client.Element;
import com.google.gwt.dom.client.HeadElement;
import com.google.gwt.dom.client.MetaElement;
import com.google.gwt.dom.client.NodeList;
import com.google.gwt.dom.client.Style;
import com.google.gwt.event.logical.shared.AttachEvent;
import com.google.gwt.user.client.ui.SimplePanel;
import com.google.gwt.user.client.ui.Widget;

public class SeoWidget extends ContainerNode implements AttachEvent.Handler {
    private final Widget widget;
    private final SeoElements.Builder seoBuilder;

    public SeoWidget() {
        widget = new SimplePanel();
        widget.getElement().getStyle().setDisplay(Style.Display.NONE);
        widget.addAttachHandler(this);

        seoBuilder = new SeoElements.Builder();
    }

    public void add(Title title) {
        seoBuilder.withTitle(title.getText());
    }

    public void add(Og og) {
        OpenGraph.Builder builder = new OpenGraph.Builder();

        OgImage image = og.getImage();
        if (image != null) {
            builder.withImage(new Image(image.getText(), image.getHeight(), image.getWidth(), image.getMimeType()));
        }

        OgType ogType = og.getOgType();
        if (ogType != null) {
            builder.withType(ogType.getValue());
        }

        seoBuilder.withOpenGraph(builder.build());
    }

    public void add(Description description) {
        seoBuilder.withDescription(description.getText());
    }

    public void add(Keywords keywords) {
        seoBuilder.withKeywords(keywords.getText());
    }

    public void add(FbAppId fbAppId) {
        seoBuilder.withFbAppId(fbAppId.getText());
    }

    @Override
    public void onAttachOrDetach(AttachEvent event) {
        if (event.isAttached()) {
            inject(seoBuilder.build());
        }
    }

    @Override
    public Widget asWidget() {
        return widget;
    }

    private void inject(SeoElements seoElements) {
        if (!isNullOrEmpty(seoElements.getTitle())) {
            Document.get().setTitle(seoElements.getTitle());
        }

        setMetaTags(seoElements);
    }

    private void setMetaTags(SeoElements seoElements) {
        Map<String, MetaElement> metaElementsMap = getMetaTags();

        setMetaTag(metaElementsMap, "description", seoElements.getDescription());
        setMetaTag(metaElementsMap, "keywords", seoElements.getKeywords());
        setMetaTag(metaElementsMap, "fb:app_id", seoElements.getFbAppId());

        OpenGraph openGraph = seoElements.getOpenGraph();
        if (openGraph == null) {
            openGraph = new OpenGraph.Builder()
                    .withType(OgType.TypeValue.WEBSITE.getValue())
                    .build();
        }

        setMetaTag(metaElementsMap, "og:title", seoElements.getTitle());
        setMetaTag(metaElementsMap, "og:description", seoElements.getDescription());
        setMetaTag(metaElementsMap, "og:type", openGraph.getType());

        Image image = openGraph.getImage();
        if (image != null) {
            setMetaTag(metaElementsMap, "og:image", image.getUrl());
            setMetaTag(metaElementsMap, "og:image:type", image.getMimeType());
            setMetaTag(metaElementsMap, "og:image:height", toString(image.getHeight()));
            setMetaTag(metaElementsMap, "og:image:width", toString(image.getWidth()));
        }
    }

    private void setMetaTag(
            Map<String, MetaElement> metaElementsMap,
            String property,
            String content) {
        if (content != null) {
            MetaElement metaElement = metaElementsMap.get(property);

            if (metaElement == null) {
                Document document = Document.get();

                metaElement = document.createMetaElement();
                metaElement.setAttribute("property", property);

                document.getHead().insertFirst(metaElement);
            }

            metaElement.setContent(content);
        }
    }

    private Map<String, MetaElement> getMetaTags() {
        HeadElement head = Document.get().getHead();
        NodeList<Element> metaElements = head.getElementsByTagName("meta");

        Map<String, MetaElement> metaElementsMap = new HashMap<>();
        for (int i = 0; i < metaElements.getLength(); i++) {
            MetaElement metaElement = (MetaElement) metaElements.getItem(i);

            String name = getPropertyOrName(metaElement);

            metaElementsMap.put(name, metaElement);
        }

        return metaElementsMap;
    }

    private String getPropertyOrName(MetaElement metaElement) {
        String name = metaElement.getName();
        if (isNullOrEmpty(name)) {
            name = metaElement.getAttribute("property");
        }
        return name;
    }

    private static boolean isNullOrEmpty(String value) {
        return value == null || value.isEmpty();
    }

    private String toString(Integer value) {
        return value == null ? null : value.toString();
    }
}
