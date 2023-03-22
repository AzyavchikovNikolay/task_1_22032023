package by.htp.ex.filters;

import java.io.IOException;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServletRequest;

public class FilterRequestMethod implements Filter {

	private static final String METHOD_GET = "GET";
	private static final String PREVIOUS_SERVLET_PATH = "prevServletPath";
	private static final String CURRENT_SERVLET_PATH = "curServletPath";
	private static final String PREVIOUS_QUERY = "prevQuery";
	private static final String CURRENT_QUERY = "curQuery";

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {

		Filter.super.init(filterConfig);
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {

		HttpServletRequest req = (HttpServletRequest) request;
		String method = req.getMethod();
		String SPath = req.getServletPath().toString().substring(1);
		String query = req.getQueryString();
		if (method.equals(METHOD_GET)) {
			req.getSession().setAttribute(PREVIOUS_SERVLET_PATH, req.getSession().getAttribute(CURRENT_SERVLET_PATH));
			req.getSession().setAttribute(PREVIOUS_QUERY, req.getSession().getAttribute(CURRENT_QUERY));
			req.getSession().setAttribute(CURRENT_SERVLET_PATH, SPath);
			req.getSession().setAttribute(CURRENT_QUERY, query);
		}
		chain.doFilter(request, response);
	}

	@Override
	public void destroy() {
	}
}
