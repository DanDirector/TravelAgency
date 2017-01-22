/**
 * 
 */
package ua.nure.jernovaya.SummaryTask4.filters;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.junit.Test;
import org.mockito.Mockito;

/**
 * @author Elmira
 *
 */
public class EncodingFilterTest extends Mockito {

	/**
	 * Test method for {@link ua.nure.jernovaya.SummaryTask4.filters.EncodingFilter#doFilter(javax.servlet.ServletRequest, javax.servlet.ServletResponse, javax.servlet.FilterChain)}.
	 * @throws ServletException 
	 * @throws IOException 
	 */
	@Test
	public void testDoFilter() throws IOException, ServletException {
		HttpServletRequest req=mock(HttpServletRequest.class);
		HttpServletResponse res=mock(HttpServletResponse.class);
		FilterChain chain=mock(FilterChain.class);
		new EncodingFilter().doFilter(req, res, chain);
	}

}
