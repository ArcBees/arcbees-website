package com.arcbees.hive.client.resource.home;

import com.google.gwt.resources.client.ClientBundle;
import com.google.gwt.resources.client.CssResource;
import com.google.gwt.resources.client.ImageResource;

public interface HomeResources extends ClientBundle {
    public interface Style extends CssResource {
        String sliderProductsButton();

        String sliderProductsOn();

        String sliderProductsOff();

        String home();

        String firstParagraph();

        String sliderProductsContainer();

        String productsNav();

        String stateAbove();

        String stateTransition();
    }

    Style style();

    ImageResource sliderProductsBt();

    ImageResource sliderProductsBtRl();

    ImageResource gwtHtml5Cloud();

    ImageResource sliderQuotesGauche();

    ImageResource sliderQuotesDroite();

    ImageResource sliderProductGWTPlatform();

    ImageResource sliderProductJukito();

    ImageResource sliderProductBeeHive();

    ImageResource sliderProductGAEStudio();

}
