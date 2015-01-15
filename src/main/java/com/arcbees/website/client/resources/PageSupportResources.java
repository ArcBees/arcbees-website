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

import com.arcbees.gsss.animation.client.AnimationResources;

public interface PageSupportResources extends FontResources {
    interface Style extends AnimationResources.Animation {
        String plan();

        String price();

        String featuredIcons();

        String bestbuy();

        String header();

        String features();

        String support();

        String popChoice();

        String hours();

        String developers();

        String advisory();

        String includes();

        String offers();

        String responseTime();

        String purchSupp();

        String products();

        String icon1();

        String icon2();

        String icon4();

        String icon3();
    }

    @Source({"com/arcbees/gsss/animation/client/animationsettings.gss",
            "com/arcbees/gsss/animation/client/animations.gss",
            "com/arcbees/gsss/mixin/client/mixins.gss",
            "css/colors.gss", "fonts/geometria/geometria.gss", "css/pages/support.gss"})
    Style style();
}
