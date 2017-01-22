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

import ua.nure.jernovaya.SummaryTask4.dao.TourDAO;

/**
 * @author Elmira Jernovaya.
 *
 */
public class SelectToursCommandTest extends Mockito {

	private static SelectToursCommand stc;

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		stc = new SelectToursCommand();
	}

	/**
	 * Test method for
	 * {@link ua.nure.jernovaya.SummaryTask4.commands.SelectToursCommand#execute(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)}
	 * .
	 */
	@Test
	public void testExecute() {
		HttpServletRequest request = mock(HttpServletRequest.class);
		HttpServletResponse response = mock(HttpServletResponse.class);
		HttpSession session = mock(HttpSession.class);
		TourDAO tourDao = mock(TourDAO.class);
		stc.dao = tourDao;

		when(request.getSession()).thenReturn(session);
		when(request.getParameter(Mockito.anyString())).thenReturn(null);

		stc.execute(request, response);
		verify(request, atLeast(1)).getSession();
	}

}
