/**
 * 
 */
package ua.nure.jernovaya.SummaryTask4.commands;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.junit.BeforeClass;
import org.junit.Test;
import org.mockito.Mockito;

/**
 * @author Elmira Jernovaya.
 *
 */
public class InvokerTest extends Mockito {

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		
	}
	/**
	 * Test method for {@link ua.nure.jernovaya.SummaryTask4.commands.Invoker#execute(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)}.
	 */
	@Test
	public void testExecute() {
		HttpServletRequest request = mock(HttpServletRequest.class);
		HttpServletResponse response = mock(HttpServletResponse.class);
		new Invoker("login").execute(request, response);
		new Invoker(null).execute(request, response);
		new Invoker("abc").execute(request, response);
	}

}
