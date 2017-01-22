/**
 * 
 */
package ua.nure.jernovaya.SummaryTask4.tags;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;

import org.apache.log4j.Logger;

import ua.nure.jernovaya.SummaryTask4.dao.TourDAO;
import ua.nure.jernovaya.SummaryTask4.entity.Tour;
import ua.nure.jernovaya.SummaryTask4.validators.Validator;

/**
 * @author Elmira Jernovaya.
 *
 */
public class DetailsTag extends TagSupport {
	/**
	 * default serial version.
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * Logger.
	 */
	final static Logger LOGGER = Logger.getLogger(DetailsTag.class);

	@Override
	public int doStartTag() throws JspException {
		HttpSession session = pageContext.getSession();
		HttpServletRequest req = (HttpServletRequest) pageContext.getRequest();
		String id = req.getParameter("tourId");
		if (id != null && Validator.isInteger(id)) {
			Tour tour = new TourDAO().read(Integer.valueOf(id));
			session.setAttribute("currentTour", tour);
		}
		return super.doStartTag();
	}

}
