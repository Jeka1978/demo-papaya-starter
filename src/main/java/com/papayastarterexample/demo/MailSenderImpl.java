package com.papayastarterexample.demo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

/**
 * @author Evgeny Borisov
 */

public class MailSenderImpl implements MailSender {


//    @Value("${dba.mails}")
    //todo this mails should come from the application.proerties of real project, who uses the starter
    private String[] mails = {"egor","ivan"};

    @Override
    public void sendMailToDba(Exception ex) {
        for (String mail : mails) {
            System.out.println("sending mail to "+mail+": "+ex.getMessage());
        }
    }
}
