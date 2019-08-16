/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Send_MailGmail;

import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 *
 * @author Roberto
 */
class send_mailOperacion {

    public String Envia_correo_evaluacion(String Destino, String texto, String Titulo) {
        String Mensaje = "Ok";
        final String username = "encuesta@uab.edu.bo";
        final String password = "dctqawdunrifzbfx";

        Properties prop = new Properties();
        prop.put("mail.smtp.host", "smtp.gmail.com");
        prop.put("mail.smtp.port", "587");
        prop.put("mail.smtp.auth", "true");
        prop.put("mail.smtp.starttls.enable", "true"); //TLS

        Session session = Session.getInstance(prop,
                new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, password);
            }
        });
        try {

            Message message = new MimeMessage(session);
            //message.setFrom(new InternetAddress("carlosrobertomarca@gmail.com"));
            message.setRecipients(
                    Message.RecipientType.TO,
                    InternetAddress.parse(Destino)
            );
            message.setSubject(Titulo);
            //message.setText(texto);
            message.setContent(texto,"text/html");

            Transport.send(message);

            System.out.println("Enviado");

        } catch (MessagingException e) {
            Mensaje = "Error Al enviar a " + Destino;
            e.printStackTrace();
        }
        return Mensaje;
    }

}
