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

import com.google.gwt.resources.client.CssResource;
import com.google.gwt.resources.client.ImageResource;

public interface PageProductResources extends FontResources {
    interface Style extends CssResource {
        String social();

        String menuHeader();

        String active();

        String products();

        String socialTop();

        String anchor();

        String stripeDetails();

        String pager();

        String next();

        String slideshow();

        String prev();

        String colored();

        String gwtp();

        String presentation();

        String jukito();

        String gae();

        String frameworkList();

        String slides();

        String stripeSupport();

        String code();

        String breadcrumb();

        String logo();

        String moreFeatures();

        String productHead();

        String arrow();

        String header();

        String container();

        String moreOn();

        String chosen();

        String gquery();

        String btns();

        String languageLogo();

        String collapsible();

        String chosenHolder();
    }

    @Source("img/products/jukitoGuice.png")
    ImageResource jukitoGuice();

    @Source("img/products/jukitoJUnit.png")
    ImageResource jukitoJUnit();

    @Source("img/products/jukitoMockito.png")
    ImageResource jukitoMockito();

    @Source("img/products/gwtpScreen1.png")
    ImageResource gwtpScreen1();

    @Source("img/products/gaeBatchEdit.png")
    ImageResource gaeScreen1();

    @Source("img/products/gaeEdit.png")
    ImageResource gaeScreen2();

    @Source("img/products/gaeGql.png")
    ImageResource gaeScreen3();

    @Source("img/products/gaeMain.png")
    ImageResource gaeScreen4();

    @Source("img/products/gaeProfiler.png")
    ImageResource gaeScreen5();

    @Source("img/products/gqueryJquery.jpg")
    ImageResource jqueryScreen();

    @Source("img/products/gqueryGquery.jpg")
    ImageResource gqueryScreen();

    @Source("img/products/javaLogo.png")
    ImageResource javaLogo();

    @Source("img/products/goLogo.png")
    ImageResource goLogo();

    @Source("img/products/phpLogo.png")
    ImageResource phpLogo();

    @Source("img/products/pythonLogo.png")
    ImageResource pythonLogo();

    @Source({"com/arcbees/gsss/mixin/client/mixins.gss", "css/colors.gss", "fonts/geometria/geometria.gss", "css/pages/products.gss"})
    Style style();
}
