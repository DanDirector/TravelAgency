package ua.nure.jernovaya.SummaryTask4.mail;

import ua.nure.jernovaya.SummaryTask4.mail.GmailSettings;
/**
 * 
 * @author Elmira Jernovaya.
 *
 */
public final class SettingsFactory {
	public static final String GMAIL = "gmail";

	private SettingsFactory() {
		throw new UnsupportedOperationException("non instance SettingsFactory");
	}

	public static MailSettings getMailSettings(final String factory) {
		switch (factory) {
		case GMAIL:
			return new GmailSettings();
		default:
			throw new IllegalArgumentException("implementation is not found");
		}
	}
}
