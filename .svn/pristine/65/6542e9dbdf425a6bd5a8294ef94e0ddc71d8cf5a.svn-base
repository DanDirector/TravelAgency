/**
 * 
 */
package ua.nure.jernovaya.SummaryTask4.commands;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.junit.BeforeClass;
import org.junit.Test;
import org.mockito.Mockito;

/**
 * @author Elmira Jernovaya.
 *
 */
public class SortCommandTest extends Mockito {

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	/**
	 * Test method for
	 * {@link ua.nure.jernovaya.SummaryTask4.commands.SortCommand#execute(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)}
	 * .
	 */
	@Test
	public void testExecute() {
		HttpServletRequest request = mock(HttpServletRequest.class);
		HttpServletResponse response = mock(HttpServletResponse.class);
		HttpSession session = mock(HttpSession.class);
		when(request.getParameter("select")).thenReturn("asc");
		when(request.getSession()).thenReturn(session);
		when(session.getAttribute("simpleTours")).thenReturn(new ArrayList<>());
		when(session.getAttribute("hotTours")).thenReturn(new ArrayList<>());

		new SortCommand().execute(request, response);
		verify(request, atLeast(1)).getSession();
	}

}
