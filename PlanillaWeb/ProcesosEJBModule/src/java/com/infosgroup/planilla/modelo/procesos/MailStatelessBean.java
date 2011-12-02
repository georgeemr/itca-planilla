/*
* To change this template, choose Tools | Templates
* and open the template in the editor.
*/
package com.infosgroup.planilla.modelo.procesos;

import java.io.UnsupportedEncodingException;
import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import javax.mail.Message;
import javax.mail.Message.RecipientType;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
*
* @author root
*/
@Stateless(name = "MailStatelessBean")
@LocalBean
public class MailStatelessBean
{
// Add business logic below. (Right-click in editor and choose
// "Insert Code > Add Business Method")
@Resource(name = "mail/gmailSession")
private Session mailSession;

public void sendMessage()
{
Message msg = new MimeMessage(mailSession);
try
    {
    msg.setSubject("[app] Email Alert");
    msg.setRecipient(RecipientType.TO, new InternetAddress("email", "cuenta"));
    msg.setText("Hello usuario");
    Transport.send(msg);
    }
catch (MessagingException me)
    {
    // manage exception
    }
catch (UnsupportedEncodingException uee)
    {
    // manage exception
    }
}
}
