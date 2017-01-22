/**
 * 
 */
package ua.nure.jernovaya.SummaryTask4.commands;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.junit.BeforeClass;
import org.junit.Test;
import org.mockito.Mockito;

import ua.nure.jernovaya.SummaryTask4.dao.SubscriberDao;

/**
 * @author Elmira Jernovaya.
 *
 */
public class SendMailCommandTest extends Mockito {

	private static SendMailCommand smc;

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		smc=new SendMailCommand();
	}

	/**
	 * Test method for {@link ua.nure.jernovaya.SummaryTask4.commands.SendMailCommand#execute(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)}.
	 */
	@Test
	public void testExecute() {
		HttpServletRequest request = mock(HttpServletRequest.class);
		HttpServletResponse response = mock(HttpServletResponse.class);
		SubscriberDao ssDao=mock(SubscriberDao.class);
		smc.ssDao=ssDao;
		when(request.getParameter(Mockito.anyString())).thenReturn(null);
		when(ssDao.getAll()).thenReturn(null);
		
		smc.execute(request, response);
		verify(ssDao, atLeast(1)).getAll();
	}

}
