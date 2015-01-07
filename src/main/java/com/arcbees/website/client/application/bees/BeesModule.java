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

package com.arcbees.website.client.application.bees;

import com.arcbees.website.client.application.bees.bee.ChristianModule;
import com.arcbees.website.client.application.bees.quiz.QuestionPresenter;
import com.arcbees.website.client.application.bees.quiz.QuestionView;
import com.gwtplatform.mvp.client.gin.AbstractPresenterModule;

public class BeesModule extends AbstractPresenterModule {
    @Override
    protected void configure() {
        install(new ChristianModule());

        bindPresenter(BeesPresenter.class, BeesPresenter.MyView.class,
                BeesView.class, BeesPresenter.MyProxy.class);

        bindPresenterWidget(QuestionPresenter.class, QuestionPresenter.MyView.class, QuestionView.class);

        bind(Konami.class).asEagerSingleton();
    }
}
