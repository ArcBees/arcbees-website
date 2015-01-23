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

public interface PageHomeResources extends FontResources {
    interface Style extends AnimationResources.Animation {
        String home();

        String bees();

        String beesContent();

        String iconPlus();

        String equal();

        String header();

        String txtArch();

        String txtCreate();

        String txtBees();

        String txtAre();

        String txtArchitects();

        String txtProducts();

        String txtBanner();

        String successStory();

        String successStoryMore();

        String collapsible();

        String ssicons();

        String successStoryHolder();

        String path3();

        String path2();

        String ssiconsHexa();

        String logoConstruct();

        String border();

        String logo();

        String horizontal();

        String vertical();

        String diagonal();

        String path1();

        String architect();

        String btns();

        String beeTheBest();
    }

    @Source("img/pages/homeBeesBg.png")
    ImageResource beesBg();

    @Source("img/pages/homeSuccessStoryIcons.png")
    ImageResource ssicons();

    @Source("img/pages/homeSuccessStoryIconsMobile.png")
    ImageResource ssiconsMobile();

    @Source("img/pages/homeSuccessStoryRainbow.png")
    ImageResource ssrainbow();

    @Source({"com/arcbees/gsss/animation/client/animationsettings.gss",
            "com/arcbees/gsss/animation/client/animations.gss", "com/arcbees/gsss/mixin/client/mixins.gss",
            "css/colors.gss", "fonts/geometria/geometria.gss", "css/pages/home.gss"})
    Style style();
}
