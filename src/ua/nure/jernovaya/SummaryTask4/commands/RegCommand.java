/**
 * 
 */
package ua.nure.jernovaya.SummaryTask4.commands;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import net.tanesha.recaptcha.ReCaptchaImpl;
import net.tanesha.recaptcha.ReCaptchaResponse;
import ua.nure.jernovaya.SummaryTask4.dao.UserDAO;
import ua.nure.jernovaya.SummaryTask4.entity.User;

/**
 * @author Elmira Jernovaya.
 *
 */
public class RegCommand implements Command {
	/**
	 * Logger.
	 */
	private static final Logger LOGGER = Logger.getLogger(RegCommand.class);
    UserDAO userDao = new UserDAO();  

	/**
	 * (non-Javadoc)
	 * 
	 * @see ua.nure.jernovaya.SummaryTask4.commands.Command#execute(javax.servlet.http.HttpServletRequest,
	 *      javax.servlet.http.HttpServletResponse)
	 */
	@Override
	public void execute(HttpServletRequest req, HttpServletResponse res) {
		HttpSession session = req.getSession();
		String name = req.getParameter("name");
		String secName = req.getParameter("second_name");
		String email = req.getParameter("email");
		String login = req.getParameter("login");
		String password = req.getParameter("password");
		String remoteAddr = req.getRemoteAddr();
		ReCaptchaImpl reCaptcha = new ReCaptchaImpl();
		reCaptcha.setPrivateKey("6LefxSgTAAAAAKUeqs8u5nVSvFKasm2IYzEY-hno");

		String challenge = req.getParameter("recaptcha_challenge_field");
		String uresponse = req.getParameter("recaptcha_response_field");
		if (remoteAddr!=null) {
			
		
		ReCaptchaResponse reCaptchaResponse = reCaptcha.checkAnswer(remoteAddr, challenge, uresponse);

		if (!reCaptchaResponse.isValid()) {
			
			session.setAttribute("exists", "Wrong_captcha");
			try {
				res.sendRedirect("register.jsp");
			} catch (IOException e) {
             LOGGER.info(e.getMessage());				}
		}
		else if (!userDao.userExists(login)) {
			User user = new User(name, secName, email, login, password);
			userDao.create(user);
			user.setId(userDao.getUserID());
			try {
				session.setAttribute("user", user);
				res.sendRedirect("index.jsp");
			} catch (IOException e) {
				LOGGER.error(e.getMessage());
			}
		} else {
			try {
				session.setAttribute("exists", "exists");
				res.sendRedirect("register.jsp");
			} catch (IOException e) {
				LOGGER.error(e.getMessage());
			}
		}
		}
	}

}
