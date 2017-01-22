/**
 * 
 */
package ua.nure.jernovaya.SummaryTask4.commands;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.junit.BeforeClass;
import org.junit.Test;
import org.mockito.Mockito;

import ua.nure.jernovaya.SummaryTask4.dao.OrderDAO;

/**
 * @author Elmira Jenovaya.
 *
 */
public class ManagerCommandTest extends Mockito {

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	/**
	 * Test method for {@link ua.nure.jernovaya.SummaryTask4.commands.ManagerCommand#execute(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)}.
	 */
	@Test
	public void testExecute() {
		HttpServletRequest request = mock(HttpServletRequest.class);
		HttpServletResponse response = mock(HttpServletResponse.class);
		HttpSession session=mock(HttpSession.class);
		when(request.getSession()).thenReturn(session);
		OrderDAO orderDao=mock(OrderDAO.class);
		when(orderDao.getAllOrders()).thenReturn(new ArrayList<>());
		ManagerCommand mc=new ManagerCommand();
		mc.orderDao=orderDao;
		mc.execute(request, response);
		verify(request, atLeast(1)).getSession();
		verify(orderDao, atLeast(1)).getAllOrders();
		
	}

}
