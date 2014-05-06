package com.arcbees.hive.client.resource;

import javax.inject.Inject;

import com.arcbees.hive.client.application.common.CustomersPresenter;
import com.arcbees.hive.client.resource.customers.CustomersResources;
import com.arcbees.hive.client.resource.home.HomeResources;
import com.arcbees.hive.client.resource.products.ProductsResources;
import com.arcbees.hive.client.resource.reinit.ReinitResources;
import com.arcbees.hive.client.resource.socialmedia.SocialMediaResources;
import com.arcbees.hive.client.resource.team.TeamResources;

public class ResourcesLoader {
    @Inject
    ResourcesLoader(Resources resources,
                    ReinitResources reinitResources,
                    TeamResources teamResources,
                    SocialMediaResources socialMediaResources,
                    ProductsResources productsResources,
                    HomeResources homeResources,
                    CustomersResources customersResources) {
        reinitResources.style().ensureInjected();
        resources.style().ensureInjected();
        teamResources.style().ensureInjected();
        socialMediaResources.style().ensureInjected();
        productsResources.style().ensureInjected();
        homeResources.style().ensureInjected();
        customersResources.style().ensureInjected();
    }
}
