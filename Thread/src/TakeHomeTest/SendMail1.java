/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TakeHomeTest;

/**
 *
 * @author ASUS
 */

import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;


public class SendMail1 implements Runnable { // didalam kelas sendemail mengimplementasi kan beberapa fungsi yang ada di dalam interface runnable
        // 
        final String username = "thtpbo@gmail.com"; // deklarasi email pengirim pesan
        final String password = "auldianindah"; // deklarasi password email pengirim pesan
        String subject;
        String to = "auliya.aqma.tif16@polban.ac.id, nurindah.yuniarti.tif16@polban.ac.id, putri.dian.tif16@polban.ac.id";
        String pesan = "Hi " + to +
                        "\n\nAnda mendapatkan undangan dari " + username + 
                        " untuk mendaftar sebagai user di Portal Tenaga Kerja di PT. Oil & Gas." +
                        "\n\nTalentpool Oil & Gas merupakan database pekerja profesional Indonesia di Industri minyak dan gas bumi yang dikembangkan oleh PT.Oil & Gas untuk menjembatani Proyek-Proyek Migas dengan para profesional nasional di industri minyak dan gas bumi baik yang bekerja di dalam negeri maupun di luar negeri.\n\nPortal talentpool ini diharapkan dapat membantu para profesional Indonesia yang ingin mengabdikan dirinya sesuai dengan bidang keahliannya masing-masing dalam pembangunan proyek-proyek migas nasional guna meningkatkan kemandirian bangsa dan ketahanan energi nasional.";
        
    public static void main(String[] args) { 
           for (int i=0;i<3;i++) { // pengulangan pengiriman email. 
            SendMail1 mail = new SendMail1 (); // membuat object mail di dalam method SendEmail.
            mail.setSubject("Undangan  PT. Oil & Gas " + i); // setiap subject yang terkirim bertambah 1 dan akan sesuai sesuai pengulangan.
            Thread tr = new Thread (mail); // object mail menerapkan Thread dan membuat object tr 
            tr.start(); // thread di mulai   
           }
    }
    
    public String setSubject (String sub) { // untuk menampung subject karena subject harus berbeda- beda.
        return this.subject=sub;       // 
    }
    
    public void send () { // menthod send () dimana di dalamnya mengimplementasikan  
        
        Properties props = new Properties();
        props.put("mail.smtp.starttls.enable", "true"); 
        props.put("mail.smtp.auth", "true"); // Authentikasi : mengisyaratkan Java Mail untuk melakukan authentikasi menggunakan username dan password untuk account email yang bersangkutan.
        props.put("mail.smtp.host", "smtp.gmail.com"); // Alamat host SMTP
        props.put("mail.smtp.port", "587");

        Session session = Session.getInstance(props,
          new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, password);
            }
          });
        
        try {
            Message message = new MimeMessage(session); // membuat object baru  (message)
            message.setFrom(new InternetAddress("thtpbo@gmail.com")); // email pengirim
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to)); //email penerima email(pesan)
            
            message.setSubject(subject); // mengisi subject pada email yang akan di kirim
            message.setText(pesan); // pesan atau isi yang akan di kirimkan kepada penerima email

            Transport.send(message); // mengirimkan pesan 
          
            System.out.println("Email Terkirim"); // status yang akan di tampilkan jika pesan berhasil di kirimkan.

        } catch (MessagingException e) {
            throw new RuntimeException(e); // batasan waktu dalam memperoses pengiriman pesan, jika proses terjadi melebihi waktu makan proses dinyatakan gagal
        }      
    }
    
    @Override
    public void run() { // menjalanan method run untuk mengirim email 
       this.send();
    }
}
