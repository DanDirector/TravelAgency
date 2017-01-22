/**
 * 
 */
package ua.nure.jernovaya.SummaryTask4.commands;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import ua.nure.jernovaya.SummaryTask4.dao.OrderDAO;
import ua.nure.jernovaya.SummaryTask4.entity.Order;

/**
 * @author Elmira
 *
 */
public class CurrentCommand implements Command {

	private static final Logger LOGGER = Logger.getLogger(CurrentCommand.class);
	private OrderDAO orderDao=new OrderDAO();

	/**(non-Javadoc)
	 * @see ua.nure.jernovaya.SummaryTask4.commands.Command#execute(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */
	@Override
	public void execute(HttpServletRequest req, HttpServletResponse res) {
		HttpSession session = req.getSession();
		List<Order> list = orderDao.getCurrentOrders();
		LOGGER.info(list);

		session.setAttribute("orders", list);

		try {
			res.sendRedirect("admin.jsp");
		} catch (IOException e) {
			LOGGER.error(e.getMessage());
		}
	}

}
