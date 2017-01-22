package ua.nure.jernovaya.SummaryTask4.mail;

import javax.mail.Session;
import org.apache.log4j.Logger;

import ua.nure.jernovaya.SummaryTask4.mail.MailSettings;
import ua.nure.jernovaya.SummaryTask4.mail.SettingsFactory;
import ua.nure.jernovaya.SummaryTask4.mail.Sender;
/**
 * 
 * @author Elmira Jernovaya.
 *
 */
public final class SessionUtil {
	/** Logger. */
	private static final Logger LOGGER = Logger.getLogger(SessionUtil.class);
	private static Session session = null;

	/**
	 * Constructor.
	 */
	private SessionUtil() {
		throw new UnsupportedOperationException("non instance SessionUtil");
	}

	/**
	 * Returns the session of e-mail.
	 *
	 * @return the {@link Session}.
	 */
	public static Session getSession() {
		if (session == null) {
			MailSettings settings = SettingsFactory
					.getMailSettings("gmail");
			Sender sender = new Sender();
			sender.setLogin("dandirector1147@gmail.com");
			sender.setPassword("qawsed47");
			session = settings.getSession(sender);
		}
		LOGGER.info("getSession done");
		return session;
	}
}
