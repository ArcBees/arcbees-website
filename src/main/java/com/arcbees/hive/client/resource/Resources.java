/*
 * Copyright 2010 ArcBees Inc.
 * 
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 * 
 * http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */

package com.arcbees.hive.client.resource;

import com.google.gwt.resources.client.ClientBundle;
import com.google.gwt.resources.client.CssResource;
import com.google.gwt.resources.client.ImageResource;
import com.google.gwt.resources.client.ImageResource.ImageOptions;
import com.google.gwt.resources.client.ImageResource.RepeatStyle;

public interface Resources extends ClientBundle {
    /**
     * Style strong typed interface.
     */
    public interface Style extends CssResource {
        String mainSectionContainer();

        String imgLeft();

        String imgRight();

        String imgCenter();

        String navBarBgSprite();

        String mainDegradeBgSprite();

        String bulleBgHeader();

        String bulleBgMain();

        String bulleBgHome();

        String bulleBgSlider();

        String bulleBgFooter();

        String cornerTop();

        String cornerBottom();

        String cornerTopBottom();

        String pHead();

        String headerContainer();

        String customersContainer();

        String rightLinkBox();

        String localeSwitcher();

        String footerContainer();

        String uxButton();

        String uxButtonOn();

        String uxButtonOff();

        String textOff();

        String textOn();

        String textOnBack();

        String contactUS();

        String job();

    }

    Style style();


    ImageResource uxButton();

    ImageResource uxButtonRl();

    ImageResource beeUx();

    ImageResource logoArcbees();

    ImageResource listIcon();

    ImageResource beeFlying();

    ImageResource bulleBgHeader();

    @ImageOptions(repeatStyle = RepeatStyle.Vertical)
    ImageResource bulleBgMain();

    ImageResource bulleBgHome();

    ImageResource bulleBgSlider();

    ImageResource bulleBgFooter();

    @ImageOptions(repeatStyle = RepeatStyle.Horizontal)
    ImageResource navBarBg();

    @ImageOptions(repeatStyle = RepeatStyle.Horizontal)
    ImageResource mainDegradeBg();

    ImageResource aboutPhilippe();

    ImageResource productGWTP();

    ImageResource productJUKITO();

    ImageResource contactUS();

    ImageResource job();

    ImageResource blogAbeilleConsulting();

    ImageResource aboutChristian();

    ImageResource aboutDavid();

    ImageResource aboutFrancis();

    ImageResource honeyConsultingDevelopmentSuccess();
}
