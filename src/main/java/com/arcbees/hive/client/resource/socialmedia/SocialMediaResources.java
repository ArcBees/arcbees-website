package com.arcbees.hive.client.resource.socialmedia;

import com.google.gwt.resources.client.ClientBundle;
import com.google.gwt.resources.client.CssResource;
import com.google.gwt.resources.client.ImageResource;

public interface SocialMediaResources extends ClientBundle {
    public interface Style extends CssResource {

        String facebookIcon();

        String linkedinIcon();

        String twitterIcon();

        String wordpressIcon();

        String picasaIcon();

    }

    Style style();

    ImageResource facebookIcon();

    ImageResource facebookIconRl();

    ImageResource linkedinIcon();

    ImageResource linkedinIconRl();

    ImageResource twitterIcon();

    ImageResource twitterIconRl();

    ImageResource wordpressIcon();

    ImageResource wordpressIconRl();

    ImageResource picasaIcon();

    ImageResource picasaIconRl();
}
