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

public interface PageWorkResources extends FontResources {
    interface Style extends GssResource {
        String work();

        String realisations();

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
    }

    @Source("img/pages/workBanner.png")
    ImageResource workBanner();

    @Source("img/pages/workGwt.png")
    ImageResource workGwt();

    @Source("img/pages/workKaam.png")
    ImageResource workKaam();

    @Source("img/pages/workLille.png")
    ImageResource workLille();

    @Source("img/pages/workRoller.png")
    ImageResource workRoller();

    @Source("img/pages/workTrustedCobra.png")
    ImageResource workTrustedCobra();

    @Source("img/pages/workTrustedBooked.png")
    ImageResource workTrustedBooked();

    @Source("img/pages/workTrustedProtorisk.png")
    ImageResource workTrustedProtorisk();

    @Source("img/pages/workTrustedSceneverse.png")
    ImageResource workTrustedSceneverse();

    @Source("img/pages/workTrustedStorePlacer.png")
    ImageResource workTrustedStorePlacer();

    @Source("img/pages/workTrustedZafin.png")
    ImageResource workTrustedZafin();

    @Source("img/pages/workTrustedRoler.png")
    ImageResource workTrustedRoler();

    @Source("img/pages/workTrustedLille.png")
    ImageResource workTrustedLille();

    @Source({"com/arcbees/gsss/mixin/client/mixins.gss", "css/colors.gss", "fonts/geometria/geometria.gss", "css/pages/work.gss"})
    Style style();
}
