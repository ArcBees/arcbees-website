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

import com.arcbees.gsss.grid.client.GridResources;
import com.google.gwt.resources.client.GssResource;

public interface AppResources extends FontResources {
    interface Normalize extends GssResource {
    }

    interface Style extends GssResource {
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
    }

    @Source("css/normalize.gss")
    Normalize normalize();

    @Source({"com/arcbees/gsss/mixin/client/mixins.gss", "css/colors.gss", "fonts/geometria/geometria.gss", "css/style.gss"})
    Style style();

    @Source({"com/arcbees/website/client/resources/css/gridSettings.gss", "com/arcbees/gsss/grid/client/grid.gss"})
    GridResources.Grid grid();
}
