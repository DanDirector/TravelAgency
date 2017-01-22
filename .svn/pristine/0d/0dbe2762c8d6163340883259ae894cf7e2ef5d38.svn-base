package ua.nure.jernovaya.SummaryTask4.commands;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import ua.nure.jernovaya.SummaryTask4.entity.Tour;

/**
 * 
 * @author Elmira Jerovaya.
 *
 */
public class SortCommand implements Command {
	private List<Tour> simple;
	private List<Tour> hot;
	/**
	 * Logger.
	 */
	private static final Logger LOGGER = Logger.getLogger(SortCommand.class);

	/**
	 * (non-Javadoc)
	 * 
	 * @see ua.nure.jernovaya.SummaryTask4.commands.Command#execute(javax.servlet.http.HttpServletRequest,
	 *      javax.servlet.http.HttpServletResponse)
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void execute(HttpServletRequest req, HttpServletResponse res) {
		HttpSession session = req.getSession();
		String sortValue = req.getParameter("select");
		simple = (ArrayList<Tour>) session.getAttribute("simpleTours");
		hot = (ArrayList<Tour>) session.getAttribute("hotTours");
		if (sortValue != null) {
			switch (sortValue) {
			case "asc":
				sortAscending();
				break;
			case "desc":
				sortDescending();
				break;
			case "date":
				sortByDate();
				break;
			default:
				LOGGER.error("Wrong sort value");
				break;
			}
		}
		session.setAttribute("simpleTours", simple);
		session.setAttribute("hotTours", hot);
		try {
			res.sendRedirect("tours.jsp");
		} catch (IOException e) {
			LOGGER.error(e.getMessage());
		}
	}

	/**
	 * sorts collection by Date.
	 */
	private void sortByDate() {
		Collections.sort(simple, new Comparator<Tour>() {
			@Override
			public int compare(Tour o1, Tour o2) {

				return o1.getDepartureDate().compareTo(o2.getDepartureDate());
			}
		});
		Collections.sort(hot, new Comparator<Tour>() {
			@Override
			public int compare(Tour o1, Tour o2) {

				return o1.getDepartureDate().compareTo(o2.getDepartureDate());
			}
		});
	}

	/**
	 * sorts collections by price ascending.
	 */
	private void sortAscending() {
		Collections.sort(simple, new Comparator<Tour>() {
			@Override
			public int compare(Tour o1, Tour o2) {

				return (int) (o1.getPrice() - o2.getPrice());
			}
		});
		Collections.sort(hot, new Comparator<Tour>() {
			@Override
			public int compare(Tour o1, Tour o2) {

				return (int) (o1.getPrice() - o2.getPrice());
			}
		});
	}

	/**
	 * sorts collections by price descending.
	 */
	private void sortDescending() {
		Collections.sort(simple, new Comparator<Tour>() {
			@Override
			public int compare(Tour o1, Tour o2) {

				return (int) (o2.getPrice() - o1.getPrice());
			}
		});
		Collections.sort(hot, new Comparator<Tour>() {
			@Override
			public int compare(Tour o1, Tour o2) {

				return (int) (o2.getPrice() - o1.getPrice());
			}
		});
	}

}
