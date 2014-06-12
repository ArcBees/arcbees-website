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
import com.google.gwt.resources.client.DataResource;
import com.google.gwt.resources.client.GssResource;
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
    }

    Style style();

    ImageResource bigArcbeesLogo();

    ImageResource smallArcbeesLogo();

    @Source("fonts/geometria_r.eot")
    DataResource geometriaRegularEot();

    @Source("fonts/geometria_r.ttf")
    DataResource geometriaRegularTtf();

    @Source("fonts/geometria_r.svg")
    DataResource geometriaRegularSvg();

    @Source("fonts/geometria_r.woff")
    DataResource geometriaRegularWoff();

    @Source("fonts/geometria_l.eot")
    DataResource geometriaLightEot();

    @Source("fonts/geometria_l.ttf")
    DataResource geometriaLightTtf();

    @Source("fonts/geometria_l.svg")
    DataResource geometriaLightSvg();

    @Source("fonts/geometria_l.woff")
    DataResource geometriaLightWoff();

    @Source("fonts/geometria_b.eot")
    DataResource geometriaBoldEot();

    @Source("fonts/geometria_b.ttf")
    DataResource geometriaBoldTtf();

    @Source("fonts/geometria_b.svg")
    DataResource geometriaBoldSvg();

    @Source("fonts/geometria_b.woff")
    DataResource geometriaBoldWoff();

}
