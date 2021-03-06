/**
 * 
 */
package ua.nure.jernovaya.SummaryTask4.commands;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.junit.Test;
import org.mockito.Mockito;

/**
 * @author Elmira Jernovaya.
 *
 */
public class PreviousPageCommandTest extends Mockito {

	/**
	 * Test method for {@link ua.nure.jernovaya.SummaryTask4.commands.PreviousPageCommand#execute(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)}.
	 */
	@Test
	public void testExecute() {
		HttpServletRequest request = mock(HttpServletRequest.class);
		HttpServletResponse response = mock(HttpServletResponse.class);
		HttpSession session = mock(HttpSession.class);
		when(request.getSession()).thenReturn(session);
		when(request.getParameter(Mockito.anyString())).thenReturn(null);
		when(session.getAttribute(Mockito.anyString())).thenReturn(null);
		new PreviousPageCommand().execute(request, response);
		verify(request, atLeast(2)).getParameter(Mockito.anyString());

	}

}
