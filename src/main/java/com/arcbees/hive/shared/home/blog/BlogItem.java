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

package com.arcbees.hive.shared.home.blog;

import java.io.Serializable;
import java.util.Date;

/**
 * DTO meant to encapsulate blog posts retrieved for ArcBees's blog by reading
 * the RSS.
 *
 * @author Christian Goudreau
 */
public class BlogItem implements Serializable {
    private static final long serialVersionUID = -352198600153858944L;

    private String title;
    private Date pubDate;
    private String creator;
    private String link;
    private String description;

    public BlogItem() {
    }

    public String getTitle() {
        return title;
    }

    public Date getPubDate() {
        return pubDate;
    }

    public String getCreator() {
        return creator;
    }

    public String getLink() {
        return link;
    }

    public String getDescription() {
        return description;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setPubDate(Date pubDate) {
        this.pubDate = pubDate;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
