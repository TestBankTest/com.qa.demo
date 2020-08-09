package com.qa.testutil;

import com.qa.base.Base;
import org.apache.commons.mail.*;

public class EmailUtil extends Base {

    Email email;
    EmailAttachment emailAttachment;
    MultiPartEmail multiPartEmail;
    public void sendNormalMail(){
        try {
            email = new SimpleEmail();
            email.setHostName("smtp.gmail.com");
            email.setSmtpPort(465);
            email.setAuthenticator(new DefaultAuthenticator("testappium003@gmail.com", "Password@123"));
            email.setSSLOnConnect(true);
            email.setFrom("testappium003@gmail.com");
            email.setSubject("TestMail");
            email.setMsg("This is a test mail ... :-)");
            email.addTo("surajkadav21@gmail.com");
            email.send();
        }catch (Exception ae){
            ae.printStackTrace();
        }
    }

    public void sendMailWithAttachment(){
        try{
            emailAttachment = new EmailAttachment();
            emailAttachment.setPath(testReportUtil.getTestReportFilePath());
            emailAttachment.setDisposition(EmailAttachment.ATTACHMENT);

            multiPartEmail = new MultiPartEmail();
            multiPartEmail.setHostName("smtp.gmail.com");
            multiPartEmail.setAuthenticator(new DefaultAuthenticator("testappium003@gmail.com", "Password@123"));
            multiPartEmail.setSSLOnConnect(true);
            multiPartEmail.addTo("surajkadav21@gmail.com", "John Doe");
            multiPartEmail.setFrom("testappium003@gmail.com", "Me");
            multiPartEmail.setSubject("Test Report");
            multiPartEmail.setMsg("Please find test report in the attachment section");
            multiPartEmail.attach(emailAttachment);
            multiPartEmail.send();
        }catch (Exception exception){
            exception.printStackTrace();
        }
    }



}
