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

import ua.nure.jernovaya.SummaryTask4.dao.HotelDAO;
import ua.nure.jernovaya.SummaryTask4.entity.Hotel;

/**
 * @author Elmira Jernovaya.
 *
 */
public class SearchHotelsCommand implements Command {
	/**
	 * Logger.
	 */
	private static final Logger LOGGER = Logger.getLogger(SearchHotelsCommand.class); 
	 HotelDAO hotelDao = new HotelDAO();

	/**
	 * (non-Javadoc)
	 * 
	 * @see ua.nure.jernovaya.SummaryTask4.commands.Command#execute(javax.servlet.http.HttpServletRequest,
	 *      javax.servlet.http.HttpServletResponse)
	 */
	@Override
	public void execute(HttpServletRequest req, HttpServletResponse res) {
		HttpSession session = req.getSession();
		String country = req.getParameter("country");
		List<Hotel> hotels = hotelDao.getHotelsByCountry(country);
		LOGGER.info(hotels);
		session.setAttribute("hotels", hotels);
		try {
			res.sendRedirect("adminPanel.jsp");
		} catch (IOException e) {
			LOGGER.error(e.getMessage());
		}
	}

}
