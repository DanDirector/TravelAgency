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

import ua.nure.jernovaya.SummaryTask4.dao.TourDAO;

/**
 * @author Elmira Jernovaya.
 *
 */
public class AllToursCommandTest extends Mockito {

	private static AllToursCommand atc;

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		atc=new AllToursCommand();
	}

	/**
	 * Test method for {@link ua.nure.jernovaya.SummaryTask4.commands.AllToursCommand#execute(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)}.
	 */
	@Test
	public void testExecute() {
		HttpServletRequest request = mock(HttpServletRequest.class);
		HttpServletResponse response = mock(HttpServletResponse.class);
		HttpSession session=mock(HttpSession.class);
		when(request.getSession()).thenReturn(session);
		TourDAO dao=mock(TourDAO.class);
		atc.tourDAO=dao;
		when(dao.getAllTours(Mockito.anyString())).thenReturn(null);
		atc.execute(request, response);
		verify(request, atLeast(1)).getSession();
	}

}


















