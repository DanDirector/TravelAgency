/**
 * 
 */
package ua.nure.jernovaya.SummaryTask4.commands;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import ua.nure.jernovaya.SummaryTask4.dao.UserDAO;
import ua.nure.jernovaya.SummaryTask4.entity.User;
import ua.nure.jernovaya.SummaryTask4.validators.Validator;

/**
 * @author Elmira Jernovaya.
 *
 */
public class LogInCommand implements Command {
	/**
	 * Logger.
	 */
	private static final Logger LOGGER = Logger.getLogger(LogInCommand.class);
	UserDAO userDao = new UserDAO();

	/**
	 * (non-Javadoc)
	 * 
	 * @see ua.nure.jernovaya.SummaryTask4.commands.Command#execute(javax.servlet.http.HttpServletRequest,
	 *      javax.servlet.http.HttpServletResponse)
	 */
	@Override
	public void execute(HttpServletRequest req, HttpServletResponse res) {
		HttpSession session = req.getSession();
		String login = req.getParameter("login");
		String pass = req.getParameter("password");
		if (!Validator.isNull(login, pass)) {
			User user = userDao.read(login, pass);
			if (user != null) {
				send(user, session, res);
			} else {
				try {
					session.setAttribute("wrong", "wrong1");
					res.sendRedirect("login.jsp");
				} catch (IOException e) {
					LOGGER.error(e.getMessage());
				}
			}
		} else {
			try {
				res.sendRedirect("login.jsp");
			} catch (IOException e) {
				LOGGER.error(e.getMessage());
			}
		}

	}

	/**
	 * choose redirect depended on user's role.
	 * 
	 * @param user
	 * @param session
	 * @param res
	 */
	void send(User user, HttpSession session, HttpServletResponse res) {
		switch (user.getRole()) {
		case CLIENT:
			session.setAttribute("user", user);
			try {

				res.sendRedirect("index.jsp");

			} catch (IOException e) {
				LOGGER.error(e.getMessage());
			}
			break;

		case MANAGER:
			session.setAttribute("user", user);
			try {
				res.sendRedirect("Controller?com=manager");
			} catch (IOException e) {
				LOGGER.error(e.getMessage());
			}
			break;
		case ADMIN:
			session.setAttribute("user", user);
			try {
				res.sendRedirect("Controller?com=admin");
			} catch (IOException e) {
				LOGGER.error(e.getMessage());
			}
			break;
		case BLOCKED:
			try {
				session.setAttribute("wrong", "wrong2");
				res.sendRedirect("login.jsp");
			} catch (IOException e) {
				LOGGER.error(e.getMessage());
			}
			break;

		default:
			try {
				res.sendRedirect("login.jsp");
			} catch (IOException e) {
				LOGGER.error(e.getMessage());
			}
			break;
		}
	}

}
