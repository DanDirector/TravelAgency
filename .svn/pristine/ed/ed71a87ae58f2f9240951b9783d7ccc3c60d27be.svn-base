/**
 * 
 */
package ua.nure.jernovaya.SummaryTask4.filters;

import static org.junit.Assert.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.junit.Test;
import org.mockito.Mockito;

import ua.nure.jernovaya.SummaryTask4.entity.Role;
import ua.nure.jernovaya.SummaryTask4.entity.User;

/**
 * @author Elmira
 *
 */
public class RoleFilterTest extends Mockito {

	/**
	 * Test method for {@link ua.nure.jernovaya.SummaryTask4.filters.RoleFilter#doFilter(javax.servlet.ServletRequest, javax.servlet.ServletResponse, javax.servlet.FilterChain)}.
	 * @throws ServletException 
	 * @throws IOException 
	 */
	@Test
	public void testDoFilter() throws IOException, ServletException {
		HttpServletRequest req=mock(HttpServletRequest.class);
		HttpServletResponse res=mock(HttpServletResponse.class);
		FilterChain chain=mock(FilterChain.class);
		HttpSession session=mock(HttpSession.class);
		when(req.getSession()).thenReturn(session);
		User user=new User();
		user.setRole(Role.CLIENT);
		when(session.getAttribute("user")).thenReturn(user);
		List<String>list=new ArrayList<>();
		RoleFilter f=new RoleFilter();
		f.denyComsClientList=list;	
		f.denyPagesClientList=list;
		when(req.getParameter("com")).thenReturn("admin");
		f.doFilter(req, res, chain);
	}

}
