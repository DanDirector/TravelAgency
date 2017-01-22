/**
 * 
 */
package ua.nure.jernovaya.SummaryTask4.commands;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

/**
 * @author Elmira Jernovaya.
 *
 */
public class NextPageCommand implements Command {
	/**
	 * Logger.
	 */
	private static final Logger LOGGER = Logger.getLogger(NextPageCommand.class);

	/**
	 * (non-Javadoc)
	 * 
	 * @see ua.nure.jernovaya.SummaryTask4.commands.Command#execute(javax.servlet.http.HttpServletRequest,
	 *      javax.servlet.http.HttpServletResponse)
	 */
	@Override
	public void execute(HttpServletRequest req, HttpServletResponse res) {
		HttpSession session = req.getSession();
		String page=req.getParameter("page");
		String objects=req.getParameter("o"); 
		if (session.getAttribute(page)!=null) {
	     	int currPage = (int)session.getAttribute(page) ;
			session.setAttribute(objects, session.getAttribute(String.valueOf(currPage+1)));
			session.setAttribute(page, currPage+1);
		}
		
		try {
			res.sendRedirect("adminPanel.jsp");
		} catch (IOException e) {
			LOGGER.error(e.getMessage());
		}
	}

}
