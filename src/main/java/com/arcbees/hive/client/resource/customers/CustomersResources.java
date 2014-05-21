package com.arcbees.hive.client.resource.customers;

import com.google.gwt.resources.client.ClientBundle;
import com.google.gwt.resources.client.CssResource;
import com.google.gwt.resources.client.ImageResource;

public interface CustomersResources extends ClientBundle {
    public interface Style extends CssResource {
        String customersContainer();

        String carousel();

        String carrouselContainer();

        String carouselInner();

        String stateTransition();

        String stateBeside();
    }

    Style style();

    ImageResource sliderCustomersButtonDroite();

    ImageResource sliderCustomersButtonDroiteRl();

    ImageResource sliderCustomersButtonGauche();

    ImageResource sliderCustomersButtonGaucheRl();

    ImageResource sliderClientBookedin();

    ImageResource sliderClientCobratag();

    ImageResource sliderClientEngonix();

    ImageResource sliderClientProtorisk();

    ImageResource sliderClientSceneverse();

    ImageResource sliderClientStoreplacer();

}
