package ua.nure.jernovaya.SummaryTask4.filters;

import java.io.IOException;
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

import ua.nure.jernovaya.SummaryTask4.entity.User;

/**
 * Servlet Filter implementation class RoleFilter
 */
@WebFilter("/RoleFilter")
public class RoleFilter implements Filter {
    List<String> denyComsManagerList, denyPagesManagerList;
	List<String> denyComsClientList;
	List<String> denyPagesClientList;

	/**
	 * Default constructor.
	 */
	public RoleFilter() {

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
		User user = (User) session.getAttribute("user");
		String com = req.getParameter("com");
		if (user != null) {
			switch (user.getRole()) {
			case CLIENT:
				if (com != null && denyComsClientList.contains(com)) {
					res.sendError(401);
				} else {
					String uri = req.getRequestURI();
					for (String string : denyPagesClientList) {
						if (uri.endsWith(string)) {
							res.sendError(401);
						}
					}
					chain.doFilter(request, response);
				}
				break;
			case MANAGER:
				if (com != null && denyComsManagerList.contains(com)) {
					res.sendError(401);
				} else {
					String uri = req.getRequestURI();
					for (String string : denyPagesManagerList) {
						if (uri.endsWith(string)) {
							res.sendError(401);
						}
					}
					chain.doFilter(request, response);
				}
				break; 
			case ADMIN:
				chain.doFilter(request, response);
				break;
			case BLOCKED:
				res.sendError(401);
				break;
			default:
				res.sendError(401);
				break;
			}

		} else {
			chain.doFilter(request, response);
		}
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	@SuppressWarnings("unchecked")
	public void init(FilterConfig fConfig) throws ServletException {
		ServletContext context = fConfig.getServletContext();
		denyComsManagerList = (List<String>) context.getAttribute("denyComsManager");
		denyPagesManagerList = (List<String>) context.getAttribute("denyPagesManager");
		denyComsClientList = (List<String>) context.getAttribute("denyComsClient");
		denyPagesClientList = (List<String>) context.getAttribute("denyPagesClient");
	}

}
