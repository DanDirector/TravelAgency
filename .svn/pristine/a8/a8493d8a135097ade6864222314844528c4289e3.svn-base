package ua.nure.jernovaya.SummaryTask4.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.ibm.useful.http.FileData;
import com.ibm.useful.http.PostData;

import ua.nure.jernovaya.SummaryTask4.dao.TourDAO;
import ua.nure.jernovaya.SummaryTask4.entity.Tour;
import ua.nure.jernovaya.SummaryTask4.tags.ImagePaths;

/**
 * @author Elmira Jernovaya.
 * Servlet implementation class AddFilesServlet
 */
@WebServlet("/AddFilesServlet")
public class AddFilesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger LOGGER = Logger.getLogger(AddFilesServlet.class);
	private TourDAO tourDao = new TourDAO();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AddFilesServlet() {
		super();

	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest req, HttpServletResponse response) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		response.setContentType("multipart/form-data");
		try {
			if (isMultipartFormat(req)) {
				PostData multidata = new PostData(req);
				
				FileData tempFile = multidata.getFileData("file_send");
				String path = multidata.getParameter("path");
				LOGGER.info(tempFile.getFileName());
				if (tempFile != null)
					saveFile(tempFile, path);
				if (path.equals("images/tour_im/")) {
					String id=multidata.getParameter("id");
					Tour tour=tourDao.read(Integer.valueOf(id));
					tour.setImagePath(path+tempFile.getFileName());
					tourDao.update(tour);
					
				}

			}
		} catch (Exception e) {
			LOGGER.error(e.getMessage());

		}
		response.sendRedirect("Controller?com=admin");
	}

	/**
	 * checks if request is in multipart format.
	 * 
	 * @param req
	 * @return
	 * @throws javax.servlet.ServletException
	 * @throws java.io.IOException
	 */
	private boolean isMultipartFormat(HttpServletRequest req)
			throws javax.servlet.ServletException, java.io.IOException {
		String temptype = req.getContentType();
		if (temptype == null) {
			LOGGER.info("tempfile null");
		}

		else {
			LOGGER.info(temptype.indexOf("multipart/form-data") != -1);
			if (temptype.indexOf("multipart/form-data") != -1)
				return true;
		}

		return false;
	}

	/**
	 * save come file on disk.
	 * 
	 * @param tempFile
	 * @throws IOException
	 */
	private void saveFile(FileData tempFile, String path) throws IOException {
		File f = new File("C:\\workspace\\WebContent\\" + path + "\\" + tempFile.getFileName());
		File f1 = new File(ImagePaths.parentPath + path + "/" + tempFile.getFileName());
		LOGGER.info(f.getName());
		FileOutputStream fos = new FileOutputStream(f);
		FileOutputStream fos1 = new FileOutputStream(f1);
		fos.write(tempFile.getByteData());
		fos1.write(tempFile.getByteData());
		fos.close();
		fos1.close();
	}

}
