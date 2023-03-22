package by.htp.ex.controller.impl;

import java.io.IOException;
import java.util.Enumeration;

import by.htp.ex.bean.News;
import by.htp.ex.bean.User;
import by.htp.ex.controller.Command;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import by.htp.ex.service.INewsService;
import by.htp.ex.service.ServiceException;
import by.htp.ex.service.ServiceProvider;

public class GoToRegistrationPageCommand implements Command {

	private static final String NEWS = "news";
	private static final String REGISTRATION = "registration";
	private static final String REGISTRATION_DATA = "registrationData";
	private static final String SESSION_WARNING = "session_warning";
	private static final String WARNING = "warning";
	private static final String PRESENTATION = "presentation";
	private static final String USER = "user";
	private static final String NOT_ACTIVE = "not active";

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		try {
			if (NEWS.equals(request.getParameter(REGISTRATION))) {
				User uCleanData = null;
				request.getSession().setAttribute(REGISTRATION_DATA, uCleanData);
			}

			if (request.getSession() == null) {
				request.getSession(true).setAttribute(SESSION_WARNING, WARNING);
				response.sendRedirect("controller?command=go_to_base_page");
			}

			request.getSession().setAttribute(PRESENTATION, REGISTRATION);
			request.getSession().setAttribute(USER, NOT_ACTIVE);
			request.getRequestDispatcher("WEB-INF/pages/layouts/baseLayout.jsp").forward(request, response);
		} catch (Exception e) {
			request.getRequestDispatcher("/WEB-INF/pages/tiles/error.jsp").forward(request, response);
		}
	}
}
