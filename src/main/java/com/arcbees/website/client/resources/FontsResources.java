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

import com.google.gwt.resources.client.ClientBundle;
import com.google.gwt.resources.client.DataResource;
import com.google.gwt.resources.client.GssResource;

public interface FontsResources extends ClientBundle {
    public interface Icons extends GssResource {
        String iconSignCode();

        String iconArcbees();

        String iconArrowDown();

        String iconArrowOutside();

        String iconHexagon();

        String iconLadder();

        String iconBees();

        String iconChosen();

        String iconClose();

        String iconDevTime();

        String iconFb();

        String iconGae();

        String iconGithub();

        String iconGPlus();

        String iconGwtp();

        String iconInfo();

        String iconJukito();

        String iconLkdIn();

        String iconMapPin();

        String iconMenu();

        String iconQ1a();

        String iconQ1b();

        String iconQ1c();

        String iconQ2a();

        String iconQ2b();

        String iconQ2c();

        String iconQ3a();

        String iconQ3b();

        String iconQ3c();

        String iconQ4a();

        String iconQ4b();

        String iconQ4c();

        String iconSearch();

        String iconShare();

        String iconTwit();

        String iconWordpress();
    }

    @Source("css/fonts/icons/icons.ttf")
    DataResource iconsTtf();

    @Source("css/fonts/icons/icons.eot")
    DataResource iconsEot();

    @Source("css/fonts/icons/icons.svg")
    DataResource iconsSvg();

    @Source("css/fonts/icons/icons.woff")
    DataResource iconsWoff();

    @Source("css/fonts/icons/icons.gss")
    Icons icons();
}
