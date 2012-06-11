package com.arcbees.hive.client.resource.products;

import com.google.gwt.resources.client.ClientBundle;
import com.google.gwt.resources.client.CssResource;
import com.google.gwt.resources.client.ImageResource;

public interface ProductsResources extends ClientBundle {
    public interface Style extends CssResource {
        String productsBH();

        String productsBHOn();

        String productsGWTP();

        String productsGWTPOn();

        String productsJukito();

        String productsJukitoOn();

        String productsGAE();

        String productsGAEOn();

    }

    Style style();

    ImageResource productsBH();

    ImageResource productsBHRl();

    ImageResource productsBHOn();

    ImageResource productsGAE();

    ImageResource productsGAERl();

    ImageResource productsGAEOn();

    ImageResource productsGWTP();

    ImageResource productsGWTPRl();

    ImageResource productsGWTPOn();

    ImageResource productsJukito();

    ImageResource productsJukitoRl();

    ImageResource productsJukitoOn();

}

