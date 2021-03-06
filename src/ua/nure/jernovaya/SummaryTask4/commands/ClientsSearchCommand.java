/**
 * 
 */
package ua.nure.jernovaya.SummaryTask4.commands;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import ua.nure.jernovaya.SummaryTask4.dao.OrderDAO;
import ua.nure.jernovaya.SummaryTask4.dao.UserDAO;
import ua.nure.jernovaya.SummaryTask4.entity.Order;
import ua.nure.jernovaya.SummaryTask4.entity.User;

/**
 * @author Elmira Jernovaya.
 *
 */
public class ClientsSearchCommand implements Command {
	/**
	 * Logger.
	 */
	private static final Logger LOGGER = Logger.getLogger(HotTourCommand.class);
	OrderDAO orderDao = new OrderDAO();
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
		String client = req.getParameter("client");
		if (client != null) {
			String[] names = client.split("\\s");
			String name2 = "";
			if (names.length == 2) {
				name2 = names[1];
			}
			List<User> users = userDao.getUserBySecondName(names[0], name2);
			List<Order> list = new ArrayList<>();
			if (!users.isEmpty()) {
				User user = users.get(0);

				if (user != null) {
					list = orderDao.getOrdersOfUser(user);
				}
			}
			session.setAttribute("orders", list);
		}
		try {
			res.sendRedirect("admin.jsp");
		} catch (IOException e) {
			LOGGER.error(e.getMessage());
		}
	}

}
