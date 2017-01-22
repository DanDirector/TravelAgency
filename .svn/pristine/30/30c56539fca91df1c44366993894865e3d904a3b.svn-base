package ua.nure.jernovaya.SummaryTask4.commands;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.junit.BeforeClass;
import org.junit.Test;
import org.mockito.Mockito;

import ua.nure.jernovaya.SummaryTask4.dao.TourDAO;
import ua.nure.jernovaya.SummaryTask4.entity.User;
import ua.nure.jernovaya.SummaryTask4.jdbc.Sqls;

/**
 * 
 * @author Elmira Jernovaya.
 *
 */
public class CountriesCommandTest extends Mockito {
	private static CountriesCommand ccc;

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		ccc = new CountriesCommand();

	}

	@Test
	public void testExecute() {
		HttpServletRequest request = mock(HttpServletRequest.class);
		HttpServletResponse response = mock(HttpServletResponse.class);
		HttpSession session=mock(HttpSession.class);
		when(request.getSession()).thenReturn(session);
		when(request.getParameter("country")).thenReturn("C");
		TourDAO dao = mock(TourDAO.class);
		ccc.dao = dao;
		when(dao.getToursByCountry(Sqls.SELECT_HOT_TOURS_BY_COUNTRY, "C")).thenReturn(null);
		when(dao.getToursByCountry(Sqls.SELECT_SIMPLE_TOURS_BY_COUNTRY, "C")).thenReturn(null);

		ccc.execute(request, response);
		verify(request, atLeast(1)).getParameter("country");

	}

}
