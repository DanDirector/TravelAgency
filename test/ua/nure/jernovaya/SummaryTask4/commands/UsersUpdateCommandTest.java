/**
 * 
 */
package ua.nure.jernovaya.SummaryTask4.commands;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.junit.BeforeClass;
import org.junit.Test;
import org.mockito.Mockito;

import ua.nure.jernovaya.SummaryTask4.dao.UserDAO;
import ua.nure.jernovaya.SummaryTask4.entity.User;

/**
 * @author Elmira Jernovaya.
 *
 */
public class UsersUpdateCommandTest extends Mockito {

	private static UsersUpdateCommand usc;

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		usc=new UsersUpdateCommand();
	}

	/**
	 * Test method for {@link ua.nure.jernovaya.SummaryTask4.commands.UsersUpdateCommand#execute(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)}.
	 */
	@Test
	public void testExecute() {
		HttpServletRequest request = mock(HttpServletRequest.class);
		HttpServletResponse response = mock(HttpServletResponse.class);
		when(request.getParameter("set")).thenReturn("man");
		when(request.getParameter("id")).thenReturn("3");
		UserDAO userDao=mock(UserDAO.class);
		usc.dao=userDao;
		User user=new User();
		when(userDao.read(Mockito.anyInt())).thenReturn(user);
		usc.execute(request, response);
		verify(request, atLeast(1)).getParameter("id");
		
		
	}

}
