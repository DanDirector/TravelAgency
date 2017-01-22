/**
 * 
 */
package ua.nure.jernovaya.SummaryTask4.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.junit.Test;
import org.mockito.Mockito;

/**
 * @author Elmira Jernovaya.
 *
 */
public class ControllerTest extends Mockito {

	/**
	 * Test method for {@link ua.nure.jernovaya.SummaryTask4.controller.Controller#doGet(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)}.
	 * @throws IOException 
	 * @throws ServletException 
	 */
	@Test
	public void testDoGetHttpServletRequestHttpServletResponse() throws ServletException, IOException {
		HttpServletRequest request = mock(HttpServletRequest.class);
		HttpServletResponse response = mock(HttpServletResponse.class);
		
		when(request.getParameter("com")).thenReturn("login");
		
		new Controller().doGet(request, response);
		verify(request, atLeast(1)).getParameter("com");
		
	}

}
