/**
 * 
 */
package ua.nure.jernovaya.SummaryTask4.commands;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.junit.BeforeClass;
import org.junit.Test;
import org.mockito.Mockito;

import ua.nure.jernovaya.SummaryTask4.dao.HotelDAO;
import ua.nure.jernovaya.SummaryTask4.dao.TourDAO;
import ua.nure.jernovaya.SummaryTask4.entity.Tour;
import ua.nure.jernovaya.SummaryTask4.jdbc.Sqls;

/**
 * @author Elmira Jernovaya.
 *
 */
public class AdminCommandTest extends Mockito {

	private static AdminCommand ac;
	private static List<Tour> list;

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		ac = new AdminCommand();
		list=new ArrayList<>();
		list.add(new Tour());
		list.add(new Tour());
	}

	/**
	 * Test method for
	 * {@link ua.nure.jernovaya.SummaryTask4.commands.AdminCommand#execute(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)}
	 * .
	 */
	@Test
	public void testExecute() {
		HttpServletRequest request = mock(HttpServletRequest.class);
		HttpServletResponse response = mock(HttpServletResponse.class);
		HttpSession session = mock(HttpSession.class);
		HotelDAO hotelDao = mock(HotelDAO.class);
		TourDAO tourDao = mock(TourDAO.class);
		ac.hotelDao = hotelDao;
		ac.tourDao = tourDao;
		when(request.getSession()).thenReturn(session);
		when(request.getParameter("select")).thenReturn(null);
		
		when(tourDao.getAllTours(Mockito.anyString())).thenReturn(list);
		when(hotelDao.getAllHotels()).thenReturn(null);
		ac.execute(request, response);
	}
	/**
	 * Test method for
	 * {@link ua.nure.jernovaya.SummaryTask4.commands.AdminCommand#execute(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)}
	 * .
	 */
	@Test
	public void testExecute2() {
		HttpServletRequest request = mock(HttpServletRequest.class);
		HttpServletResponse response = mock(HttpServletResponse.class);
		HttpSession session = mock(HttpSession.class);
		HotelDAO hotelDao = mock(HotelDAO.class);
		TourDAO tourDao = mock(TourDAO.class);
		ac.hotelDao = hotelDao;
		ac.tourDao = tourDao;
		when(request.getSession()).thenReturn(session);
		when(request.getParameter("select")).thenReturn("select");
		when(request.getParameter("selectType")).thenReturn("select");
		when(request.getParameter("selectCountry")).thenReturn("select");
		when(request.getParameter("selectRate")).thenReturn("select");
		when(request.getParameter("from")).thenReturn("12.2");
		when(request.getParameter("to")).thenReturn("12.2");
		when(request.getParameter("people")).thenReturn("2");
		when(request.getParameter("date")).thenReturn("2012-12-12");
		Date date=Date.valueOf("2012-12-12");
		when(tourDao.getToursByParameters(Sqls.SELECT_All_TOURS_BY_PARAMETERS, 12.2, 12.2, 2, "select","select", "select", date)).thenReturn(list);
		when(hotelDao.getAllHotels()).thenReturn(null);
		ac.execute(request, response);
	}
	/**
	 * Test method for
	 * {@link ua.nure.jernovaya.SummaryTask4.commands.AdminCommand#execute(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)}
	 * .
	 */
	@Test
	public void testExecute3() {
		HttpServletRequest request = mock(HttpServletRequest.class);
		HttpServletResponse response = mock(HttpServletResponse.class);
		HttpSession session = mock(HttpSession.class);
		HotelDAO hotelDao = mock(HotelDAO.class);
		TourDAO tourDao = mock(TourDAO.class);
		ac.hotelDao = hotelDao;
		ac.tourDao = tourDao;
		when(request.getSession()).thenReturn(session);
		when(request.getParameter("hotel")).thenReturn("23");
		when(tourDao.getToursByHotelId(23)).thenReturn(list);
		when(hotelDao.getAllHotels()).thenReturn(null);
		ac.execute(request, response);
	}
	/**
	 * Test method for
	 * {@link ua.nure.jernovaya.SummaryTask4.commands.AdminCommand#execute(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)}
	 * .
	 */
	@Test
	public void printTest() {
		HttpSession session = mock(HttpSession.class);
		ac.printBox(list, session, "in", "page");
		
	}

}
