package org.estoque.Present.CadastrarUsuario;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

public class NotificationCreateAccount {
    private final String supportMail = "seu_email@gmail.com";
    private final String smtpHost = "smtp.gmail.com";
    private final int smtpPort = 587;
    private final String smtpUsername = "camposdlucasoli@gmail.com";
    private final String smtpPassword = "kwqjsnlelyhchkzp";


    public void sendWelcomeEmail(String email, String nomeUsuario) throws MessagingException {
        String subject = "Bem-vindo ao Nosso Sistema!";
        String content = "Olá " + nomeUsuario + ",<br><br>"
                + "Bem-vindo ao nosso sistema! Agradecemos por se cadastrar.<br>"
                + "Agora você faz parte da nossa comunidade.<br><br>"
                + "Atenciosamente,<br>"
                + "Equipe do Nosso Sistema";

        setMailSenderClient(subject, email, content, nomeUsuario);
    }
    private void setMailSenderClient(String subject, String recipient, String emailContent, String nomeUsuario) throws MessagingException {
        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", smtpHost);
        props.put("mail.smtp.port", smtpPort);

        Session session = Session.getInstance(props, new Authenticator() {
            protected javax.mail.PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(smtpUsername, smtpPassword);
            }
        });
        MimeMessage message = new MimeMessage(session);
        message.setSubject(subject);
        message.setFrom(new InternetAddress(supportMail));
        message.setRecipient(Message.RecipientType.TO, new InternetAddress(recipient));

        String emailContentWithUsername = emailContent + "<p>Nome do Usuário: <strong>" + nomeUsuario + "</strong></p>";

        message.setContent(emailContentWithUsername, "text/html");

        Transport.send(message);
        System.out.println("Email enviado com sucesso!");
    }

}
