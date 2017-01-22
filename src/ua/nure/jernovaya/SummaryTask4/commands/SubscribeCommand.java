/**
 * 
 */
package ua.nure.jernovaya.SummaryTask4.commands;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.log4j.Logger;

import ua.nure.jernovaya.SummaryTask4.dao.SubscriberDao;
import ua.nure.jernovaya.SummaryTask4.entity.Subscriber;

/**
 * @author Elmira Jernovaya.
 *
 */
public class SubscribeCommand implements Command {
	SubscriberDao ssDao = new SubscriberDao();
	/**
	 * Logger.
	 */
	private static final Logger LOGGER = Logger.getLogger(SubscribeCommand.class);

	/**
	 * (non-Javadoc)
	 * 
	 * @see ua.nure.jernovaya.SummaryTask4.commands.Command#execute(javax.servlet.
	 *      http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */
	@Override
	public void execute(HttpServletRequest req, HttpServletResponse res) {
		String email = req.getParameter("email");
		Subscriber ss = new Subscriber();
		ss.setEmail(email);

		if (ssDao.create(ss)) {

			res.setContentType("text/plain");
			res.setCharacterEncoding("UTF-8");
			try {
				res.getWriter().write("Вы успешно подписались!");
			} catch (IOException e) {
				LOGGER.error(e.getMessage());
			}
		} else {
			res.setContentType("text/plain");
			res.setCharacterEncoding("UTF-8");
			try {
				res.getWriter().write("Произошла ошибка!");
			} catch (IOException e) {
				LOGGER.error(e.getMessage());
			}
		}
		
	}

}
