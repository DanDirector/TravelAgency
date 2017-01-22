package ua.nure.jernovaya.SummaryTask4.commands;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.junit.BeforeClass;
import org.junit.Test;
import org.mockito.Mockito;

import ua.nure.jernovaya.SummaryTask4.dao.HotelDAO;

public class AddHotelCommandTest extends Mockito {

	private static AddHotelCommand ahc;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		ahc = new AddHotelCommand();
	}

	@Test
	public void testExecute() {
		HttpServletRequest request = mock(HttpServletRequest.class);
		HttpServletResponse response = mock(HttpServletResponse.class);
		when(request.getParameter("name")).thenReturn("Hotel");
		when(request.getParameter("rate")).thenReturn("4");
		when(request.getParameter("nut")).thenReturn("AL");
		when(request.getParameter("country")).thenReturn("Austria");
		when(request.getParameter("city")).thenReturn("Vienna");
		when(request.getParameter("desc")).thenReturn("description");
		HotelDAO hotelDao = mock(HotelDAO.class);
		ahc.hotelDao = hotelDao;
		when(hotelDao.create(Mockito.anyObject())).thenReturn(true);
		ahc.execute(request, response);
		verify(request, atLeast(1)).getParameter("country");
		verify(request, atLeast(1)).getParameter("nut");
	}

}
