/**
 * 
 */
package ua.nure.jernovaya.SummaryTask4.commands;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

/**
 * @author Elmira Jernovaya.
 *
 */
public class LogOutCommand implements Command {
	/**
	 * Logger.
	 */
	private final static Logger LOGGER = Logger.getLogger(LogOutCommand.class);

	/**
	 * (non-Javadoc)
	 * 
	 * @see ua.nure.jernovaya.SummaryTask4.commands.Command#execute(javax.servlet.http.HttpServletRequest,
	 *      javax.servlet.http.HttpServletResponse)
	 */
	@Override
	public void execute(HttpServletRequest req, HttpServletResponse res) {
		HttpSession session = req.getSession();
		session.setAttribute("user", null);
		try {
			res.sendRedirect("login.jsp");
		} catch (IOException e) {
			LOGGER.error(e.getMessage());
		}
	}

}
