/**
 * 
 */
package ua.nure.jernovaya.SummaryTask4.commands;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.junit.BeforeClass;
import org.junit.Test;
import org.mockito.Mockito;

import ua.nure.jernovaya.SummaryTask4.dao.UserDAO;
import ua.nure.jernovaya.SummaryTask4.entity.Role;
import ua.nure.jernovaya.SummaryTask4.entity.User;

/**
 * @author Elmira Jernovaya.
 *
 */
public class LogInCommandTest extends Mockito {
	private static LogInCommand lc;

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		lc = new LogInCommand();
	}

	/**
	 * Test method for
	 * {@link ua.nure.jernovaya.SummaryTask4.commands.LogInCommand#execute(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)}
	 * .
	 */
	@Test
	public void testExecute() {
		HttpServletRequest request = mock(HttpServletRequest.class);
		HttpServletResponse response = mock(HttpServletResponse.class);
		UserDAO dao = mock(UserDAO.class);
		lc.userDao = dao;
		HttpSession session = mock(HttpSession.class);
		when(request.getSession()).thenReturn(session);
		when(request.getParameter("login")).thenReturn("l");
		when(request.getParameter("password")).thenReturn("p");
		User u = new User();
		u.setRole(Role.CLIENT);
		when(dao.read("l", "p")).thenReturn(u);

		lc.execute(request, response);
		u.setRole(Role.ADMIN);
		lc.execute(request, response);
		u.setRole(Role.BLOCKED);
		lc.execute(request, response);
		u.setRole(Role.MANAGER);
		when(request.getParameter("password")).thenReturn(null);
		lc.execute(request, response);
		u = null;
		lc.execute(request, response);
		verify(request, atLeast(1)).getParameter("login");
		verify(request, atLeast(1)).getParameter("password");

	}

}
