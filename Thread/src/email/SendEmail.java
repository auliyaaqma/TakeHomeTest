/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package email;
import java.util.*;
import javax.mail.*;
import javax.mail.internet.*;
import javax.mail.internet.MimeMessage;
/**
 *
 * @author ASUS
 */
public class SendEmail {
    public static void main (String args[]) {
        try {
        String host = "smtp.gmail.com";
        String user = "thtpbo@gmail.com";
        String pass = "auldianindah";
        String to = "auliya.aqma.tif16@polban.ac.id";
        String from = "thtpbo@gmail.com";
        String subject = "this is confirmation";
        String messageText = "Your Is Test Email";
        boolean sessionDebug = false;
        
        Properties props = System.getProperties();
        
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", host);
        props.put("mail.smtp.port", "587");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.required", "true");

        java.security.Security.addProvider(new com.sun.net.ssl.internal.ssl.Provider());
        Session mailSession = Session.getDefaultInstance(props, null);
        mailSession.setDebug(sessionDebug);
        Message msg = new MimeMessage(mailSession);
        msg.setFrom(new InternetAddress(from));
        InternetAddress[] address = {new InternetAddress(to)};
        msg.setRecipients(Message.RecipientType.TO, address);
        msg.setSubject(subject); msg.setSentDate(new Date());
        msg.setText(messageText);
        
        Transport transport = mailSession.getTransport("smtp");
        System.out.println("CONNECT");
        transport.connect(host, user, pass);
        transport.sendMessage(msg, msg.getAllRecipients());
        transport.close();
        System.out.println("Message send succesfully");
                } catch (Exception ex) {
                    System.out.println("error : " + ex);
                }
    }
}
