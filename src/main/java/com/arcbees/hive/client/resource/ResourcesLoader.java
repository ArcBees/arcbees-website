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

package com.arcbees.hive.client.resource;

import javax.inject.Inject;

import com.arcbees.hive.client.application.common.CustomersPresenter;
import com.arcbees.hive.client.resource.customers.CustomersResources;
import com.arcbees.hive.client.resource.home.HomeResources;
import com.arcbees.hive.client.resource.products.ProductsResources;
import com.arcbees.hive.client.resource.reinit.ReinitResources;
import com.arcbees.hive.client.resource.socialmedia.SocialMediaResources;
import com.arcbees.hive.client.resource.splash.SplashResources;
import com.arcbees.hive.client.resource.team.TeamResources;

public class ResourcesLoader {
    @Inject
    ResourcesLoader(Resources resources,
                    ReinitResources reinitResources,
                    TeamResources teamResources,
                    SocialMediaResources socialMediaResources,
                    ProductsResources productsResources,
                    HomeResources homeResources,
                    CustomersResources customersResources,
                    SplashResources splashResources) {
        reinitResources.style().ensureInjected();
        resources.style().ensureInjected();
        teamResources.style().ensureInjected();
        socialMediaResources.style().ensureInjected();
        productsResources.style().ensureInjected();
        homeResources.style().ensureInjected();
        customersResources.style().ensureInjected();
        splashResources.style().ensureInjected();
    }
}
