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

import com.google.gwt.resources.client.GssResource;
import com.google.gwt.resources.client.ImageResource;

public interface PageExpertisesResources extends FontResources {
    interface Style extends GssResource {
        String expertises();

        String headerBg();

        String gwtp();

        String jukito();

        String products();

        String gae();

        String howWeWork();

        String partner();

        String icon1();

        String icon2();

        String icon3();

        String icon4();

        String icon5();

        String icon6();

        String iconDark();

        String triangleTop();

        String triangleBottom();

        String deliver();

        String costRisk();

        String iconHexa();

        String circleQuarter();

        String circle();

        String iterative();

        String launch();

        String iteration1();

        String bar1();

        String bar2();

        String bar3();

        String diagram();

        String bar7();

        String bar6();

        String bar5();

        String bar4();

        String learnAdapt();

        String whatWeDo();

        String developping();

        String title();
    }

    @Source("img/pages/expertisesBanner.png")
    ImageResource expertisesBanner();

    @Source("img/pages/expertisesLightBulb.png")
    ImageResource expertisesLightBulb();

    @Source({"com/arcbees/gsss/mixin/client/mixins.gss", "css/colors.gss", "fonts/geometria/geometria.gss", "css/pages/expertise.gss"})
    Style style();
}
