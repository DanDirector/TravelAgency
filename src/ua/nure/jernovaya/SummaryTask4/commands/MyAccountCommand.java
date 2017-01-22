package ua.nure.jernovaya.SummaryTask4.commands;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import ua.nure.jernovaya.SummaryTask4.dao.OrderDAO;
import ua.nure.jernovaya.SummaryTask4.entity.Order;
import ua.nure.jernovaya.SummaryTask4.entity.User;

/**
 * 
 * @author Elmira Jernovaya.
 *
 */
public class MyAccountCommand implements Command {
	/**
	 * Logger.
	 */
	private static final Logger LOGGER = Logger.getLogger(MyAccountCommand.class);
	OrderDAO orderDao = new OrderDAO();

	/**
	 * (non-Javadoc)
	 * 
	 * @see ua.nure.jernovaya.SummaryTask4.commands.Command#execute(javax.servlet.http.HttpServletRequest,
	 *      javax.servlet.http.HttpServletResponse)
	 */
	@Override
	public void execute(HttpServletRequest req, HttpServletResponse res) {
		HttpSession session = req.getSession();
		User user = (User) session.getAttribute("user");
		if (user != null) {
			List<Order> list = orderDao.getOrdersOfUser(user);
			session.setAttribute("orderList", list);
		}
		try {
			res.sendRedirect("myAccount.jsp");
		} catch (IOException e) {
			LOGGER.info(e.getMessage());
		}
	}

}
