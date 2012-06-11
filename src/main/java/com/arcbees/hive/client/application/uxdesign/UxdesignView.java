package com.arcbees.hive.client.application.uxdesign;

import com.arcbees.core.client.mvp.ViewImpl;
import com.arcbees.hive.client.resource.Resources;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.query.client.GQuery;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Anchor;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.user.client.ui.Widget;

import static com.google.gwt.query.client.GQuery.*;

import com.google.gwt.query.client.Function;

import javax.inject.Inject;

public class UxdesignView extends ViewImpl implements UxdesignPresenter.MyView {
    @UiField
    Anchor btWebAppMobile;
    @UiField
    Anchor btInfoDesign;
    @UiField
    Anchor btInfoArc;
    @UiField
    Anchor btInterDesign;
    @UiField
    Anchor btErgoDesign;
    @UiField
    Anchor btPerfMeasure;
    @UiField
    HTMLPanel uxCarousel;

    private final Resources resources;

    public interface Binder extends UiBinder<Widget, UxdesignView> {
    }

    @Inject
    public UxdesignView(final Binder binder, Resources resources) {
        this.resources = resources;
        initWidget(binder.createAndBindUi(this));
    }

    @UiHandler("btWebAppMobile")
    public void onBtWebAppMobile(ClickEvent event) {
        changeUxText(0);
    }

    @UiHandler("btInfoDesign")
    public void onBtInfoDesign(ClickEvent event) {
        changeUxText(1);
    }

    @UiHandler("btInfoArc")
    public void onBtInfoArc(ClickEvent event) {
        changeUxText(2);
    }

    @UiHandler("btInterDesign")
    public void onBtInterDesign(ClickEvent event) {
        changeUxText(3);
    }

    @UiHandler("btErgoDesign")
    public void onBtErgoDesign(ClickEvent event) {
        changeUxText(4);
    }

    @UiHandler("btPerfMeasure")
    public void onBtPerfMeasure(ClickEvent event) {
        changeUxText(5);
    }

    private void changeUxText(int index) {
        setEnabled(index);
        swappingText(index);
    }

    private void swappingText(int index) {
        Widget widgetSelected = uxCarousel.getWidget(index);
        final Resources.Style style = resources.style();
        if (!widgetSelected.getStyleName().equals(style.uxTextOn())) {
            widgetSelected.setStyleName(style.uxTextOnBack());
            widgetSelected.getElement().setAttribute("style", "display:none");
            $("." + style.uxTextOn()).fadeOut(500, new Function() {
                @Override
                public void f() {
                    int widgetCount = uxCarousel.getWidgetCount();
                    GQuery widgetOnBack = $("." + style.uxTextOnBack());

                    for (int i = 0; i < widgetCount; i++) {
                        Widget currentWidget = uxCarousel.getWidget(i);
                        currentWidget.getElement().setAttribute("style", "display:none");

                        if (!currentWidget.getStyleName().equals(style.uxTextOnBack())) {
                            currentWidget.getElement().setClassName("");
                        }
                    }
                    widgetOnBack.fadeIn(500, new Function() {
                        @Override
                        public void f() {

                            GQuery widgetOnBack = $("." + style.uxTextOnBack());
                            widgetOnBack.removeClass(style.uxTextOnBack());
                            widgetOnBack.addClass(style.uxTextOn());
                        }
                    });
                }
            });
        }
    }

    private void setEnabled(int index) {
        disableAll();

        Anchor selected = btWebAppMobile;

        switch (index) {
            case 0:
                selected = btWebAppMobile;
                break;
            case 1:
                selected = btInfoDesign;
                break;
            case 2:
                selected = btInfoArc;
                break;
            case 3:
                selected = btInterDesign;
                break;
            case 4:
                selected = btErgoDesign;
                break;
            case 5:
                selected = btPerfMeasure;
                break;
            default:
                Window.alert("wrong index: " + index);
                break;
        }

        enable(selected);
    }

    private void disableAll() {
        disableAnchor(btWebAppMobile);
        disableAnchor(btInfoDesign);
        disableAnchor(btInfoArc);
        disableAnchor(btInterDesign);
        disableAnchor(btErgoDesign);
        disableAnchor(btPerfMeasure);
    }

    private void disableAnchor(Anchor toDisable) {
        toDisable.setStyleName(resources.style().uxButtonOff());
    }

    private void enable(Anchor selected) {
        selected.setStyleName(resources.style().uxButtonOn());
    }
}
