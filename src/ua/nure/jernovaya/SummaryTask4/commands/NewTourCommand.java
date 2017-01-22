package ua.nure.jernovaya.SummaryTask4.commands;

import java.io.IOException;
import java.sql.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import ua.nure.jernovaya.SummaryTask4.controller.AddFilesServlet;
import ua.nure.jernovaya.SummaryTask4.dao.HotelDAO;
import ua.nure.jernovaya.SummaryTask4.dao.TourDAO;
import ua.nure.jernovaya.SummaryTask4.entity.Hotel;
import ua.nure.jernovaya.SummaryTask4.entity.Tour;
import ua.nure.jernovaya.SummaryTask4.entity.Type;
import ua.nure.jernovaya.SummaryTask4.validators.Validator;

/**
 * 
 * @author Elmira Jernovaya.
 *
 */
public class NewTourCommand implements Command {
	/**
	 * Logger.
	 */
	private static final Logger LOGGER = Logger.getLogger(AddFilesServlet.class);
	private HotelDAO hotelDao = new HotelDAO();
	private TourDAO tourDao = new TourDAO();

	/**
	 * (non-Javadoc)
	 * 
	 * @see ua.nure.jernovaya.SummaryTask4.commands.Command#execute(javax.servlet.http.HttpServletRequest,
	 *      javax.servlet.http.HttpServletResponse)
	 */
	@Override
	public void execute(HttpServletRequest req, HttpServletResponse res) {
		String type = req.getParameter("selectType");
		String price = req.getParameter("price");
		String people = req.getParameter("people");
		String hotelID = req.getParameter("hotelId");
		String date = req.getParameter("date");
		String nights = req.getParameter("nights");
		String city = req.getParameter("depCity");
		String photoPath = "images/no_photo_tour.jpg";
		boolean notNull = !Validator.isNull(price, type, people, hotelID, date, nights, city);
		boolean validNumber = Validator.isInteger(hotelID, nights, people) && Validator.isDouble(price);
		Tour tour = null;
		LOGGER.info("valid = " + validNumber + " not null= " + notNull);
		if (notNull && validNumber) {
			Hotel hotel = hotelDao.read(Integer.valueOf(hotelID));
			LOGGER.info(hotel);
			if (hotel != null) {
				tour = new Tour(photoPath, Type.valueOf(type.toUpperCase()), Double.valueOf(price),
						Integer.valueOf(people), hotel, Date.valueOf(date), Integer.valueOf(nights), city);
				tourDao.create(tour);
			}

		}
		try {
			res.sendRedirect("Controller?com=admin");
		} catch (IOException e) {
			LOGGER.error(e.getMessage());
		}

	}

}
