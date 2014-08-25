package com.arcbees.website.client.resources;

import com.google.gwt.resources.client.ClientBundle;
import com.google.gwt.resources.client.DataResource;
import com.google.gwt.resources.client.GssResource;

public interface FontResources extends ClientBundle {
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
