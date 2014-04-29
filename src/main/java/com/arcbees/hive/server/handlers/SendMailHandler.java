package com.arcbees.hive.server.handlers;

import java.io.UnsupportedEncodingException;
import java.util.Properties;

import javax.inject.Inject;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import com.arcbees.hive.shared.NoResult;
import com.arcbees.hive.shared.dispatch.SendMail;
import com.gwtplatform.dispatch.rpc.server.ExecutionContext;
import com.gwtplatform.dispatch.shared.ActionException;

public class SendMailHandler extends AbstractActionHandler<SendMail, NoResult> {

    @Inject
    public SendMailHandler() {
        super(SendMail.class);
    }

    /*
    * Don't forget to add a dependency to appengine-api-1.0-sdk, in order to send the e-mails succesfully
    * */
    @Override
    public NoResult execute(SendMail action, ExecutionContext context) throws ActionException {
        String senderEmail = action.getSenderEmail();
        String contents = action.getContents();
        String senderName = action.getSenderName();

        Properties properties = new Properties();
        Session session = Session.getDefaultInstance(properties, null);

        Message message = new MimeMessage(session);
        try {
            message.setFrom(new InternetAddress("queenbee@arcbees.com", "ArcBees Website Contact Form"));
            message.addRecipient(Message.RecipientType.TO, new InternetAddress("queenbee@arcbees.com"));
            message.setSubject("Sender's email: " + senderEmail + ", sender's name: " + senderName);
            message.setText(contents);

            Transport.send(message);
        } catch (MessagingException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return new NoResult();
    }
}
