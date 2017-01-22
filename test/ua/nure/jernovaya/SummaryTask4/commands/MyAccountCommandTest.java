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

import ua.nure.jernovaya.SummaryTask4.dao.OrderDAO;
import ua.nure.jernovaya.SummaryTask4.entity.User;

/**
 * @author Elmira
 *
 */
public class MyAccountCommandTest extends Mockito {

	private static MyAccountCommand mac;

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	 mac=new MyAccountCommand();
		
	}

	/**
	 * Test method for {@link ua.nure.jernovaya.SummaryTask4.commands.MyAccountCommand#execute(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)}.
	 */
	@Test
	public void testExecute() {
		HttpServletRequest request = mock(HttpServletRequest.class);
		HttpServletResponse response = mock(HttpServletResponse.class);
		HttpSession session=mock(HttpSession.class);
		OrderDAO orderDao=mock(OrderDAO.class);
		mac.orderDao=orderDao;
		when(request.getSession()).thenReturn(session);
		User user= new User();
		when(session.getAttribute("user")).thenReturn(user);
		when(orderDao.getOrdersOfUser(user)).thenReturn(null);
		mac.execute(request, response);
		verify(request, atLeast(1)).getSession();
	}

}
