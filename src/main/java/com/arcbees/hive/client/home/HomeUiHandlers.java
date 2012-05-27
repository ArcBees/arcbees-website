package com.arcbees.hive.client.home;

import com.gwtplatform.mvp.client.HasSlots;
import com.gwtplatform.mvp.client.UiHandlers;

/**
 * {@link HomeView}'s {@link com.gwtplatform.mvp.client.UiHandlers}.
 */
public interface HomeUiHandlers extends HasSlots, UiHandlers {
    void resize(int adjustedOffset);
}
