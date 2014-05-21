package com.arcbees.hive.client.application.common;

import javax.inject.Inject;

import com.arcbees.hive.client.resource.customers.CustomersResources;
import com.google.gwt.core.client.Scheduler;
import com.google.gwt.dom.client.DivElement;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Widget;
import com.gwtplatform.mvp.client.ViewImpl;

import static com.google.gwt.query.client.GQuery.$;

public class CustomersView extends ViewImpl implements CustomersPresenter.MyView {
    public interface Binder extends UiBinder<Widget, CustomersView> {
    }

    private static int animationSidewaysDuration = 1250;
    private static int timerSidewaysPeriod = 7750;

    @UiField
    DivElement customerContainer;

    private final CustomersResources customersResources;
    private boolean isTimerOn;

    @Inject
    CustomersView(Binder binder,
                  CustomersResources customersResources) {
        initWidget(binder.createAndBindUi(this));

        this.customersResources = customersResources;
    }

    @Override
    public void startTimer() {
        isTimerOn = true;

        Scheduler.get().scheduleFixedPeriod(new Scheduler.RepeatingCommand() {
            public boolean execute() {
                moveProductsSideways();

                return isTimerOn;
            }
        }, timerSidewaysPeriod);
    }

    @Override
    public void stopTimer() {
        isTimerOn = false;
    }

    private void moveProductsSideways() {
        toggleClass(true);

        Scheduler.get().scheduleFixedPeriod(new Scheduler.RepeatingCommand() {
            public boolean execute() {
                removeProductClasses();

                return false;
            }
        }, animationSidewaysDuration);
    }

    private void removeProductClasses() {
        $("div:first-child", customerContainer).appendTo(customerContainer);
        toggleClass(false);
    }

    private void toggleClass(boolean addOrRemove) {
        $("div", customerContainer).toggleClass(customersResources.style().stateTransition(), addOrRemove);
        $("div", customerContainer).toggleClass(customersResources.style().stateBeside(), addOrRemove);
    }
}
