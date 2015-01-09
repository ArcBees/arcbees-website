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

package com.arcbees.website.client.application.bees;

//import com.arcbees.website.client.application.bees.bee.christian.ChristianModule;

import com.arcbees.website.client.application.bees.bee.christian.ChristianModule;
import com.arcbees.website.client.application.bees.bee.christopher.ChristopherModule;
import com.arcbees.website.client.application.bees.bee.francois.FrancoisModule;
import com.arcbees.website.client.application.bees.bee.genevieve.GenevieveModule;
import com.arcbees.website.client.application.bees.bee.jason.JasonModule;
import com.arcbees.website.client.application.bees.bee.jeanchristophe.JeanchristopheModule;
import com.arcbees.website.client.application.bees.bee.joel.JoelModule;
import com.arcbees.website.client.application.bees.bee.julien.JulienModule;
import com.arcbees.website.client.application.bees.bee.larry.LarryModule;
import com.arcbees.website.client.application.bees.bee.manon.ManonModule;
import com.arcbees.website.client.application.bees.bee.maxime.MaximeModule;
import com.arcbees.website.client.application.bees.bee.philippearaujo.PhilippeaModule;
import com.arcbees.website.client.application.bees.bee.simonpierre.SimonpierreModule;
import com.arcbees.website.client.application.bees.bee.philippebeaudoin.PhilippebModule;
import com.arcbees.website.client.application.bees.quiz.QuestionPresenter;
import com.arcbees.website.client.application.bees.quiz.QuestionView;
import com.gwtplatform.mvp.client.gin.AbstractPresenterModule;

public class BeesModule extends AbstractPresenterModule {
    @Override
    protected void configure() {
        install(new ChristianModule());
        install(new ChristopherModule());
        install(new FrancoisModule());
        install(new GenevieveModule());
        install(new JasonModule());
        install(new JeanchristopheModule());
        install(new JoelModule());
        install(new JulienModule());
        install(new LarryModule());
        install(new ManonModule());
        install(new MaximeModule());
        install(new PhilippeaModule());
        install(new PhilippebModule());
        install(new SimonpierreModule());

        bindPresenter(BeesPresenter.class, BeesPresenter.MyView.class,
                BeesView.class, BeesPresenter.MyProxy.class);

        bindPresenterWidget(QuestionPresenter.class, QuestionPresenter.MyView.class, QuestionView.class);

        bind(Konami.class).asEagerSingleton();
    }
}
