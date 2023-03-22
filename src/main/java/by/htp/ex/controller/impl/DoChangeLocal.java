package by.htp.ex.controller.impl;

import by.htp.ex.controller.Command;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;

import jakarta.servlet.ServletException;
import by.htp.ex.service.ServiceException;

public class DoChangeLocal implements Command {

	private static final String LOCAL = "local";
	private static final String SESSION_WARNING = "session_warning";
	private static final String WARNING = "warning";
	private static final String PREVIOUS_SERVLET_PATH = "prevServletPath";
	private static final String PREVIOUS_QUERY = "prevQuery";
	private static final String MESSAGE = "message";
	private static final String REPEAT = "repeat";

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		try {
			if (request.getSession() == null) {
				String local = request.getParameter(LOCAL);
				request.getSession(true).setAttribute(LOCAL, local);
				request.getSession().setAttribute(SESSION_WARNING, WARNING);
				response.sendRedirect("controller?command=go_to_base_page");
			}
			String prevGetRequest = request.getSession().getAttribute(PREVIOUS_SERVLET_PATH) + "?"
					+ request.getSession().getAttribute(PREVIOUS_QUERY);
			String local = request.getParameter(LOCAL);
			request.getSession().setAttribute(LOCAL, local);
			request.getSession().setAttribute(MESSAGE, REPEAT);
			response.sendRedirect(prevGetRequest);
		} catch (Exception e) {
			request.getRequestDispatcher("WEB-INF/pages/tiles/error.jsp").forward(request, response);
		}
	}
}
