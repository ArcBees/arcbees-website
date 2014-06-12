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

package com.arcbees.hive.client.resource.splash;

import com.google.gwt.resources.client.ClientBundle;
import com.google.gwt.resources.client.GssResource;
import com.google.gwt.resources.client.DataResource;
import com.google.gwt.resources.client.ImageResource;

public interface SplashResources extends ClientBundle {
    public interface Style extends GssResource {
        String logoArcBees();

        String logoArcBeesSmall();

        String left();

        String pageWrap();

        String main();

        String contentWidth();

        String social();

        String bold();

        String bouton();

        String siteFooter();

        String copyright();

        String bottomWhiteSpace();

        String right();

        String socialContainer();

        String typo();

        String boldFam();

        String regularFamBold();

        String regularFam();

        String regularFamB();

        String regularFamL();

        String regularFamO();
    }

    Style style();

    ImageResource bigArcbeesLogo();

    ImageResource smallArcbeesLogo();

    @Source("fonts/geometria_light.eot")
    DataResource geometriaLightEot();

    @Source("fonts/geometria_light.svg")
    DataResource geometriaLightSvg();

    @Source("fonts/geometria_light.ttf")
    DataResource geometriaLightTtf();

    @Source("fonts/geometria_light.woff")
    DataResource geometriaLightWoff();

    @Source("fonts/geometria_regular.eot")
    DataResource geometriaRegularEot();

    @Source("fonts/geometria_regular.svg")
    DataResource geometriaRegularSvg();

    @Source("fonts/geometria_regular.ttf")
    DataResource geometriaRegularTtf();

    @Source("fonts/geometria_regular.woff")
    DataResource geometriaRegularWoff();

    @Source("fonts/geometria_bold.eot")
    DataResource geometriaBoldEot();

    @Source("fonts/geometria_bold.svg")
    DataResource geometriaBoldSvg();

    @Source("fonts/geometria_bold.ttf")
    DataResource geometriaBoldTtf();

    @Source("fonts/geometria_bold.woff")
    DataResource geometriaBoldWoff();
}
