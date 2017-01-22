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

/**
 * @author Elmira Jernovaya.
 *
 */
public class UsersSearchCommandTest extends Mockito {

	private static UsersSearchCommand usc;

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		usc=new UsersSearchCommand();
	}

	/**
	 * Test method for {@link ua.nure.jernovaya.SummaryTask4.commands.UsersSearchCommand#execute(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)}.
	 */
	@Test
	public void testExecute() {
		HttpServletRequest request = mock(HttpServletRequest.class);
		HttpServletResponse response = mock(HttpServletResponse.class);
		HttpSession session=mock(HttpSession.class);
		when(request.getSession()).thenReturn(session);
		UserDAO dao=mock(UserDAO.class);
		usc.userDao=dao;
		when(request.getParameter("client")).thenReturn("Ann Sedokova");
		when(dao.getUserBySecondName("Ann", "Sedokova")).thenReturn(null);
		usc.execute(request, response);
	}

}
