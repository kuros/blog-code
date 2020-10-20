package in.kuros;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

public class MailSender {

        public void sendMail(final ServerInfo serverInfo, final MailContext context) {

            Properties properties = new Properties();
            properties.setProperty("mail.smtp.host", serverInfo.getHost());
            properties.setProperty("mail.smtp.port", serverInfo.getPort());

            Session session = Session.getDefaultInstance(properties);

            try {
                MimeMessage message = new MimeMessage(session);
                message.setFrom(new InternetAddress(context.getFrom()));
                message.addRecipient(Message.RecipientType.TO, new InternetAddress(context.getTo()));
                message.setSubject(context.getSubject());
                message.setText(context.getMessage());
                // Send message
                Transport.send(message);
                System.out.println("Sent message successfully....");
            } catch (MessagingException mex) {
                mex.printStackTrace();
            }
        }
}
