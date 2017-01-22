package ua.nure.jernovaya.SummaryTask4.commands;

import java.io.IOException;
import java.sql.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import ua.nure.jernovaya.SummaryTask4.dao.TourDAO;
import ua.nure.jernovaya.SummaryTask4.entity.Tour;
import ua.nure.jernovaya.SummaryTask4.jdbc.Sqls;
import ua.nure.jernovaya.SummaryTask4.validators.Validator;

public class SelectToursCommand implements Command {
	TourDAO dao = new TourDAO();
	/**
	 * Logger.
	 */
	final static Logger LOGGER = Logger.getLogger(SelectToursCommand.class);

	/**
	 * (non-Javadoc)
	 * 
	 * @see ua.nure.jernovaya.SummaryTask4.commands.Command#execute(javax.servlet.http.HttpServletRequest,
	 *      javax.servlet.http.HttpServletResponse)
	 */
	@Override
	public void execute(HttpServletRequest req, HttpServletResponse res) {
		HttpSession session = req.getSession();
		String type = req.getParameter("selectType");
		String country = req.getParameter("selectCountry");
		String rate = req.getParameter("selectRate");
		String priceFrom = req.getParameter("from");
		String priceTo = req.getParameter("to");
		String people = req.getParameter("people");
		String date = req.getParameter("date");
		if (!Validator.isNull(type, country, rate, priceFrom, priceTo, people, date)
				&& Validator.isDouble(priceFrom, priceTo) && Validator.isInteger(people)) {

			List<Tour> hot = dao.getToursByParameters(Sqls.SELECT_HOT_TOURS_BY_PARAMETERS, Double.valueOf(priceFrom),
					Double.valueOf(priceTo), Integer.valueOf(people), type, rate, country, Date.valueOf(date));
			List<Tour> simple = dao.getToursByParameters(Sqls.SELECT_SIMPLE_TOURS_BY_PARAMETERS,
					Double.valueOf(priceFrom), Double.valueOf(priceTo), Integer.valueOf(people), type, rate, country,
					Date.valueOf(date));

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
