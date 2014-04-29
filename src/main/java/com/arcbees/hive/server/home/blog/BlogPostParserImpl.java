/*
 * Copyright 2010 ArcBees Inc.
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

package com.arcbees.hive.server.home.blog;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import javax.inject.Inject;

import org.w3c.dom.DOMException;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import com.arcbees.hive.shared.home.blog.BlogItem;
import com.google.inject.Provider;
import com.google.inject.name.Named;

public class BlogPostParserImpl implements BlogPostParser {
    private final Provider<Document> documentProvider;

    private final DateFormat dateFormat = new SimpleDateFormat(
            "EEE, d MMM yyyy HH:mm:ss Z", Locale.CANADA);
    private final String item = "item";
    private final String title = "title";
    private final String creator = "dc:creator";
    private final String link = "link";
    private final String pubDate = "pubDate";
    private final String content = "description";

    @Inject
    public BlogPostParserImpl(
            @Named("arcbeesFetch") final Provider<Document> documentProvider) {
        this.documentProvider = documentProvider;
    }

    @Override
    public List<BlogItem> parse() {
        Document document = documentProvider.get();

        List<BlogItem> items = new ArrayList<>();

        NodeList nodeListItems = document.getElementsByTagName(item);

        for (int i = 0; i < nodeListItems.getLength() && i < 10; i++) {
            BlogItem blogItem = new BlogItem();
            Node nodeItem = nodeListItems.item(i);

            NodeList nodeListItemAttributes = nodeItem.getChildNodes();

            for (int j = 0; j < nodeListItemAttributes.getLength(); j++) {
                Node node = nodeListItemAttributes.item(j);

                if (node.getNodeName().equals(title)) {
                    blogItem.setTitle(node.getFirstChild().getNodeValue());
                }

                if (node.getNodeName().equals(link)) {
                    blogItem.setLink(node.getFirstChild().getNodeValue());
                }

                if (node.getNodeName().equals(creator)) {
                    blogItem.setCreator(node.getFirstChild().getNodeValue());
                }

                if (node.getNodeName().equals(content)) {
                    blogItem.setDescription(node.getFirstChild().getNodeValue());
                }

                if (node.getNodeName().equals(pubDate)) {
                    try {
                        blogItem.setPubDate(dateFormat.parse(node.getFirstChild().getNodeValue()));
                    } catch (DOMException e) {
                        e.printStackTrace();
                    } catch (ParseException e) {
                        e.printStackTrace();
                    }
                }
            }

            items.add(blogItem);
        }

        return items;
    }
}
