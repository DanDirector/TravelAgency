/**
 * 
 */
package ua.nure.jernovaya.SummaryTask4.commands;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import ua.nure.jernovaya.SummaryTask4.dao.UserDAO;
import ua.nure.jernovaya.SummaryTask4.entity.Role;
import ua.nure.jernovaya.SummaryTask4.entity.User;
import ua.nure.jernovaya.SummaryTask4.jdbc.Sqls;
import ua.nure.jernovaya.SummaryTask4.validators.Validator;

/**
 * @author Elmira Jernovaya.
 *
 */
public class UsersUpdateCommand implements Command {
	/**
	 * Logger.
	 */
	private static final Logger LOGGER = Logger.getLogger(UsersUpdateCommand.class);
	UserDAO dao = new UserDAO();

	/**
	 * (non-Javadoc)
	 * 
	 * @see ua.nure.jernovaya.SummaryTask4.commands.Command#execute(javax.servlet.http.HttpServletRequest,
	 *      javax.servlet.http.HttpServletResponse)
	 */
	@Override
	public void execute(HttpServletRequest req, HttpServletResponse res) {
		String set = req.getParameter("set");
		String idStr = req.getParameter("id");
		if (idStr != null && Validator.isInteger(idStr)) {
			int id = Integer.parseInt(idStr);
			User user = dao.read(id);
			if (user != null) {

				switch (set) {
				case "man":
					user.setRole(Role.MANAGER);
					break;
				case "block":
					user.setRole(Role.BLOCKED);
					break;
				case "unblock":
					user.setRole(Role.CLIENT);
					break;
				default:
					break;
				}
				dao.update(user, Sqls.UPDATE_USER);
			}
		}
		try {
			res.sendRedirect("Controller?com=users");
		} catch (IOException e) {
			LOGGER.error(e.getMessage());
		}

	}

}
