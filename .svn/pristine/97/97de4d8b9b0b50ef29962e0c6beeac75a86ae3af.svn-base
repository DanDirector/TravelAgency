package ua.nure.jernovaya.SummaryTask4.mail;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.apache.log4j.Logger;
/**
 * 
 * @author Elmira Jernovaya.
 *
 */
public class MailSender{
	/**
	 * Logger.
	 */
	private static final Logger LOGGER = Logger.getLogger(MailSender.class);
	private Session session;
	private String recipient;
	private String subject;
	private String content;

	public MailSender(Session session, String subject, String content,
			String recipient) {
		
		this.session = session;
		this.subject = subject;
		this.content = content;
		this.recipient = recipient;
	}

	
	public void run() {
		try {
			Message msg = new MimeMessage(session);
			msg.setRecipient(Message.RecipientType.TO, new InternetAddress(recipient));
			msg.setSubject(subject);
			msg.setText(content);
			Transport.send(msg);
		} catch (AddressException e) {
			LOGGER.error("AddressException error", e);
		} catch (MessagingException e) {
			LOGGER.error("MessagingException", e);
		}
		LOGGER.info("mail is sent");
	}
	
}
