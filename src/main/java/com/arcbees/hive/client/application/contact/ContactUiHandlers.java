package com.arcbees.hive.client.application.contact;

import com.gwtplatform.mvp.client.UiHandlers;

public interface ContactUiHandlers extends UiHandlers {
    void sendMail(String sender, String contents);
}
