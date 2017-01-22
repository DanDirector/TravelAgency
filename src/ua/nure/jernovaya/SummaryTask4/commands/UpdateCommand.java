/**
 * 
 */
package ua.nure.jernovaya.SummaryTask4.commands;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import ua.nure.jernovaya.SummaryTask4.dao.OrderDAO;
import ua.nure.jernovaya.SummaryTask4.entity.Order;
import ua.nure.jernovaya.SummaryTask4.jdbc.Sqls;
import ua.nure.jernovaya.SummaryTask4.validators.Validator;

/**
 * @author Elmira Jernovaya.
 *
 */
public class UpdateCommand implements Command {
	/**
	 * Logger.
	 */
	private static final Logger LOGGER = Logger.getLogger(UpdateCommand.class);
	 OrderDAO orderDao = new OrderDAO();
	 Order order;

	/**
	 * (non-Javadoc)
	 * 
	 * @see ua.nure.jernovaya.SummaryTask4.commands.Command#execute(javax.servlet.http.HttpServletRequest,
	 *      javax.servlet.http.HttpServletResponse)
	 */
	@Override
	public void execute(HttpServletRequest req, HttpServletResponse res) {
		String update = req.getParameter("update");
		String o = req.getParameter("order");
		if (o != null && Validator.isInteger(o)) {
			int orderId = Integer.parseInt(o);
			this.order = orderDao.read(orderId);
		}
		String maximal = req.getParameter("max");
		String discStep = req.getParameter("step");
		double max = 0;
		double step = 0;
		if (maximal != null && Validator.isDouble(maximal)) {
			max = Double.valueOf(maximal);
		}
		if (discStep != null && Validator.isDouble(discStep)) {
			step = Double.valueOf(discStep);
		}
		String sql = getSql(update, max, step);
		if (order != null) {
			orderDao.update(order, sql);
		}
		try {
			res.sendRedirect("Controller?com=manager");
		} catch (IOException e) {
			LOGGER.error(e.getMessage());
		}
	}

	/**
	 * Choose the right sql request for updating object.
	 * 
	 * @param update
	 * @param max
	 * @param step
	 * @return
	 */
	 String getSql(String update, double max, double step) {
		String sql = null;
		if (update != null) {

			switch (update) {
			case "setPayed":
				sql = Sqls.SET_ORDER_PAYED;
				break;
			case "setCanceled":
				sql = Sqls.SET_ORDER_CANCELED;
				break;
			case "max":
				order.setMaxDiscount(max);
				sql = "UPDATE `ta`.`orders` SET `max_discount`='" + max + "' WHERE `id`=?";
				break;
			case "step":
				order.setDiscountStep(step);
				sql = "UPDATE `ta`.`orders` SET `discount_step`='" + step + "' WHERE `id`=?";
				break;
			}
		}
		return sql;
	}

}
