/**
 * 
 */
package ua.nure.jernovaya.SummaryTask4.commands;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import ua.nure.jernovaya.SummaryTask4.dao.SubscriberDao;
import ua.nure.jernovaya.SummaryTask4.entity.Subscriber;
import ua.nure.jernovaya.SummaryTask4.mail.MailSender;
import ua.nure.jernovaya.SummaryTask4.mail.SessionUtil;

/**
 * @author Elmira Jernovaya.
 *
 */
public class SendMailCommand implements Command {
	/**
	 * Logger.
	 */
	private static final Logger LOGGER = Logger.getLogger(SendMailCommand.class);
	SubscriberDao ssDao = new SubscriberDao();

	/**
	 * (non-Javadoc)
	 * 
	 * @see
	 * ua.nure.jernovaya.SummaryTask4.commands.Command#execute(javax.servlet.
	 * http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */
	@Override
	public void execute(HttpServletRequest req, HttpServletResponse res) {
		String theme = req.getParameter("theme");
		String message = req.getParameter("message");

		List<Subscriber> list = ssDao.getAll();
		if (list != null) {

			for (Subscriber subscriber : list) {
				new MailSender(SessionUtil.getSession(), theme, message, subscriber.getEmail()).run();
			}
		}

		try {
			res.sendRedirect("Controller?com=manager");
		} catch (IOException e) {
			LOGGER.error(e.getMessage());
		}
	}

}
