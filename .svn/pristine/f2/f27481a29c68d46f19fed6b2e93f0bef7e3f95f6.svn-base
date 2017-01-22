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

/**
 * @author Elmira Jernovaya.
 *
 */
public class DeleteTourCommandTest extends Mockito {
	private static DeleteTourCommand dtc;
	/**
	 * @throws java.lang.Exception
	 */
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	dtc=new DeleteTourCommand();
	}
	/**
	 * Test method for
	 * {@link ua.nure.jernovaya.SummaryTask4.commands.DeleteTourCommand#execute(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)}
	 * .
	 */
	@Test
	public void testExecute() {
		HttpServletRequest request = mock(HttpServletRequest.class);
		HttpServletResponse response = mock(HttpServletResponse.class);
		TourDAO dao=mock(TourDAO.class);
		dtc.tourDao=dao;
		when(request.getParameter("tourId")).thenReturn("12");
		when(dao.read(12)).thenReturn(new Tour());
		when(dao.delete(Mockito.anyObject())).thenReturn(true);
		
		dtc.execute(request, response);
		verify(request, atLeast(1)).getParameter("tourId");
	}

}
