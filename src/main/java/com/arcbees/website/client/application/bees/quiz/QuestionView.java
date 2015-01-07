package com.arcbees.website.client.application.bees.quiz;

import javax.inject.Inject;

import com.arcbees.gquery.tooltip.client.TooltipOptions;
import com.arcbees.website.client.resources.PageBeesResources;
import com.google.gwt.dom.client.ParagraphElement;
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

public class QuestionView extends ViewWithUiHandlers<QuestionUiHandlers> implements QuestionPresenter.MyView, AttachEvent.Handler {
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

    private final PageBeesResources.QuizMessages quizMessages;

    @Inject
    QuestionView(
            Binder binder,
            PageBeesResources.QuizMessages quizMessages) {
        this.quizMessages = quizMessages;

        initWidget(binder.createAndBindUi(this));

        asWidget().addAttachHandler(this);
    }

    @Override
    public void setQuestion(int questionNumber) {
        question.setInnerText(quizMessages.question(questionNumber));

        $(answer1Image).attr("title", quizMessages.answer1(questionNumber));
        $(answer2Image).attr("title", quizMessages.answer2(questionNumber));
        $(answer3Image).attr("title", quizMessages.answer3(questionNumber));
        destroyTooltips();
        createTooltips();
    }

    @Override
    public void setQuizFinished() {
        // todo: show a different content div for the finished state
    }

    @Override
    public void onAttachOrDetach(AttachEvent attachEvent) {
        if (attachEvent.isAttached()) {
            createTooltips();
        } else {
            destroyTooltips();
        }
    }

    private void destroyTooltips() {
        $("[title]").as(Tooltip).destroy();
    }

    private void createTooltips() {
        TooltipOptions options = new TooltipOptions()
                .withDelayHide(100)
                .withDelayShow(200)
                .withPlacement(TooltipOptions.TooltipPlacement.RIGHT);
        $("[title]").as(Tooltip).tooltip(options);
    }

    @UiHandler("nextButton")
    void onNext(ClickEvent event) {
        getUiHandlers().onNextQuestion();
    }
}
