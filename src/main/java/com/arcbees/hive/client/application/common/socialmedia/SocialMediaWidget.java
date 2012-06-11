package com.arcbees.hive.client.application.common.socialmedia;

import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiTemplate;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;
import com.google.inject.assistedinject.Assisted;

import javax.inject.Inject;

public class SocialMediaWidget extends Composite {
    @UiTemplate("SocialMediaWidget_small.ui.xml")
    public interface SmallBinder extends UiBinder<Widget, SocialMediaWidget> {
    }

    @UiTemplate("SocialMediaWidget_large.ui.xml")
    public interface LargeBinder extends UiBinder<Widget, SocialMediaWidget> {
    }

    @Inject
    public SocialMediaWidget(final SmallBinder smallBinder,
                             final LargeBinder largeBinder,
                             @Assisted SocialMediaWidgetSize size) {
        switch (size) {
            case Small:
                initWidget(smallBinder.createAndBindUi(this));
                break;
            case Large:
                initWidget(largeBinder.createAndBindUi(this));
                break;
        }
    }
}
