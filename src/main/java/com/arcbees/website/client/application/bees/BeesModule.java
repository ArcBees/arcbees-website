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

import com.arcbees.website.client.application.bees.bee.charles.CharlesModule;
import com.arcbees.website.client.application.bees.bee.christian.ChristianModule;
import com.arcbees.website.client.application.bees.bee.christopher.ChristopherModule;
import com.arcbees.website.client.application.bees.bee.jason.JasonModule;
import com.arcbees.website.client.application.bees.bee.jeannicolas.JeanNicolasModule;
import com.arcbees.website.client.application.bees.bee.keven.KevenModule;
import com.arcbees.website.client.application.bees.bee.larry.LarryModule;
import com.arcbees.website.client.application.bees.bee.manon.ManonModule;
import com.arcbees.website.client.application.bees.bee.maxime.MaximeModule;
import com.arcbees.website.client.application.bees.bee.philippebeaudoin.PhilippebModule;
import com.arcbees.website.client.application.bees.bee.renaud.RenaudModule;
import com.arcbees.website.client.application.bees.bee.simon.SimonModule;
import com.arcbees.website.client.application.bees.bee.vincent.VincentModule;
import com.arcbees.website.client.application.bees.quiz.QuestionPresenter;
import com.arcbees.website.client.application.bees.quiz.QuestionView;
import com.gwtplatform.mvp.client.gin.AbstractPresenterModule;

public class BeesModule extends AbstractPresenterModule {
    @Override
    protected void configure() {
        install(new ChristianModule());
        install(new ChristopherModule());
        install(new JasonModule());
        install(new JeanNicolasModule());
        install(new LarryModule());
        install(new ManonModule());
        install(new MaximeModule());
        install(new PhilippebModule());
        install(new RenaudModule());
        install(new VincentModule());
        install(new CharlesModule());
        install(new KevenModule());
        install(new SimonModule());

        bindPresenter(BeesPresenter.class, BeesPresenter.MyView.class,
                BeesView.class, BeesPresenter.MyProxy.class);

        bindPresenterWidget(QuestionPresenter.class, QuestionPresenter.MyView.class, QuestionView.class);

        bind(Konami.class).asEagerSingleton();
    }
}
