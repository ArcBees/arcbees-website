/*
 * Copyright 2014 ArcBees Inc.
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

        String slide();

        String slides();

        String prev();

        String next();

        String pager();

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
    }

    @Source("img/bees/christian.jpg")
    ImageResource beeChristian();

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
