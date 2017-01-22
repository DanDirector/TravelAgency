/**
 * 
 */
package ua.nure.jernovaya.SummaryTask4.commands;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.junit.BeforeClass;
import org.junit.Test;
import org.mockito.Mockito;

import ua.nure.jernovaya.SummaryTask4.dao.OrderDAO;
import ua.nure.jernovaya.SummaryTask4.entity.Order;
import ua.nure.jernovaya.SummaryTask4.entity.Status;

/**
 * @author Elmira Jernovaya.
 *
 */
public class SelectOrdersCommandTest extends Mockito {

	private static SelectOrdersCommand soc;

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		soc=new SelectOrdersCommand();
	}

	/**
	 * Test method for {@link ua.nure.jernovaya.SummaryTask4.commands.SelectOrdersCommand#execute(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)}.
	 */
	@Test
	public void testExecute() {
		HttpServletRequest request = mock(HttpServletRequest.class);
		HttpServletResponse response = mock(HttpServletResponse.class);
		HttpSession session=mock(HttpSession.class); 
		OrderDAO orderDao=mock(OrderDAO.class);
		soc.orderDao=orderDao;
		when(request.getSession()).thenReturn(session);
		when(request.getParameter("status")).thenReturn("PAYED");
		when(orderDao.getAllOrders()).thenReturn(null);
		Order order=new Order();
		order.setStatus(Status.PAYED);
		List<Order> os=new ArrayList<>();
		os.add(order);
		when(session.getAttribute("orders")).thenReturn(os);
		soc.execute(request, response);
		verify(request, atLeast(1)).getSession();
	}

}
