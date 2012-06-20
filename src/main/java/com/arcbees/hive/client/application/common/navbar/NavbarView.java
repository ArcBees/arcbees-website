package com.arcbees.hive.client.application.common.navbar;

import com.arcbees.core.client.mvp.ViewImpl;
import com.arcbees.hive.client.place.NameTokens;
import com.arcbees.hive.client.resource.Resources;
import com.google.gwt.dom.client.AnchorElement;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Widget;

import javax.inject.Inject;

import static com.google.gwt.query.client.GQuery.$;

public class NavbarView extends ViewImpl implements NavbarPresenter.MyView {
    @UiField
    AnchorElement servicesAnchor;
    @UiField
    AnchorElement productsAnchor;
    @UiField
    AnchorElement uxDesignAnchor;
    @UiField
    AnchorElement teamAnchor;
    @UiField
    AnchorElement contactAnchor;

    private final Resources style;

    public interface Binder extends UiBinder<Widget, NavbarView> {
    }

    @Inject
    public NavbarView(final Binder binder, Resources style) {
        this.style = style;
        initWidget(binder.createAndBindUi(this));
    }

    @Override
    public void activateCurrentLink(String nameToken) {
        disableAllLinks();

        if (nameToken.equals(NameTokens.getService())) {
            activateLink(servicesAnchor);
        } else if(nameToken.equals(NameTokens.getProduct())){
            activateLink(productsAnchor);
        } else if(nameToken.equals(NameTokens.getUxdesign())){
            activateLink(uxDesignAnchor);
        } else if(nameToken.equals(NameTokens.getTeam())){
            activateLink(teamAnchor);
        } else if(nameToken.equals(NameTokens.getContact())){
            activateLink(contactAnchor);
        }
    }

    private void disableAllLinks() {
        $(servicesAnchor.getChildNodes()).removeClass(style.style().navbarAnchorOn());
        $(productsAnchor.getChildNodes()).removeClass(style.style().navbarAnchorOn());
        $(uxDesignAnchor.getChildNodes()).removeClass(style.style().navbarAnchorOn());
        $(teamAnchor.getChildNodes()).removeClass(style.style().navbarAnchorOn());
        $(contactAnchor.getChildNodes()).removeClass(style.style().navbarAnchorOn());
    }

    private void activateLink(AnchorElement anchorElement) {
        $(anchorElement.getChildNodes()).addClass(style.style().navbarAnchorOn());
    }
}
