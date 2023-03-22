package by.htp.ex.controller.impl;

import by.htp.ex.controller.Command;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import jakarta.servlet.ServletException;

public class DoSignOut implements Command {

	private static final String SESSION_WARNING = "session_warning";
	private static final String WARNING = "warning";
	private static final String USER = "user";
	private static final String GUEST = "guest";
	private static final String NOT_ACTIVE = "not active";
	private static final String WELCOME = "welcome";
	private static final String ID_USER = "idUser";

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

		int idUser = 0;
		try {
			
			if (request.getSession() == null) {
				request.getSession(true).setAttribute(SESSION_WARNING, WARNING);
				response.sendRedirect("controller?command=go_to_base_page");
			}
			request.getSession().setAttribute(USER, NOT_ACTIVE);
			request.getSession().setAttribute(WELCOME, GUEST);
			request.getSession().setAttribute(ID_USER, idUser);
			response.sendRedirect("controller?command=go_to_base_page");
		} catch (Exception e) {
			request.getRequestDispatcher("/WEB-INF/pages/tiles/error.jsp").forward(request, response);
		}
	}
}
