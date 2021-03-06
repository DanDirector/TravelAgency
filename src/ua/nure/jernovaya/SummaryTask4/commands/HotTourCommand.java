/**
 * 
 */
package ua.nure.jernovaya.SummaryTask4.commands;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.log4j.Logger;

import ua.nure.jernovaya.SummaryTask4.dao.TourDAO;
import ua.nure.jernovaya.SummaryTask4.entity.Tour;
import ua.nure.jernovaya.SummaryTask4.jdbc.Sqls;
import ua.nure.jernovaya.SummaryTask4.validators.Validator;

/**
 * @author Elmira Jernovaya.
 *
 */
public class HotTourCommand implements Command {
	/**
	 * Logger.
	 */
	private static final Logger LOGGER = Logger.getLogger(HotTourCommand.class);
	 TourDAO tourDao = new TourDAO();

	/**
	 * (non-Javadoc)
	 * 
	 * @see ua.nure.jernovaya.SummaryTask4.commands.Command#execute(javax.servlet.http.HttpServletRequest,
	 *      javax.servlet.http.HttpServletResponse)
	 */
	@Override
	public void execute(HttpServletRequest req, HttpServletResponse res) {
		String id = req.getParameter("tour");
		if (id != null && Validator.isInteger(id)) {
			Tour tour = tourDao.read(Integer.valueOf(id));
			String set = req.getParameter("set");
			if (set != null) {
				if (set.equals("hot")) {
					tour.setIsHot(0);
				} else if (set.equals("simple")) {
					tour.setIsHot(1);
				}
			}
			tourDao.update(tour, Sqls.UPDATE_TOUR_BY_IS_HOT);
		}
		String page = req.getParameter("page");
		if (page != null) {
			try {
				res.sendRedirect("Controller?com=admin");
			} catch (IOException e) {
				LOGGER.error(e.getMessage());
			}
		} else {
			try {
				res.sendRedirect("Controller?com=manager");
			} catch (IOException e) {
				LOGGER.error(e.getMessage());
			}
		}
	}

}
