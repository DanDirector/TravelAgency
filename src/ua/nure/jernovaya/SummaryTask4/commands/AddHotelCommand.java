/**
 * 
 */
package ua.nure.jernovaya.SummaryTask4.commands;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import ua.nure.jernovaya.SummaryTask4.dao.HotelDAO;
import ua.nure.jernovaya.SummaryTask4.entity.Hotel;
import ua.nure.jernovaya.SummaryTask4.entity.Nutrition;
import ua.nure.jernovaya.SummaryTask4.validators.Validator;

/**
 * @author Elmira Jernovaya.
 *
 */
public class AddHotelCommand implements Command {
	/**
	 * Logger.
	 */
	private static final Logger LOGGER = Logger.getLogger(AddHotelCommand.class);
	 HotelDAO hotelDao = new HotelDAO();

	/**
	 * (non-Javadoc)
	 * 
	 * @see ua.nure.jernovaya.SummaryTask4.commands.Command#execute(javax.servlet.http.HttpServletRequest,
	 *      javax.servlet.http.HttpServletResponse)
	 */
	@Override
	public void execute(HttpServletRequest req, HttpServletResponse res) {
		String name = req.getParameter("name");
		String rate = req.getParameter("rate");
		String nut = req.getParameter("nut");
		String country = req.getParameter("country");
		String city = req.getParameter("city");
		String descr = req.getParameter("desc");
		if (!Validator.isNull(name, rate, nut, country, city, descr)) {
			Hotel hotel = new Hotel(name, rate, Nutrition.valueOf(nut), country, city, descr);
			LOGGER.info(hotelDao.create(hotel));
		}
		try {
			res.sendRedirect("Controller?com=admin");
		} catch (IOException e) {
			LOGGER.error(e.getMessage());
		}

	}

}
