/**
 * 
 */
package ua.nure.jernovaya.SummaryTask4.commands;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.junit.Test;
import org.mockito.Mockito;

/**
 * @author Elmira Jernovaya.
 *
 */
public class NewTourCommandTest extends Mockito {


	/**
	 * Test method for {@link ua.nure.jernovaya.SummaryTask4.commands.NewTourCommand#execute(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)}.
	 */
	@Test
	public void testExecute() {
		HttpServletRequest request = mock(HttpServletRequest.class);
		HttpServletResponse response = mock(HttpServletResponse.class);
		when(request.getParameter(Mockito.anyString())).thenReturn("param");
		new NewTourCommand().execute(request, response);
		verify(request, atLeast(7)).getParameter(Mockito.anyString());
	}

}
