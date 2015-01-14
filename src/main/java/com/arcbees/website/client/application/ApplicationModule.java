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

package com.arcbees.website.client.application;

import com.arcbees.website.client.application.bees.BeesModule;
import com.arcbees.website.client.application.careers.CareersModule;
import com.arcbees.website.client.application.contact.ContactModule;
import com.arcbees.website.client.application.expertise.ExpertiseModule;
import com.arcbees.website.client.application.home.HomeModule;
import com.arcbees.website.client.application.maps.MapsModule;
import com.arcbees.website.client.application.products.ProductsModule;
import com.arcbees.website.client.application.services.ServicesModule;
import com.arcbees.website.client.application.support.SupportModule;
import com.gwtplatform.mvp.client.gin.AbstractPresenterModule;

public class ApplicationModule extends AbstractPresenterModule {
    @Override
    protected void configure() {
        install(new HomeModule());
        install(new BeesModule());
        install(new CareersModule());
        install(new ContactModule());
        install(new ExpertiseModule());
        install(new SupportModule());
        install(new ServicesModule());
        install(new ProductsModule());
        install(new MapsModule());

        bindPresenter(ApplicationPresenter.class, ApplicationPresenter.MyView.class, ApplicationView.class,
                ApplicationPresenter.MyProxy.class);
    }
}
