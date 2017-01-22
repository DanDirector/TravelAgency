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

/**
 * @author Elmira Jernovaya.
 *
 */
public class RegCommandTest extends Mockito {
	
	private static RegCommand rc;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		rc=new RegCommand();
	}

	/**
	 * Test method for {@link ua.nure.jernovaya.SummaryTask4.commands.RegCommand#execute(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)}.
	 */
	@Test
	public void testExecute() {
		HttpServletRequest request = mock(HttpServletRequest.class);
		HttpServletResponse response = mock(HttpServletResponse.class);	
		when(request.getParameter(Mockito.anyString())).thenReturn(null);
		when(request.getParameter(Mockito.anyString())).thenReturn(null);

		UserDAO userDao=mock(UserDAO.class);
		rc.userDao=userDao;
		when(userDao.userExists(null)).thenReturn(true);
		
		rc.execute(request, response);
		verify(request, atLeast(1)).getParameter("login");
		
	}

}
