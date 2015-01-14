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

import javax.inject.Inject;

public class ResourceLoader {
    @Inject
    ResourceLoader(
            AppResources appResources,
            FontResources fontResources,
            AnimationsResources animationsResources,
            PageProductResources pageProductResources,
            PageProductChosenResources pageProductChosenResources,
            PageServicesResources pageServicesResources,
            PageContactResources pageContactResources,
            PageCareersResources pageCareersResources,
            PageHomeResources pageHomeResources,
            PageExpertisesResources pageExpertisesResources,
            PageSupportResources pageSupportResources,
            SliderResources sliderResources) {
        appResources.normalize().ensureInjected();
        appResources.style().ensureInjected();
        appResources.grid().ensureInjected();
        animationsResources.style().ensureInjected();
        fontResources.icons().ensureInjected();
        pageHomeResources.style().ensureInjected();
        pageProductResources.style().ensureInjected();
        pageProductChosenResources.css().ensureInjected();
        pageContactResources.style().ensureInjected();
        pageCareersResources.style().ensureInjected();
        pageServicesResources.style().ensureInjected();
        pageExpertisesResources.style().ensureInjected();
        pageSupportResources.style().ensureInjected();
        sliderResources.style().ensureInjected();
    }
}
