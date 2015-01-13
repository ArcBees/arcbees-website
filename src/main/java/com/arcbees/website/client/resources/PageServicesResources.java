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
import com.google.gwt.resources.client.ImageResource;

public interface PageServicesResources extends FontResources {
    interface Style extends AnimationResources.Animation {
        String services();

        String trusted();

        String last();

        String lastMobile();

        String iconPyramid();

        String pyramidAnim1();

        String pyramidAnim2();

        String pyramidAnim6();

        String pyramidAnim5();

        String pyramidAnim4();

        String pyramidAnim3();

        String header();

        String lightbulb();

        String light();

        String bar1();

        String bar2();

        String bar3();

        String bar4();

        String bar5();

        String partner();

        String diagram();

        String icon1();

        String icon2();

        String icon3();

        String icon4();

        String icon5();

        String iconDark();

        String iterative();

        String launch();

        String iteration1();

        String circleQuarter();

        String circle();

        String costRisk();

        String icon6();

        String bar6();

        String bar7();

        String learnAdapt();

        String iconHexa();

        String deliver();

        String beeWay();

        String howWeWork();

        String codeReview();

        String gear1();

        String gear2();

        String gear3();

        String bracket1();

        String bracket2();

        String hexaMove();

        String knowledge();

        String dot();

        String dots();

        String beauty();

        String worksEverywhere();

        String advantages();

        String workBest();

        String topIcons();

        String wayOfTheBee();
    }

    @Source("img/pages/servicesBanner.png")
    ImageResource workBanner();

    @Source("img/pages/servicesGwt.png")
    ImageResource workGwt();

    @Source("img/pages/servicesKaam.png")
    ImageResource workKaam();

    @Source("img/pages/servicesLille.png")
    ImageResource workLille();

    @Source("img/pages/servicesRoller.png")
    ImageResource workRoller();

    @Source("img/pages/trackR.png")
    ImageResource trackR();

    @Source("img/pages/bookedIn.png")
    ImageResource bookedIn();

    @Source("img/pages/protorisk.png")
    ImageResource protorisk();

    @Source("img/pages/kaam.png")
    ImageResource kaam();

    @Source("img/pages/swiftIq.png")
    ImageResource swiftIQ();

    @Source("img/pages/easyData.png")
    ImageResource easyData();

    @Source("img/pages/servicesLightBulb.png")
    ImageResource servicesLightBulb();

    @Source({"com/arcbees/gsss/animation/client/animationsettings.gss",
            "com/arcbees/gsss/animation/client/animations.gss",
            "com/arcbees/gsss/mixin/client/mixins.gss",
            "css/colors.gss", "fonts/geometria/geometria.gss", "css/pages/services.gss"})
    Style style();
}
