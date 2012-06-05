package com.arcbees.hive.shared.dispatch;

import com.arcbees.hive.shared.ActionImpl;
import com.arcbees.hive.shared.NoResult;

public class SendMail extends ActionImpl<NoResult> {
    private String sender;
    private String contents;

    private SendMail() {
    }

    public SendMail(String sender, String contents) {
        this.sender = sender;
        this.contents = contents;
    }

    public String getSender() {
        return sender;
    }

    public String getContents() {
        return contents;
    }
}
