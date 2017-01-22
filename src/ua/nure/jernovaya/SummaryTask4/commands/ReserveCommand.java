package ua.nure.jernovaya.SummaryTask4.commands;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import ua.nure.jernovaya.SummaryTask4.dao.OrderDAO;
import ua.nure.jernovaya.SummaryTask4.entity.Order;
import ua.nure.jernovaya.SummaryTask4.entity.Status;
import ua.nure.jernovaya.SummaryTask4.entity.Tour;
import ua.nure.jernovaya.SummaryTask4.entity.User;

public class ReserveCommand implements Command {
	OrderDAO orderDao = new OrderDAO();
	/**
	 * Logger.
	 */
	public static final Logger LOGGER = Logger.getLogger(ReserveCommand.class);

	/**
	 * (non-Javadoc)
	 * 
	 * @see ua.nure.jernovaya.SummaryTask4.commands.Command#execute(javax.servlet.http.HttpServletRequest,
	 *      javax.servlet.http.HttpServletResponse)
	 */
	@Override
	public void execute(HttpServletRequest req, HttpServletResponse res) {
		HttpSession session = req.getSession();
		ServletContext context = req.getServletContext();
		Tour tour = (Tour) session.getAttribute("currentTour");
		User user = (User) session.getAttribute("user");
		Order order = new Order();
		order.setTour(tour);
		order.setUser(user);
		order.setStatus(Status.REGISTERED);
		orderDao.create(order);
		synchronized (context) 
		{
		int count = (int) context.getAttribute("madeOrder");
		count++;
		context.setAttribute("madeOrder", count);
		}
		try {
			res.sendRedirect("Controller?com=myAccount&where=details.jsp");
		} catch (IOException e) {
			LOGGER.error(e.getMessage());
		}
	}

}
