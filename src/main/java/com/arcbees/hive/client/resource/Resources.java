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
        String cursor();

        String blogBackground();

        String blogDown();

        String blogDownContact();

        String blogDownJob();

        String blogLeft();

        String blogLeftFull();

        String blogRight();

        String blogRightFull();

        String sloganDescription();

        String sloganCoinGauche();

        String sloganCoinDroit();

        String bodBarDroiteB();

        String bodBarDroiteG();

        String bodBarDroiteO();

        String bodBarDroiteV();

        String bodBarGaucheB();

        String bodBarGaucheG();

        String bodBarGaucheO();

        String bodBarGaucheV();

        String bodBarMidB();

        String bodBarMidG();

        String bodBarMidO();

        String bodBarMidV();

        String stepInactive();

        String stepActive();

        String navPrincipaleMilieuSprite();

        String headerBg();

        String cornerTop();

        String cornerBottom();

        String cornerTopBottom();

    }

    Style style();

    ImageResource logoArcbees();


    @Source("honConsulting.jpg")
    ImageResource consulting();

    @Source("honPlus.png")
    ImageResource hplus();

    @Source("honDevelopment.jpg")
    ImageResource development();

    @Source("honEqual.png")
    ImageResource hequals();

    @Source("honSuccess.jpg")
    ImageResource success();

    ImageResource head();

    @ImageOptions(repeatStyle = RepeatStyle.Horizontal)
    ImageResource navPrincipaleMilieu();

    ImageResource blogAbeille();

    ImageResource blogBarDroite();

    ImageResource blogBarDroiteFull();

    ImageResource blogBarGauche();

    ImageResource blogBarGaucheFull();

    ImageResource bodDown();

    ImageResource rssFeed();

    ImageResource serConsultation();

    ImageResource serDeveloppement();

    ImageResource serFormation();

    ImageResource serSupport();

    ImageResource bodCoinDroitUp();

    ImageResource bodCoinGaucheUp();

    @ImageOptions(repeatStyle = RepeatStyle.Vertical)
    ImageResource bodTransition();

    ImageResource bodBarDroiteB();

    ImageResource bodBarDroiteG();

    ImageResource bodBarDroiteO();

    ImageResource bodBarDroiteV();

    ImageResource bodBarGaucheB();

    ImageResource bodBarGaucheG();

    ImageResource bodBarGaucheO();

    ImageResource bodBarGaucheV();

    @ImageOptions(repeatStyle = RepeatStyle.Horizontal)
    ImageResource bodBarMidB();

    @ImageOptions(repeatStyle = RepeatStyle.Horizontal)
    ImageResource bodBarMidG();

    @ImageOptions(repeatStyle = RepeatStyle.Horizontal)
    ImageResource bodBarMidO();

    @ImageOptions(repeatStyle = RepeatStyle.Horizontal)
    ImageResource bodBarMidV();

    ImageResource fooDown();

    ImageResource fooUp();

    ImageResource fooDroite();

    ImageResource fooGauche();

    ImageResource aboutPhilippe();

    ImageResource serMiel();

    ImageResource productGWTP();

    ImageResource productJUKITO();

    ImageResource contactUS();

    ImageResource bodDownContact();

    ImageResource job();

    ImageResource bodDownJob();

    ImageResource blogAbeilleConsulting();

    ImageResource blogAbeilleDevelop();

    ImageResource blogBookedin();

    ImageResource blogCloudInside();

    ImageResource imagem();

    ImageResource aboutChristian();

    ImageResource aboutDavid();

    ImageResource aboutFrancis();

    ImageResource gwtHtml5Cloud();
}
