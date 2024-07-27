/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Backend;

import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

/**
 *
 * @author kaust
 */
public class Mail {
    User user;
    
    Session newSession;
    MimeMessage mimeMessage;
    Mail mail;
    
    public Mail() {
        
    }

    private void sendEmail() throws MessagingException {
        String fromUser = "*************"; //Add your own email
        String fromUserPassword = "***************"; //Added my own app password from google
        String emailHost = "smtp.gmail.com";
        Transport transport = newSession.getTransport("smtp");
        transport.connect(emailHost, fromUser, fromUserPassword);
        transport.sendMessage(mimeMessage, mimeMessage.getAllRecipients());
        System.out.println("Sent message!");
        transport.close();
    }

    private MimeMessage draftEmail() throws AddressException, MessagingException {
        String emailReciepient = this.user.getEmail();
        String emailBody = "Your activation code for Kaustubh's Project: " + this.user.getActivationCode();
        String emailSubject = "Kaustubh's Project Activation Code";
        mimeMessage = new MimeMessage(newSession);
        
        mimeMessage.addRecipient(Message.RecipientType.TO, new InternetAddress(emailReciepient));
        mimeMessage.setSubject(emailSubject);
        MimeMultipart multiPart = new MimeMultipart();
        
        MimeBodyPart bodyPart = new MimeBodyPart();
        bodyPart.setContent(emailBody, "text/html");
        multiPart.addBodyPart(bodyPart);
        mimeMessage.setContent(multiPart);
        return mimeMessage;        
    }

    private void setupServerProperties() {
        Properties properties = System.getProperties();
        properties.put("mail.smtp.port", "587");
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true");
        newSession = Session.getDefaultInstance(properties, null);
    }
    
    public void sendMessage(User user) throws MessagingException {
        this.user = user;
        setupServerProperties();
        draftEmail();
        sendEmail();
    }
    
}
