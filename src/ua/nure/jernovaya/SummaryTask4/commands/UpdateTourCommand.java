/**
 * 
 */
package ua.nure.jernovaya.SummaryTask4.commands;

import java.io.IOException;
import java.sql.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import ua.nure.jernovaya.SummaryTask4.dao.HotelDAO;
import ua.nure.jernovaya.SummaryTask4.dao.TourDAO;
import ua.nure.jernovaya.SummaryTask4.entity.Tour;
import ua.nure.jernovaya.SummaryTask4.entity.Type;
import ua.nure.jernovaya.SummaryTask4.validators.Validator;

/**
 * @author Elmira Jernovaya.
 *
 */
public class UpdateTourCommand implements Command {
	/**
	 * Logger.
	 */
	private static final Logger LOGGER = Logger.getLogger(UpdateTourCommand.class);
	TourDAO tourDAO = new TourDAO();
	private HotelDAO hotelDao = new HotelDAO();

	/**
	 * (non-Javadoc)
	 * 
	 * @see ua.nure.jernovaya.SummaryTask4.commands.Command#execute(javax.servlet.http.HttpServletRequest,
	 *      javax.servlet.http.HttpServletResponse)
	 */
	@Override
	public void execute(HttpServletRequest req, HttpServletResponse res) {
		String id = req.getParameter("tourId");
		Tour tour = null;
		if (id != null && Validator.isInteger(id)) {

			tour = tourDAO.read(Integer.valueOf(id));

		}
		String type = req.getParameter("selectType");
		String price = req.getParameter("editPrice");
		String personCount = req.getParameter("editPersonCount");
		String hotelId = req.getParameter("editHotel");
		String date = req.getParameter("editDate");
		String nights = req.getParameter("editNights");
		String city = req.getParameter("editCity");
		if (type != null) {
			tour.setType(Type.valueOf(type.toUpperCase()));
			tourDAO.update(tour);
		} else if (price != null && Validator.isDouble(price)) {
			tour.setPrice(Integer.valueOf(price));
			tourDAO.update(tour);
		} else if (personCount != null && Validator.isInteger(personCount)) {
			tour.setPersonCount(Integer.valueOf(personCount));
			tourDAO.update(tour);
		} else if (hotelId != null && Validator.isInteger(hotelId)
				&& (hotelDao.read(Integer.valueOf(hotelId)) != null)) {
			tour.setHotel(hotelDao.read(Integer.valueOf(hotelId)));
			tourDAO.update(tour);
		} else if (date != null) {
			tour.setDepartureDate(Date.valueOf(date));
			tourDAO.update(tour);
		} else if (nights != null && Validator.isInteger(nights)) {
			tour.setNights(Integer.valueOf(nights));
			tourDAO.update(tour);
		} else if (city != null) {
			tour.setDepartureCity(city);
			tourDAO.update(tour);
		}
		try {
			res.sendRedirect("Controller?com=admin");
		} catch (IOException e) {
			LOGGER.error(e.getMessage());
		}
	}

}
