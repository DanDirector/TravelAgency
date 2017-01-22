package ua.nure.jernovaya.SummaryTask4.mail;

import javax.mail.Session;

/**
 * 
 * @author Elmira Jernovaya.
 *
 */
public interface MailSettings {

	Session getSession(Sender sender);
}
