package com.arcbees.hive.client.application.common;

import javax.inject.Inject;

import com.arcbees.hive.client.resource.customers.CustomersResources;
import com.google.gwt.core.client.Scheduler;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.user.client.ui.Widget;
import com.gwtplatform.mvp.client.ViewImpl;

import static com.google.gwt.query.client.GQuery.$;

public class CustomersView extends ViewImpl implements CustomersPresenter.MyView {

    private final CustomersResources customersResources;
    private boolean isTimerOn;

    public String carouselContainer;
    public String stateTransitionStyleName;
    public String stateBesideStyleName;

    public String allCarrouselDivs;
    public String firstCarrouselDiv;


    public interface Binder extends UiBinder<Widget, CustomersView> {

    }

    @Inject
    public CustomersView(final Binder binder,
                         CustomersResources customersResources) {
        initWidget(binder.createAndBindUi(this));

        this.customersResources = customersResources;

        carouselContainer = "." + customersResources.style().carouselInner();
        stateTransitionStyleName = customersResources.style().stateTransition();
        stateBesideStyleName = customersResources.style().stateBeside();

        allCarrouselDivs = carouselContainer + " div";
        firstCarrouselDiv = carouselContainer + " div:first-child";
    }

    @Override
    public void startTimer() {
        isTimerOn = true;

        Scheduler.get().scheduleFixedPeriod(new Scheduler.RepeatingCommand() {
            public boolean execute() {
                moveProductsSideways();

                return isTimerOn;
            }
        }, 7750);
    }

    @Override
    public void stopTimer() {
        isTimerOn = false;
    }

    private void moveProductsSideways() {
        $(allCarrouselDivs).addClass(stateTransitionStyleName);
        $(allCarrouselDivs).addClass(stateBesideStyleName);

        Scheduler.get().scheduleFixedPeriod(new Scheduler.RepeatingCommand() {
            public boolean execute() {
                removeProductClasses();

                return false;
            }
        }, 1250);
    }


    private void removeProductClasses() {
        $(firstCarrouselDiv).appendTo(carouselContainer);
        $(allCarrouselDivs).removeClass(stateTransitionStyleName);
        $(allCarrouselDivs).removeClass(stateBesideStyleName);
    }
}
