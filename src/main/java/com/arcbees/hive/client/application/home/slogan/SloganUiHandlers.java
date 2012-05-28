package com.arcbees.hive.client.application.home.slogan;

import com.gwtplatform.mvp.client.UiHandlers;

/**
 * {@link SloganView}'s UiHandlers.
 *
 * @see com.arcbees.hive.client.application.home.slogan.SloganPresenter#showDescription()
 */
public interface SloganUiHandlers extends UiHandlers {
    void showConsultingSection();

    void showDevelopmentSection();

    void showSuccessStorySection();
}
