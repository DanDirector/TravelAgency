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

import ua.nure.jernovaya.SummaryTask4.dao.SubscriberDao;

/**
 * @author Elmira Jernovaya.
 *
 */
public class SubscribeCommandTest extends Mockito {

	private static SubscribeCommand ssc;

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		ssc = new SubscribeCommand();
	}

	/**
	 * Test method for
	 * {@link ua.nure.jernovaya.SummaryTask4.commands.SubscribeCommand#execute(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)}
	 * .
	 */
	@Test
	public void testExecute() {
		HttpServletRequest request = mock(HttpServletRequest.class);
		HttpServletResponse response = mock(HttpServletResponse.class);
		HttpSession session = mock(HttpSession.class);
		when(request.getSession()).thenReturn(session);
		when(request.getParameter(Mockito.anyString())).thenReturn(null);
		SubscriberDao ssDao = mock(SubscriberDao.class);
		ssc.ssDao = ssDao;
		when(ssDao.create(Mockito.anyObject())).thenReturn(true);

		ssc.execute(request, response);
		verify(request, atLeast(1)).getSession();

	}

}
