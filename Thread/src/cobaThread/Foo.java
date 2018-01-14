/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cobaThread;
import java.util.Properties;
import javax.mail.Session;
import javax.mail.Message;
import javax.mail.Transport;
import javax.mail.Authenticator;
import javax.mail.MessagingException;
import javax.mail.internet.InternetAddress;
import javax.mail.PasswordAuthentication;
import javax.mail.internet.MimeMessage;
import javax.swing.JOptionPane;
/**
 *
 * @author ASUS
 */

public class MailMachine implements Runnable{ 
        
        String user, pass;
        
        Properties props = new Properties();
      
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");	
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        
        Session session = Session.getDefaultInstance(props,new Authenticator() 
        {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() 
            {
                return new PasswordAuthentication(user, pass);
            }
        });
        EmailAddressServer eas; 
         EmailMessageServer ems; 
         ... 
         List<String> emailAddresses = eas.getAddresses(); 
         ... 
         //set up mail session 
         Session session = Session.getInstance(properties); 
         ... 

         public void run(){ 
                for(String email: emailAddresses){ 
                         MimeMessage message = new MimeMessage(session); 
                         String msg = ems.getMessage(email); //whatever 
                        //blocking IO 
                         ... 
                        Transport.send(message); 
                         ... 
                 } 
         } 
} 

public class Foo {
    public static void main (String [] args) { 
                MailMachine mm = new MailMachine(); 
                Thread t = new Thread(mm); 
                t.start(); 

    } 
}
