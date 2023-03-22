package by.htp.ex.filters;

import java.io.IOException;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class SessionNullFilter implements Filter {

	private static final String SESSION_ATTRIBUTE_WARNING = "session_warning";
	private static final String WARNING = "warning";

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {

		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse resp = (HttpServletResponse) response;

		if (req.getSession() == null) {
			req.getSession(true).setAttribute(SESSION_ATTRIBUTE_WARNING, WARNING);
			resp.sendRedirect("controller?command=go_to_base_page");
		}
		chain.doFilter(request, response);
	}

	@Override
	public void destroy() {
	}
}
