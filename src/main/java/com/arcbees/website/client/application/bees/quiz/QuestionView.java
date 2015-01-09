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

import com.arcbees.gquery.tooltip.client.TooltipOptions;
import com.arcbees.website.client.resources.AppResources;
import com.arcbees.website.client.resources.PageBeesResources.QuizMessages;
import com.google.gwt.dom.client.DivElement;
import com.google.gwt.dom.client.ParagraphElement;
import com.google.gwt.dom.client.SpanElement;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.logical.shared.AttachEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.Widget;
import com.gwtplatform.mvp.client.ViewWithUiHandlers;

import static com.arcbees.gquery.tooltip.client.Tooltip.Tooltip;
import static com.google.gwt.query.client.GQuery.$;

public class QuestionView extends ViewWithUiHandlers<QuestionUiHandlers>
        implements QuestionPresenter.MyView, AttachEvent.Handler {
    interface Binder extends UiBinder<Widget, QuestionView> {
    }

    @UiField
    Image answer1Image;
    @UiField
    Image answer2Image;
    @UiField
    Image answer3Image;
    @UiField
    ParagraphElement question;
    @UiField
    DivElement quizFinished;
    @UiField
    DivElement questions;
    @UiField
    SpanElement questionNumber;

    private final QuizMessages quizMessages;
    private final AppResources resources;

    @Inject
    QuestionView(
            Binder binder,
            QuizMessages quizMessages,
            AppResources resources) {
        this.quizMessages = quizMessages;
        this.resources = resources;

        initWidget(binder.createAndBindUi(this));

        asWidget().addAttachHandler(this);
    }

    @Override
    public void setQuestion(int questionNumber) {
        setQuestionsVisible(true);

        question.setInnerText(quizMessages.question(questionNumber));
        this.questionNumber.setInnerText(String.valueOf(questionNumber));

        $(answer1Image).attr("title", quizMessages.answer1(questionNumber));
        $(answer2Image).attr("title", quizMessages.answer2(questionNumber));
        $(answer3Image).attr("title", quizMessages.answer3(questionNumber));

        destroyTooltips();
        createTooltips();
    }

    @Override
    public void setQuizFinished() {
        setQuestionsVisible(false);
    }

    @Override
    public void onAttachOrDetach(AttachEvent attachEvent) {
        if (attachEvent.isAttached()) {
            createTooltips();
        } else {
            destroyTooltips();
        }
    }

    @UiHandler("nextButton")
    void onNext(ClickEvent event) {
        getUiHandlers().onNextQuestion();
    }

    @UiHandler("tryAgain")
    void onTryAgain(ClickEvent event) {
        getUiHandlers().resetQuiz();
    }

    @UiHandler("share")
    void onShare(ClickEvent event) {
        getUiHandlers().share();
    }

    private void setQuestionsVisible(boolean questionsVisible) {
        $(quizFinished).toggleClass(resources.style().hidden(), questionsVisible);
        $(questions).toggleClass(resources.style().hidden(), !questionsVisible);
    }

    private void destroyTooltips() {
        $("[title]", asWidget()).as(Tooltip).destroy();
    }

    private void createTooltips() {
        TooltipOptions options = new TooltipOptions()
                .withDelayHide(100)
                .withDelayShow(200)
                .withPlacement(TooltipOptions.TooltipPlacement.RIGHT);
        $("[title]", asWidget()).as(Tooltip).tooltip(options);
    }
}
