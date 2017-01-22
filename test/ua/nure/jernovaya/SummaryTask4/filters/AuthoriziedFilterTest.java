/**
 * 
 */
package ua.nure.jernovaya.SummaryTask4.filters;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.junit.Test;
import org.mockito.Mockito;

/**
 * @author Elmira
 *
 */
public class AuthoriziedFilterTest extends Mockito {

	/**
	 * Test method for
	 * {@link ua.nure.jernovaya.SummaryTask4.filters.AuthoriziedFilter#doFilter(javax.servlet.ServletRequest, javax.servlet.ServletResponse, javax.servlet.FilterChain)}
	 * .
	 * 
	 * @throws ServletException
	 * @throws IOException
	 */
	@Test
	public void testDoFilter() throws IOException, ServletException {
		HttpSession session = mock(HttpSession.class);
		HttpServletRequest req = mock(HttpServletRequest.class);
		HttpServletResponse res = mock(HttpServletResponse.class);
		when(req.getSession()).thenReturn(session);
		when(req.getParameter("com")).thenReturn("admin");
		FilterChain chain = mock(FilterChain.class);
		AuthoriziedFilter f=new AuthoriziedFilter();
		f.list=new ArrayList<>();
		f.list.add("admin");
		f.doFilter(req, res, chain);
	}

}
