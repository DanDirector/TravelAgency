/**
 * 
 */
package ua.nure.jernovaya.SummaryTask4.commands;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.junit.BeforeClass;
import org.junit.Test;
import org.mockito.Mockito;

import ua.nure.jernovaya.SummaryTask4.dao.OrderDAO;
import ua.nure.jernovaya.SummaryTask4.entity.Order;
import ua.nure.jernovaya.SummaryTask4.jdbc.Sqls;

/**
 * @author Elmira Jernovaya.
 *
 */
public class UpdateCommandTest extends Mockito {

	private static UpdateCommand uc;

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		uc=new UpdateCommand();
	}

	/**
	 * Test method for
	 * {@link ua.nure.jernovaya.SummaryTask4.commands.UpdateCommand#execute(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)}
	 * .
	 */
	@Test
	public void testExecute() {
		HttpServletRequest request = mock(HttpServletRequest.class);
		HttpServletResponse response = mock(HttpServletResponse.class);
		OrderDAO dao=mock(OrderDAO.class);
		uc.orderDao=dao;
		Order order=new Order();
		uc.order=order;
		when(dao.read(1)).thenReturn(order);
		when(dao.update(order, Sqls.SET_ORDER_PAYED)).thenReturn(true);
		when(request.getParameter("max")).thenReturn("1.1");
		when(request.getParameter("step")).thenReturn("1.1");
		when(request.getParameter("order")).thenReturn("1");
		when(request.getParameter("update")).thenReturn("max");

		uc.execute(request, response);

	}

}
