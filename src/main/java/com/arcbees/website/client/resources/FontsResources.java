/*
 * Copyright 2014 ArcBees Inc.
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

package com.arcbees.website.client.resources;

import com.google.gwt.resources.client.ClientBundle;
import com.google.gwt.resources.client.DataResource;
import com.google.gwt.resources.client.GssResource;

import static com.google.gwt.resources.client.DataResource.MimeType;

public interface FontsResources extends ClientBundle {
    String MIME_TYPE_TTF = "application/font-sfnt";
    String MIME_TYPE_EOT = "application/vnd.ms-fontobject";
    String MIME_TYPE_WOFF = "application/font-woff";
    String MIME_TYPE_SVG = "image/svg+xml";

    public interface Icons extends GssResource {
        String iconSignCode();

        String iconArcbees();

        String iconArrowDown();

        String iconArrowOutside();

        String iconHexagon();

        String iconLadder();

        String iconBees();

        String iconChosen();

        String iconClose();

        String iconDevTime();

        String iconFb();

        String iconGae();

        String iconGithub();

        String iconGPlus();

        String iconGwtp();

        String iconInfo();

        String iconJukito();

        String iconLkdIn();

        String iconMapPin();

        String iconMenu();

        String iconQ1a();

        String iconQ1b();

        String iconQ1c();

        String iconQ2a();

        String iconQ2b();

        String iconQ2c();

        String iconQ3a();

        String iconQ3b();

        String iconQ3c();

        String iconQ4a();

        String iconQ4b();

        String iconQ4c();

        String iconSearch();

        String iconShare();

        String iconTwit();

        String iconWordpress();
    }

    interface Normalize extends GssResource {
    }

    interface Style extends GssResource {
    }

    @Source("fonts/icons/icons.gss")
    Icons icons();

    @Source("css/normalize.gss")
    Normalize normalize();

    @Source({"css/colors.gss", "fonts/geometria/geometria.gss", "css/style.gss"})
    Style style();

    @Source("fonts/icons/icons.ttf")
    DataResource iconsTtf();

    @Source("fonts/icons/icons.eot")
    DataResource iconsEot();

    @Source("fonts/icons/icons.svg")
    DataResource iconsSvg();

    @Source("fonts/icons/icons.woff")
    DataResource iconsWoff();

    @MimeType(MIME_TYPE_TTF)
    @Source("fonts/geometria/geometria-webfont.ttf")
    DataResource geometriaTtf();

    @MimeType(MIME_TYPE_EOT)
    @Source("fonts/geometria/geometria-webfont.eot")
    DataResource geometriaEot();

    @MimeType(MIME_TYPE_SVG)
    @Source("fonts/geometria/geometria-webfont.svg")
    DataResource geometriaSvg();

    @MimeType(MIME_TYPE_WOFF)
    @Source("fonts/geometria/geometria-webfont.woff")
    DataResource geometriaWoff();

    @MimeType(MIME_TYPE_TTF)
    @Source("fonts/geometria/geometriabold-webfont.ttf")
    DataResource geometriaBoldTtf();

    @MimeType(MIME_TYPE_EOT)
    @Source("fonts/geometria/geometriabold-webfont.eot")
    DataResource geometriaBoldEot();

    @MimeType(MIME_TYPE_SVG)
    @Source("fonts/geometria/geometriabold-webfont.svg")
    DataResource geometriaBoldSvg();

    @MimeType(MIME_TYPE_WOFF)
    @Source("fonts/geometria/geometriabold-webfont.woff")
    DataResource geometriaBoldWoff();

    @MimeType(MIME_TYPE_TTF)
    @Source("fonts/geometria/geometrialight-webfont.ttf")
    DataResource geometriaLightTtf();

    @MimeType(MIME_TYPE_EOT)
    @Source("fonts/geometria/geometrialight-webfont.eot")
    DataResource geometriaLightEot();

    @MimeType(MIME_TYPE_SVG)
    @Source("fonts/geometria/geometrialight-webfont.svg")
    DataResource geometriaLightSvg();

    @MimeType(MIME_TYPE_WOFF)
    @Source("fonts/geometria/geometrialight-webfont.woff")
    DataResource geometriaLightWoff();

    @MimeType(MIME_TYPE_TTF)
    @Source("fonts/geometria/geometrialightitalic-webfont.ttf")
    DataResource geometriaLightItalicTtf();

    @MimeType(MIME_TYPE_EOT)
    @Source("fonts/geometria/geometrialightitalic-webfont.eot")
    DataResource geometriaLightItalicEot();

    @MimeType(MIME_TYPE_SVG)
    @Source("fonts/geometria/geometrialightitalic-webfont.svg")
    DataResource geometriaLightItalicSvg();

    @MimeType(MIME_TYPE_WOFF)
    @Source("fonts/geometria/geometrialightitalic-webfont.woff")
    DataResource geometriaLightItalicWoff();
}
