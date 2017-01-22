/**
 * 
 */
package ua.nure.jernovaya.SummaryTask4.commands;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.junit.BeforeClass;
import org.junit.Test;
import org.mockito.Mockito;

import ua.nure.jernovaya.SummaryTask4.dao.TourDAO;
import ua.nure.jernovaya.SummaryTask4.entity.Tour;
import ua.nure.jernovaya.SummaryTask4.jdbc.Sqls;

/**
 * @author Elmira
 *
 */
public class HotTourCommandTest extends Mockito {
	private static HotTourCommand htc;

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		htc = new HotTourCommand();
	}

	/**
	 * Test method for
	 * {@link ua.nure.jernovaya.SummaryTask4.commands.HotTourCommand#execute(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)}
	 * .
	 */
	@Test
	public void testExecute() {
		HttpServletRequest request = mock(HttpServletRequest.class);
		HttpServletResponse response = mock(HttpServletResponse.class);
		TourDAO dao = mock(TourDAO.class);
		htc.tourDao = dao;
		when(request.getParameter("tour")).thenReturn("12");
		when(request.getParameter("set")).thenReturn("hot");
		when(request.getParameter("page")).thenReturn(null);
		Tour t = new Tour();
		when(dao.read(12)).thenReturn(t);
		when(dao.update(t, Sqls.UPDATE_TOUR_BY_IS_HOT)).thenReturn(true);

		when(request.getParameter("page")).thenReturn(null);
		htc.execute(request, response);
		verify(request, atLeast(1)).getParameter("tour");
		verify(request, atLeast(1)).getParameter("page");
	}

}
