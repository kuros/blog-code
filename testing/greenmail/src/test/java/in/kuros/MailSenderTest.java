package in.kuros;

import com.icegreen.greenmail.util.GreenMail;
import com.icegreen.greenmail.util.ServerSetup;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import javax.mail.internet.MimeMessage;

public class MailSenderTest {

    private GreenMail greenMailServer;
    private MailSender mailSender;

    @Before
    public void setUp() {
        greenMailServer = new GreenMail(new ServerSetup(9000, "localhost", ServerSetup.PROTOCOL_SMTP));
        greenMailServer.start();

        mailSender = new MailSender();
    }

    @Test
    public void shouldSendMailToEmailServer() throws Exception {
        final String fromUser = "foo@test.com";
        final String toUser = "foo@test.com";
        greenMailServer.setUser(fromUser, fromUser);
        greenMailServer.setUser(toUser, toUser);

        final ServerInfo serverInfo = new ServerInfo("localhost", "9000");
        final String subject = "this is the subject";
        final String message = "this is message body";
        final MailContext mailContext = new MailContext(fromUser, toUser, subject, message);
        mailSender.sendMail(serverInfo, mailContext);

        final MimeMessage[] receivedMessages = greenMailServer.getReceivedMessages();
        Assert.assertEquals(1, receivedMessages.length);
        Assert.assertEquals(subject, receivedMessages[0].getSubject());
        Assert.assertEquals(message , String.valueOf(receivedMessages[0].getContent()).trim());


    }

    @After
    public void tearDown() {
        greenMailServer.start();
    }
}