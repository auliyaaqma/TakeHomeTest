/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package email;
import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.SimpleEmail;
/**
 *
 * @author ASUS
 */
public class SendSimpleEmail {
    public static void main(String[] args) throws EmailException {
 
        SimpleEmail email = new SimpleEmail();
 
        /*** konfigurasi ***/
        email.setHostName("smtp.googlemail.com");
        email.setSmtpPort(465);
        email.setAuthenticator(new DefaultAuthenticator("username", "password"));
        email.setSSLOnConnect(true);
 
        /*** Email pengirim ***/
        email.setFrom("blinkawan@gmail.com");
 
        /*** Email Tujuan ***/
        email.addTo("blink_boyz_26@yahoo.com");
 
        /*** Subjek Email ***/
        email.setSubject("Tes Kirim Email");
 
        /*** Isi Pesan ***/
        email.setMsg("Lagi Belajar Mengirim Email Lewat Java");
 
        /*** Mengirim Email ***/
        email.send();
    }
}
