/**
 * 
 */
package ua.nure.jernovaya.SummaryTask4.commands;

import java.io.IOException;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import ua.nure.jernovaya.SummaryTask4.dao.HotelDAO;
import ua.nure.jernovaya.SummaryTask4.dao.TourDAO;
import ua.nure.jernovaya.SummaryTask4.entity.Hotel;
import ua.nure.jernovaya.SummaryTask4.entity.Tour;
import ua.nure.jernovaya.SummaryTask4.jdbc.Sqls;

/**
 * @author Elmira Jernovaya.
 *
 */
public class AdminCommand implements Command {
	TourDAO tourDao = new TourDAO();
	HotelDAO hotelDao = new HotelDAO();
	/**
	 * Logger.
	 */
	private static final Logger LOGGER = Logger.getLogger(AdminCommand.class);

	/**
	 * (non-Javadoc)
	 * 
	 * @see ua.nure.jernovaya.SummaryTask4.commands.Command#execute(javax.servlet.http.HttpServletRequest,
	 *      javax.servlet.http.HttpServletResponse)
	 */
	@Override
	public void execute(HttpServletRequest req, HttpServletResponse res) {
		HttpSession session = req.getSession();
		List<Tour> tours;
		if (req.getParameter("select") != null) {
			String type = req.getParameter("selectType");
			String country = req.getParameter("selectCountry");
			String rate = req.getParameter("selectRate");
			String priceFrom = req.getParameter("from");
			String priceTo = req.getParameter("to");
			String people = req.getParameter("people");
			String date = req.getParameter("date");
			tours = tourDao.getToursByParameters(Sqls.SELECT_All_TOURS_BY_PARAMETERS, Double.valueOf(priceFrom),
					Double.valueOf(priceTo), Integer.valueOf(people), type, rate, country, Date.valueOf(date));
			session.setAttribute("toursPage", 1);

		} else if (req.getParameter("hotel") != null) {
			int hotelId = Integer.valueOf(req.getParameter("hotel"));
			tours = tourDao.getToursByHotelId(hotelId);
			session.setAttribute("toursPage", 1);

		} else {
			tours = tourDao.getAllTours(Sqls.SELECT_ALL_TOURS);
			session.setAttribute("toursPage", 1);
		}
		printBox(tours, session, "tours", "toursPage");

		List<Hotel> hotels = hotelDao.getAllHotels();
		session.setAttribute("hotels", hotels);

		try {
			res.sendRedirect("adminPanel.jsp");
		} catch (IOException e) {
			LOGGER.error(e.getMessage());
		}

	}

	/**
	 * divides given list in several pages.
	 * 
	 * @param l
	 * @param session
	 * @param inSession
	 * @param pageFrom
	 */
	 <E> void printBox(List<E> l, HttpSession session, String inSession, String pageFrom) {
		int toursOnPage = 5;
		System.out.println(l);
		if (l != null) {

			int ostatok = l.size() % toursOnPage;
			if (l.isEmpty()) {
				session.setAttribute("1", l);
			}
			if (ostatok != 0) {
				int pages = (int) l.size() / toursOnPage;
				List<E> lastList = new ArrayList<>();
				lastList.addAll(l.subList(l.size() - ostatok, l.size()));
				session.setAttribute(String.valueOf(pages + 1), lastList);
			}

			for (int i = 0; i <= l.size(); i++) {
				if (i % toursOnPage == 0 && i != 0) {
					List<E> list = new ArrayList<>();
					list.addAll(l.subList(i - toursOnPage, i));
					session.setAttribute(String.valueOf(i / toursOnPage), list);
				}
			}
		}
		if (session.getAttribute(pageFrom) == null) {
			session.setAttribute(pageFrom, 1);
		}
		session.setAttribute(inSession, session.getAttribute(String.valueOf(session.getAttribute(pageFrom))));

	}

}
