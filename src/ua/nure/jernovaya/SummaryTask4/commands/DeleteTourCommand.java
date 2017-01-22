/**
 * 
 */
package ua.nure.jernovaya.SummaryTask4.commands;

import java.io.File;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import ua.nure.jernovaya.SummaryTask4.dao.TourDAO;
import ua.nure.jernovaya.SummaryTask4.entity.Tour;
import ua.nure.jernovaya.SummaryTask4.tags.ImagePaths;
import ua.nure.jernovaya.SummaryTask4.validators.Validator;

/**
 * @author Elmira Jernovaya.
 *
 */
public class DeleteTourCommand implements Command {
	/**
	 * Logger.
	 */
	private static final Logger LOGGER = Logger.getLogger(DeleteTourCommand.class);
	 TourDAO tourDao = new TourDAO();

	/**
	 * (non-Javadoc)
	 * 
	 * @see ua.nure.jernovaya.SummaryTask4.commands.Command#execute(javax.servlet.http.HttpServletRequest,
	 *      javax.servlet.http.HttpServletResponse)
	 */
	@Override
	public void execute(HttpServletRequest req, HttpServletResponse res) {
		String id = req.getParameter("tourId");
		if (id != null && Validator.isInteger(id)) {
			int tourId = Integer.parseInt(id);
			Tour tour = tourDao.read(tourId);
			String path = tour.getImagePath();
			File f = new File("C:\\workspace\\WebContent\\" + path);
			File f1 = new File(ImagePaths.parentPath + path);
			if (path!=null&&!path.equals("images/no_photo_tour.jpg")) {
				LOGGER.info("in ecl delete photo " + f.delete() + " in tomcat delete photo " + f1.delete());
			}
			tourDao.delete(tour);
		}
		try {
			res.sendRedirect("Controller?com=admin");
		} catch (IOException e) {
			LOGGER.error(e.getMessage());
		}
	}

}
