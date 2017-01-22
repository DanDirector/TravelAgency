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
import ua.nure.jernovaya.SummaryTask4.entity.Order;

/**
 * @author Elmira Jernovaya.
 *
 */
public class SelectOrdersCommand implements Command {
	/**
	 * Logger.
	 */
	final static Logger LOGGER = Logger.getLogger(SelectOrdersCommand.class);
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
		String status = req.getParameter("status");
		List<Order> list1 = orderDao.getAllOrders();
		session.setAttribute("orders", list1);
		@SuppressWarnings("unchecked")
		List<Order> list = (ArrayList<Order>) session.getAttribute("orders");
		List<Order> newList = new ArrayList<>();
		if (status != null) {
			for (Order order : list) {
				if (order.getStatus().toString().equals(status)) {
					newList.add(order);
				}
			}
		}
		session.setAttribute("orders", newList);
		try {
			res.sendRedirect("admin.jsp");
		} catch (IOException e) {
			LOGGER.error(e.getMessage());
		}

	}

}
