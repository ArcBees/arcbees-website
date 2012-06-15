package com.arcbees.hive.client.application.uxdesign;

import com.arcbees.core.client.mvp.ViewImpl;
import com.arcbees.hive.client.resource.Resources;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.ui.Anchor;
import com.google.gwt.user.client.ui.Widget;

import static com.google.gwt.query.client.GQuery.$;

import javax.inject.Inject;

public class UxdesignView extends ViewImpl implements UxdesignPresenter.MyView {
    public interface Binder extends UiBinder<Widget, UxdesignView> {
    }

    @UiField
    Anchor mobileWebsiteMobileApplicationAnchor;
    @UiField
    Anchor informationDesignAnchor;
    @UiField
    Anchor informationArchitectureAnchor;
    @UiField
    Anchor interactionDesignInterfaceAnchor;
    @UiField
    Anchor ergonimicDesignAnchor;
    @UiField
    Anchor performanceMeasuresAnchor;

    private final Resources resources;

    private String previousCategoryId = UxCategoryIds.mobileWebsiteAndApplication();

    @Inject
    public UxdesignView(final Binder binder, Resources resources) {
        this.resources = resources;
        initWidget(binder.createAndBindUi(this));
    }

    @UiHandler("mobileWebsiteMobileApplicationAnchor")
    public void onBtWebAppMobile(ClickEvent event) {
        switchTo(mobileWebsiteMobileApplicationAnchor, UxCategoryIds.mobileWebsiteAndApplication());
    }

    @UiHandler("informationDesignAnchor")
    public void onBtInfoDesign(ClickEvent event) {
        switchTo(informationDesignAnchor, UxCategoryIds.informationDesign());
    }

    @UiHandler("informationArchitectureAnchor")
    public void onBtInfoArc(ClickEvent event) {
        switchTo(informationArchitectureAnchor, UxCategoryIds.informationArchitecture());
    }

    @UiHandler("interactionDesignInterfaceAnchor")
    public void onBtInterDesign(ClickEvent event) {
        switchTo(interactionDesignInterfaceAnchor, UxCategoryIds.interactionDesignInterface());
    }

    @UiHandler("ergonimicDesignAnchor")
    public void onBtErgoDesign(ClickEvent event) {
        switchTo(ergonimicDesignAnchor, UxCategoryIds.ergonomicDesign());
    }

    @UiHandler("performanceMeasuresAnchor")
    public void onBtPerfMeasure(ClickEvent event) {
        switchTo(performanceMeasuresAnchor, UxCategoryIds.performanceMeasures());
    }

    private void switchTo(Anchor anchor, String productId) {
        disableAll();
        enable(anchor);
        switchText(productId);
    }

    private void disableAll() {
        disableAnchor(mobileWebsiteMobileApplicationAnchor);
        disableAnchor(informationDesignAnchor);
        disableAnchor(informationArchitectureAnchor);
        disableAnchor(interactionDesignInterfaceAnchor);
        disableAnchor(ergonimicDesignAnchor);
        disableAnchor(performanceMeasuresAnchor);
    }

    private void disableAnchor(Anchor toDisable) {
        toDisable.setStyleName(resources.style().uxButtonOff());
    }

    private void enable(Anchor selected) {
        selected.setStyleName(resources.style().uxButtonOn());
    }

    private void switchText(String categoryId) {
        stopAllAnimations();

        $("#" + categoryId).fadeIn(500);
        $("#" + previousCategoryId).fadeOut(100);

        previousCategoryId = categoryId;
    }

    private void stopAllAnimations() {
        $("#uxCarousel > div").stop(true, true);
    }
}
