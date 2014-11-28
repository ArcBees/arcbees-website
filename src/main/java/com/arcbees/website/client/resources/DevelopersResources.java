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

import com.google.gwt.resources.client.CssResource;
import com.google.gwt.resources.client.ImageResource;

public interface DevelopersResources extends FontResources {
    interface Style extends CssResource {
        String jukito();

        String breadcrumb();

        String logo();

        String presentation();

        String socialTop();

        String social();

        String frameworkList();

        String slideshow();

        String slides();

        String prev();

        String next();

        String pager();

        String stripeDetails();

        String code();

        String colored();

        String header();

        String gwtp();

        String moreFeatures();

        String chosen();

        String moreSupport();

        String productSupport();

        String reason();

        String docsLink();

        String developers();

        String simplifyCode();
    }

    @Source("img/developers/devsBanner.png")
    ImageResource devsBanner();

    @Source("img/developers/jukitoGuice.png")
    ImageResource jukitoGuice();

    @Source("img/developers/jukitoJUnit.png")
    ImageResource jukitoJUnit();

    @Source("img/developers/jukitoMockito.png")
    ImageResource jukitoMockito();

    @Source("img/developers/gwtpScreen1.png")
    ImageResource gwtpScreen1();

    @Source("img/developers/gaeScreen2.png")
    ImageResource gaeScreen2();

    @Source("img/developers/jukitoBanner.png")
    ImageResource jukitoBanner();

    @Source("img/developers/gwtpBanner.png")
    ImageResource gwtpBanner();

    @Source("img/developers/chosenBanner.png")
    ImageResource chosenBanner();

    @Source("img/developers/chosenRelease.jpg")
    ImageResource chosenRelease();

    @Source("img/developers/chosenSnapshot.jpg")
    ImageResource chosenSnapshot();

    @Source({"com/arcbees/gsss/mixin/client/mixins.gss", "css/colors.gss", "fonts/geometria/geometria.gss", "css" +
            "/developers.gss"})
    Style style();
}
