package ua.nure.jernovaya.SummaryTask4.commands;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import ua.nure.jernovaya.SummaryTask4.dao.TourDAO;
import ua.nure.jernovaya.SummaryTask4.entity.Tour;
import ua.nure.jernovaya.SummaryTask4.jdbc.Sqls;
/**
 * 
 * @author Elmira Jernovaya.
 *
 */
public class CountriesCommand implements Command {
	/**
	 * Logger.
	 */
	public static final Logger LOGGER = Logger.getLogger(CountriesCommand.class);
	 TourDAO dao = new TourDAO();
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
		if (country != null) {
			List<Tour> hot = dao.getToursByCountry(Sqls.SELECT_HOT_TOURS_BY_COUNTRY, country);
			List<Tour> simple = dao.getToursByCountry(Sqls.SELECT_SIMPLE_TOURS_BY_COUNTRY, country);
			session.setAttribute("simpleTours", simple);
			session.setAttribute("hotTours", hot);
		}
		try {
			res.sendRedirect("tours.jsp");
		} catch (IOException e) {
			LOGGER.error(e.getMessage());
		}
	}

}
