/**
 * Copyright 2015 ArcBees Inc.
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

package com.arcbees.website.client.resources;

import com.arcbees.gsss.animation.client.AnimationResources;
import com.google.gwt.i18n.client.Messages;
import com.google.gwt.resources.client.ImageResource;

public interface PageBeesResources extends FontResources {
    interface Style extends AnimationResources.Animation {
        String bees();

        String active();

        String bee();

        String beeHolder1();

        String beeHolder2();

        String bee1();

        String bee2();

        String bee3();

        String hive();

        String intro();

        String icon1();

        String icon2();

        String icon3();

        String icon4();

        String icon5();

        String icon6();

        String popup();

        String popupContent();

        String header();

        String offers();

        String social();

        String popupClose();

        String colGauche();

        String colDroite();

        String colGaucheLarge();

        String quiz();

        String quizEnd();

        String valuesSlider();
    }

    @Source("img/bees/christian.jpg")
    ImageResource beeChristian();

    @Source("img/bees/christian1.jpg")
    ImageResource beeChristian1();

    @Source("img/bees/christian2.jpg")
    ImageResource beeChristian2();

    @Source("img/bees/christopher1.jpg")
    ImageResource beeChristopher1();

    @Source("img/bees/christopher2.jpg")
    ImageResource beeChristopher2();

    @Source("img/bees/francois1.jpg")
    ImageResource beeFrancois1();

    @Source("img/bees/francois2.jpg")
    ImageResource beeFrancois2();

    @Source("img/bees/ge1.jpg")
    ImageResource beeGenevieve1();

    @Source("img/bees/ge2.jpg")
    ImageResource beeGenevieve2();

    @Source("img/bees/jason1.jpg")
    ImageResource beeJason1();

    @Source("img/bees/jason2.jpg")
    ImageResource beeJason2();

    @Source("img/bees/jc1.jpg")
    ImageResource beeJeanChristophe1();

    @Source("img/bees/jc2.jpg")
    ImageResource beeJeanChristophe2();

    @Source("img/bees/joel1.jpg")
    ImageResource beeJoel1();

    @Source("img/bees/joel2.jpg")
    ImageResource beeJoel2();

    @Source("img/bees/julien1.jpg")
    ImageResource beeJulien1();

    @Source("img/bees/julien2.jpg")
    ImageResource beeJulien2();

    @Source("img/bees/larry1.jpg")
    ImageResource beeLarry1();

    @Source("img/bees/larry2.jpg")
    ImageResource beeLarry2();

    @Source("img/bees/manon1.jpg")
    ImageResource beeManon1();

    @Source("img/bees/manon2.jpg")
    ImageResource beeManon2();

    @Source("img/bees/maxime1.jpg")
    ImageResource beeMaxime1();

    @Source("img/bees/maxime2.jpg")
    ImageResource beeMaxime2();

    @Source("img/bees/philippeA1.jpg")
    ImageResource beePhilippeA1();

    @Source("img/bees/philippeA2.jpg")
    ImageResource beePhilippeA2();

    @Source("img/bees/philippeb1.jpg")
    ImageResource beePhilippeb1();

    @Source("img/bees/sp1.jpg")
    ImageResource beeSimonPierre1();

    @Source("img/bees/sp2.jpg")
    ImageResource beeSimonPierre2();

    @Source("img/bees/quiz/questions1.png")
    ImageResource questions1();

    @Source("img/bees/quiz/questions2.png")
    ImageResource questions2();

    @Source("img/bees/quiz/questions3.png")
    ImageResource questions3();

    @Source("img/bees/quiz/questions4.png")
    ImageResource questions4();

    @Source("img/bees/quiz/questions5.png")
    ImageResource questions5();

    @Source({"com/arcbees/gsss/animation/client/animationsettings.gss",
            "com/arcbees/gsss/animation/client/animations.gss",
            "com/arcbees/gsss/mixin/client/mixins.gss",
            "fonts/geometria/geometria.gss",
            "css/colors.gss",
            "css/pages/bees.gss"})
    Style style();

    interface QuizMessages extends Messages {
        String question(@PluralCount int questionNumber);

        String answer1(@PluralCount int questionNumber);

        String answer2(@PluralCount int questionNumber);

        String answer3(@PluralCount int questionNumber);
    }
}
