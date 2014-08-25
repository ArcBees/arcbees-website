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

public interface FontsResources extends ClientBundle {
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

    @Source("fonts/icons/icons.ttf")
    DataResource iconsTtf();

    @Source("fonts/icons/icons.eot")
    DataResource iconsEot();

    @Source("fonts/icons/icons.svg")
    DataResource iconsSvg();

    @Source("fonts/icons/icons.woff")
    DataResource iconsWoff();

    @Source("fonts/icons/icons.gss")
    Icons icons();

    String MIME_TYPE_TTF = "application/font-sfnt";
    String MIME_TYPE_EOT = "application/vnd.ms-fontobject";
    String MIME_TYPE_WOFF = "application/font-woff";
    String MIME_TYPE_SVG = "image/svg+xml";

    @DataResource.MimeType(MIME_TYPE_TTF)
    @Source("geometria/geometria.ttf")
    DataResource geometriaTtf();

    @DataResource.MimeType(MIME_TYPE_EOT)
    @Source("geometria/geometria.eot")
    DataResource geometriaEot();

    @DataResource.MimeType(MIME_TYPE_SVG)
    @Source("geometria/geometria.svg")
    DataResource geometriaSvg();

    @DataResource.MimeType(MIME_TYPE_WOFF)
    @Source("geometria/geometria_bold.woff")
    DataResource geometriaWBoldoff();

    @DataResource.MimeType(MIME_TYPE_TTF)
    @Source("geometria/geometria_bold.ttf")
    DataResource geometriaBoldTtf();

    @DataResource.MimeType(MIME_TYPE_EOT)
    @Source("geometria/geometria_bold.eot")
    DataResource geometriaBoldEot();

    @DataResource.MimeType(MIME_TYPE_SVG)
    @Source("geometria/geometria_bold.svg")
    DataResource geometriaBoldSvg();

    @DataResource.MimeType(MIME_TYPE_WOFF)
    @Source("geometria/geometria_bold.woff")
    DataResource geometriaWBoldWoff();

    @DataResource.MimeType(MIME_TYPE_TTF)
    @Source("geometria/geometria_light.ttf")
    DataResource geometriLightaTtf();

    @DataResource.MimeType(MIME_TYPE_EOT)
    @Source("geometria/geometria_light.eot")
    DataResource geometriLightaEot();

    @DataResource.MimeType(MIME_TYPE_SVG)
    @Source("geometria/geometria_light.svg")
    DataResource geometriLightaSvg();

    @DataResource.MimeType(MIME_TYPE_WOFF)
    @Source("geometria/geometria_light.woff")
    DataResource geometriaLightWoff();

    @DataResource.MimeType(MIME_TYPE_TTF)
    @Source("geometria/geometria_light_italic.ttf")
    DataResource geometriaLightItalicTtf();

    @DataResource.MimeType(MIME_TYPE_EOT)
    @Source("geometria/geometria_light_italic.eot")
    DataResource geometriaLightItalicEot();

    @DataResource.MimeType(MIME_TYPE_SVG)
    @Source("geometria/geometria_light_italic.svg")
    DataResource geometriaLightItalicSvg();

    @DataResource.MimeType(MIME_TYPE_WOFF)
    @Source("geometria/geometria_light_italic.woff")
    DataResource geometriaWLightItalicWoff();
}
