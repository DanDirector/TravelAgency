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
import ua.nure.jernovaya.SummaryTask4.dao.UserDAO;
import ua.nure.jernovaya.SummaryTask4.entity.User;

/**
 * @author Elmira Jernovaya.
 *
 */
public class ClientsSearchCommandTest extends Mockito {
	static List<User> list=new ArrayList<>();
	private static ClientsSearchCommand csc;

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		csc = new ClientsSearchCommand();
		list.add(new User());
		

	}

	/**
	 * Test method for
	 * {@link ua.nure.jernovaya.SummaryTask4.commands.ClientsSearchCommand#execute(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)}
	 * .
	 */
	@Test
	public void testExecute() {
		HttpServletRequest request = mock(HttpServletRequest.class);
		HttpServletResponse response = mock(HttpServletResponse.class);
		HttpSession session=mock(HttpSession.class);
		when(request.getSession()).thenReturn(session);
		OrderDAO oDao = mock(OrderDAO.class);
		UserDAO uDao = mock(UserDAO.class);
		csc.orderDao = oDao;
		csc.userDao = uDao;
		when(request.getParameter("client")).thenReturn("Anna Sedokova");
		when(uDao.getUserBySecondName("Anna", "Sedokova")).thenReturn(list);
		when(oDao.getOrdersOfUser(Mockito.anyObject())).thenReturn(new ArrayList<>());
		csc.execute(request, response);
		verify(request, atLeast(1)).getParameter("client");
	}

}
