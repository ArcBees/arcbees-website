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

import com.arcbees.gsss.grid.client.GridResources;
import com.google.gwt.resources.client.CssResource;

public interface AppResources extends FontResources {
    interface Normalize extends CssResource {
    }

    interface Style extends CssResource {
        String hidden();

        String clearfix();

        String stripe();

        String light();

        String dark();

        String colored();

        String footer();

        String menu();

        String sidebar();

        String content();

        String backHome();

        String menuContact();

        String socialmedias();

        String wrapper();

        String slogan();

        String main();

        String sloganSide();

        String centered();

        String withLogo();

        String btn();

        String accent();

        String medium1();

        String medium2();

        String medium3();

        String backTop();

        String stripeLast();

        String anchor();

        String stripeTitle();

        String menuToggle();

        String active();

        String menuStart();

        String header();

        String triangleBottom();

        String nextLight();

        String nextDark();

        String nextColored();

        String focusBlock();

        String lonely();

        String collapsible();

        String closer();

        String btns();

        String language();

        String github();

        String twoLineTitle();

        String linkTopRight();

        String visuallyhidden();

        String clicked();

        String homeLogo();

        String breadcrumb();

        String mobileHidden();

        String mobileVisible();

        String productsCarousel();

        String gae();

        String jukito();

        String gwtp();

        String chosen();

        String gquery();

        String products();
    }

    @Source("css/normalize.gss")
    Normalize normalize();

    @Source({"com/arcbees/gsss/mixin/client/mixins.gss", "css/colors.gss", "fonts/geometria/geometria.gss", "css/style.gss"})
    Style style();

    @Source({"com/arcbees/website/client/resources/css/gridSettings.gss", "com/arcbees/gsss/grid/client/grid.gss"})
    GridResources.Grid grid();
}
