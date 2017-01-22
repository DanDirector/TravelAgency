package ua.nure.jernovaya.SummaryTask4.mail;

import java.util.Properties;

import javax.mail.PasswordAuthentication;
import javax.mail.Session;

import ua.nure.jernovaya.SummaryTask4.mail.MailSettings;
import ua.nure.jernovaya.SummaryTask4.mail.Sender;
/**
 * 
 * @author Elmira Jernovaya.
 *
 */
public class GmailSettings implements MailSettings {


	@Override
	public Session getSession(final Sender sender) {
		Session session = Session.getDefaultInstance(getProperties(),
				new javax.mail.Authenticator() {
					@Override
					protected PasswordAuthentication getPasswordAuthentication() {
						return new PasswordAuthentication(sender.getLogin(), sender.getPassword());
					}
				});
		return session;
	}

	/**
	 * Returns properties for mail connection.
	 *
	 * @return the {@link Properties}.
	 */
	protected Properties getProperties() {
		Properties properties = new Properties();
		properties.put("mail.smtp.host", "smtp.gmail.com");
		properties.put("mail.smtp.socketFactory.port", "465");
		properties.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
		properties.put("mail.smtp.auth", "true");
		properties.put("mail.smtp.port", "465");
		properties.put("mail.smtp.ssl.trust", "smtp.gmail.com");
		return properties;
	}

}
