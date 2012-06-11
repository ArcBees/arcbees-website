package com.arcbees.hive.client.resource.socialmedia;

import com.google.gwt.resources.client.ClientBundle;
import com.google.gwt.resources.client.CssResource;
import com.google.gwt.resources.client.ImageResource;

public interface SocialMediaResources extends ClientBundle {
    public interface Style extends CssResource {

        String facebookIcon_small();

        String linkedinIcon_small();

        String twitterIcon_small();

        String wordpressIcon_small();

        String picasaIcon_small();

        String facebookIcon_large();

        String linkedinIcon_large();

        String twitterIcon_large();

        String wordpressIcon_large();

        String picasaIcon_large();
    }

    Style style();

    ImageResource facebookIcon_small();

    ImageResource facebookIconRl_small();

    ImageResource linkedinIcon_small();

    ImageResource linkedinIconRl_small();

    ImageResource twitterIcon_small();

    ImageResource twitterIconRl_small();

    ImageResource wordpressIcon_small();

    ImageResource wordpressIconRl_small();

    ImageResource picasaIcon_small();

    ImageResource picasaIconRl_small();

    ImageResource facebookIcon_large();

    ImageResource facebookIconRl_large();

    ImageResource linkedinIcon_large();

    ImageResource linkedinIconRl_large();

    ImageResource twitterIcon_large();

    ImageResource twitterIconRl_large();

    ImageResource wordpressIcon_large();

    ImageResource wordpressIconRl_large();

    ImageResource picasaIcon_large();

    ImageResource picasaIconRl_large();
}
