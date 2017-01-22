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

import ua.nure.jernovaya.SummaryTask4.dao.HotelDAO;

/**
 * @author Elmira
 *
 */
public class SearchHotelsCommandTest extends Mockito {

	private static SearchHotelsCommand shc;

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		shc=new SearchHotelsCommand();
	}

	/**
	 * Test method for {@link ua.nure.jernovaya.SummaryTask4.commands.SearchHotelsCommand#execute(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)}.
	 */
	@Test
	public void testExecute() {
		HttpServletRequest request = mock(HttpServletRequest.class);
		HttpServletResponse response = mock(HttpServletResponse.class);
		HttpSession session=mock(HttpSession.class);
		HotelDAO hotelDao=mock(HotelDAO.class);
		shc.hotelDao=hotelDao;
		when(request.getSession()).thenReturn(session);
		when(request.getParameter(Mockito.anyString())).thenReturn(null);
		when(hotelDao.getHotelsByCountry(Mockito.anyString())).thenReturn(null);
		shc.execute(request, response);
		verify(request, atLeast(1)).getSession();
	}

}
