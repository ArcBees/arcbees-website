package com.arcbees.hive.shared.dispatch;

import com.arcbees.hive.shared.ActionImpl;
import com.arcbees.hive.shared.NoResult;

public class SendMail extends ActionImpl<NoResult> {
    private String senderEmail;
    private String contents;
    private String senderName;

    private SendMail() {
    }

    public SendMail(String senderEmail, String senderName, String contents) {
        this.senderEmail = senderEmail;
        this.contents = contents;
        this.senderName = senderName;
    }

    public String getSenderEmail() {
        return senderEmail;
    }

    public String getContents() {
        return contents;
    }

    public String getSenderName() {
        return senderName;
    }
}
