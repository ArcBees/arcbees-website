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

package com.arcbees.website.client.resources;

import com.google.gwt.resources.client.ClientBundle;
import com.google.gwt.resources.client.CssResource;
import com.google.gwt.resources.client.DataResource;

public interface FontResources extends ClientBundle {
    String MIME_TYPE_TTF = "application/font-sfnt";
    String MIME_TYPE_EOT = "application/vnd.ms-fontobject";
    String MIME_TYPE_WOFF = "application/font-woff";
    String MIME_TYPE_SVG = "image/svg+xml";

    public interface Icons extends CssResource {
        String iconArcbees();

        String iconGae();

        String iconJukito();

        String iconGwtp();

        String iconFb();

        String iconGPlus();

        String iconWordpress();

        String iconLkd();

        String iconGitHub();

        String iconTwitter();

        String iconArcbeesName();

        String iconArrowDown();

        String valignSup();

        String iconChosen();

        String iconhexagon();

        String iconClose();

        String iconEmail();

        String iconChat();

        String iconPhone();

        String iconhexaEmpty();

        String iconSignCode();

        String iconDevTime();

        String iconUser();

        String iconHive();

        String iconPyramid();

        String iconGearing();

        String iconHtml5();

        String iconGCloudPlatform();

        String iconGwt();

        String iconSupportCases();

        String iconRespTime();

        String iconCommRes();

        String iconPhoneSupport();

        String iconInternetSupport();

        String iconArrowOutside();

        String iconGquery();

        String iconGwtOld();
    }

    @ClientBundle.Source("fonts/icons/icons.gss")
    Icons icons();

    @ClientBundle.Source("fonts/icons/icons.ttf")
    DataResource iconsTtf();

    @ClientBundle.Source("fonts/icons/icons.eot")
    DataResource iconsEot();

    @ClientBundle.Source("fonts/icons/icons.svg")
    DataResource iconsSvg();

    @ClientBundle.Source("fonts/icons/icons.woff")
    DataResource iconsWoff();

    @DataResource.MimeType(MIME_TYPE_TTF)
    @ClientBundle.Source("fonts/geometria/geometria-webfont.ttf")
    DataResource geometriaTtf();

    @DataResource.MimeType(MIME_TYPE_EOT)
    @ClientBundle.Source("fonts/geometria/geometria-webfont.eot")
    DataResource geometriaEot();

    @DataResource.MimeType(MIME_TYPE_SVG)
    @ClientBundle.Source("fonts/geometria/geometria-webfont.svg")
    DataResource geometriaSvg();

    @DataResource.MimeType(MIME_TYPE_WOFF)
    @ClientBundle.Source("fonts/geometria/geometria-webfont.woff")
    DataResource geometriaWoff();

    @DataResource.MimeType(MIME_TYPE_TTF)
    @ClientBundle.Source("fonts/geometria/geometriabold-webfont.ttf")
    DataResource geometriaBoldTtf();

    @DataResource.MimeType(MIME_TYPE_EOT)
    @ClientBundle.Source("fonts/geometria/geometriabold-webfont.eot")
    DataResource geometriaBoldEot();

    @DataResource.MimeType(MIME_TYPE_SVG)
    @ClientBundle.Source("fonts/geometria/geometriabold-webfont.svg")
    DataResource geometriaBoldSvg();

    @DataResource.MimeType(MIME_TYPE_WOFF)
    @ClientBundle.Source("fonts/geometria/geometriabold-webfont.woff")
    DataResource geometriaBoldWoff();

    @DataResource.MimeType(MIME_TYPE_TTF)
    @ClientBundle.Source("fonts/geometria/geometrialight-webfont.ttf")
    DataResource geometriaLightTtf();

    @DataResource.MimeType(MIME_TYPE_EOT)
    @ClientBundle.Source("fonts/geometria/geometrialight-webfont.eot")
    DataResource geometriaLightEot();

    @DataResource.MimeType(MIME_TYPE_SVG)
    @ClientBundle.Source("fonts/geometria/geometrialight-webfont.svg")
    DataResource geometriaLightSvg();

    @DataResource.MimeType(MIME_TYPE_WOFF)
    @ClientBundle.Source("fonts/geometria/geometrialight-webfont.woff")
    DataResource geometriaLightWoff();

    @DataResource.MimeType(MIME_TYPE_TTF)
    @ClientBundle.Source("fonts/geometria/geometrialightitalic-webfont.ttf")
    DataResource geometriaLightItalicTtf();

    @DataResource.MimeType(MIME_TYPE_EOT)
    @ClientBundle.Source("fonts/geometria/geometrialightitalic-webfont.eot")
    DataResource geometriaLightItalicEot();

    @DataResource.MimeType(MIME_TYPE_SVG)
    @ClientBundle.Source("fonts/geometria/geometrialightitalic-webfont.svg")
    DataResource geometriaLightItalicSvg();

    @DataResource.MimeType(MIME_TYPE_WOFF)
    @ClientBundle.Source("fonts/geometria/geometrialightitalic-webfont.woff")
    DataResource geometriaLightItalicWoff();
}
