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
    protected void onBind() {
        getView().setQuestion(1);
    }

    @Inject
    QuestionPresenter(
            EventBus eventBus,
            MyView view) {
        super(eventBus, view);

        getView().setUiHandlers(this);
    }
}
