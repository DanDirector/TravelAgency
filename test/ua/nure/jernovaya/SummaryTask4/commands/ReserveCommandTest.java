/**
 * 
 */
package ua.nure.jernovaya.SummaryTask4.commands;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.junit.BeforeClass;
import org.junit.Test;
import org.mockito.Mockito;

import ua.nure.jernovaya.SummaryTask4.dao.OrderDAO;

/**
 * @author Elmira
 *
 */
public class ReserveCommandTest extends Mockito {

	private static ReserveCommand rc;

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		rc=new ReserveCommand();
	}

	/**
	 * Test method for {@link ua.nure.jernovaya.SummaryTask4.commands.ReserveCommand#execute(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)}.
	 */
	@Test
	public void testExecute() {
		HttpServletRequest request = mock(HttpServletRequest.class);
		HttpServletResponse response = mock(HttpServletResponse.class);
		HttpSession session=mock(HttpSession.class);
		ServletContext context=mock(ServletContext.class);
		OrderDAO orderDao=mock(OrderDAO.class);
		rc.orderDao=orderDao;
		when(request.getSession()).thenReturn(session);
		when(request.getServletContext()).thenReturn(context);
		when(session.getAttribute(Mockito.anyString())).thenReturn(null);
		when(context.getAttribute(Mockito.anyString())).thenReturn(100);
		rc.execute(request, response);
		verify(request, atLeast(1)).getSession();
		
	}

}
