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

package com.arcbees.website.client.application.bees.quiz;

import javax.inject.Inject;

import com.google.web.bindery.event.shared.EventBus;
import com.gwtplatform.mvp.client.HasUiHandlers;
import com.gwtplatform.mvp.client.PresenterWidget;
import com.gwtplatform.mvp.client.View;

import static com.arcbees.website.client.application.bees.quiz.QuestionPresenter.MyView;

public class QuestionPresenter extends PresenterWidget<MyView> implements QuestionUiHandlers {
    public interface MyView extends View, HasUiHandlers<QuestionUiHandlers> {
        void setQuizFinished();

        void setQuestion(int questionNumber);
    }

    private int currentQuestion = 0;

    @Inject
    QuestionPresenter(
            EventBus eventBus,
            MyView view) {
        super(eventBus, view);

        getView().setUiHandlers(this);
    }

    @Override
    public void onNextQuestion() {
        ++currentQuestion;
        if (currentQuestion < 6) {
            getView().setQuestion(currentQuestion);
        } else {
            getView().setQuizFinished();
        }
    }

    @Override
    public void resetQuiz() {
        currentQuestion = 0;
        onNextQuestion();
    }

    @Override
    public void share() {
        // TODO: Implement share
    }

    @Override
    protected void onBind() {
        onNextQuestion();
    }
}
