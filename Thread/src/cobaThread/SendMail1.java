/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cobaThread;

/**
 *
 * @author ASUS
 */
import java.io.UnsupportedEncodingException;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;


public class SendMail1 implements Runnable {
        
        final String username = "thtpbo@gmail.com";
        final String password = "auldianindah";
        String subject;
        
    public static void main(String[] args) {
           for (int i=0;i<3;i++) {
            SendMail1 mail = new SendMail1 ();
            mail.setSubject("Test Email Thread " + i);
            Thread tr = new Thread (mail);
            tr.start();   
           }
    }
    
    public String setSubject (String sub) {
        return this.subject=sub;       
    }
    
    public void send () {
        
        Properties props = new Properties();
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");

        Session session = Session.getInstance(props,
          new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, password);
            }
          });
        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress("thtpbo@gmail.com"));
            message.setRecipients(Message.RecipientType.TO,
                InternetAddress.parse("auliyaaqma@gmail.com, auliya.aqma.tif16@polban.ac.id, nurindah.yuniarti.tif16@polban.ac.id, putri.dian.tif16@polban.ac.id"));
            
                message.setSubject(subject);
                message.setText("Semangat"
                + "\n\n Pasti Bisa!");

            Transport.send(message);
            
            
            
            System.out.println("Done");

        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }      
    }
    
    @Override
    public void run() {
       this.send();
    }
}
