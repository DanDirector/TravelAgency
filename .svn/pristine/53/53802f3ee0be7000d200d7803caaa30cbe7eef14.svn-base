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

/**
 * @author Elmira Jernovaya.
 *
 */
public class UpdateTourCommandTest extends Mockito {

	private static UpdateTourCommand utc;

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		utc=new UpdateTourCommand();
	}

	/**
	 * Test method for {@link ua.nure.jernovaya.SummaryTask4.commands.UpdateTourCommand#execute(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)}.
	 */
	@Test
	public void testExecute() {
		HttpServletRequest request = mock(HttpServletRequest.class);
		HttpServletResponse response = mock(HttpServletResponse.class);
		TourDAO tourDao=mock(TourDAO.class);
		utc.tourDAO=tourDao;
		when(tourDao.read(Mockito.anyInt())).thenReturn(null);
		when(request.getParameter(Mockito.anyString())).thenReturn(null);
		utc.execute(request, response);
		verify(request, atLeast(8)).getParameter(Mockito.anyString());	
		
	}

}
