package com.arcbees.hive.client.application.common.socialmedia;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.user.client.ui.Widget;

import javax.inject.Inject;

public class SocialMediaWidget extends Composite {
    public interface Binder extends UiBinder<Widget, SocialMediaWidget> {
    }

    @Inject
    public SocialMediaWidget(final Binder binder) {
        initWidget(binder.createAndBindUi(this));
    }
}
