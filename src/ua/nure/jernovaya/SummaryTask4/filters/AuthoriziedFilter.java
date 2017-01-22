package ua.nure.jernovaya.SummaryTask4.filters;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

/**
 * Servlet Filter implementation class AuthoriziedFilter
 */
@WebFilter("/AuthoriziedFilter")
public class AuthoriziedFilter implements Filter {
	/**
	 * Logger.
	 */
	static final Logger LOGGER = Logger.getLogger(AuthoriziedFilter.class);
	 List<String> list, list1;

	/**
	 * Default constructor.
	 */
	public AuthoriziedFilter() { 
	}

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse res = (HttpServletResponse) response;
		HttpSession session = req.getSession(); 
		String com = req.getParameter("com");
			if (list.contains(com)) {
			if (session.getAttribute("user") == null) {
				res.sendRedirect("login.jsp");
			} 
			else {
				chain.doFilter(request, response);
			}
		}
		else {
			String uri = req.getRequestURI(); 
			for (String string : list1) {
				if (uri.endsWith(string) && session.getAttribute("user") == null) {
					res.sendRedirect("login.jsp");
				}
			}
			chain.doFilter(request, response);
		} 

		
		

	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	@SuppressWarnings("unchecked")
	public void init(FilterConfig fConfig) throws ServletException {
		ServletContext context = fConfig.getServletContext();
		list = (ArrayList<String>) context.getAttribute("authoriziedList");
		list1 = (ArrayList<String>) context.getAttribute("pagesList");
	}

}
