package com.arcbees.hive.client.application.home;

import com.gwtplatform.mvp.client.HasSlots;
import com.gwtplatform.mvp.client.UiHandlers;

public interface HomeUiHandlers extends HasSlots, UiHandlers {
    void resize(int adjustedOffset);
}
