/**
 * 
 */
package ua.nure.jernovaya.SummaryTask4.commands;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.junit.BeforeClass;
import org.junit.Test;
import org.mockito.Mockito;

import ua.nure.jernovaya.SummaryTask4.dao.HotelDAO;
import ua.nure.jernovaya.SummaryTask4.entity.Hotel;

/**
 * @author Elmira Jernovaya.
 *
 */
public class DeleteHotelCommandTest extends Mockito {
	private static DeleteHotelCommand dhc;

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	dhc=new DeleteHotelCommand();
	}

	/**
	 * Test method for {@link ua.nure.jernovaya.SummaryTask4.commands.DeleteHotelCommand#execute(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)}.
	 */
	@Test
	public void testExecute() {
		HttpServletRequest request = mock(HttpServletRequest.class);
		HttpServletResponse response = mock(HttpServletResponse.class);
		HotelDAO dao=mock(HotelDAO.class);
		dhc.hotelDao=dao;
		when(dao.read(2)).thenReturn(new Hotel());
		when(dao.delete(Mockito.anyObject())).thenReturn(true);
		when(request.getParameter("id")).thenReturn("2");
		dhc.execute(request, response);
		verify(request, atLeast(1)).getParameter("id");
	}

}
