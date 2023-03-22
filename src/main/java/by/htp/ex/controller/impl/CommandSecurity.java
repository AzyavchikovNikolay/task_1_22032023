package by.htp.ex.controller.impl;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class CommandSecurity {

	private static final String ROLE = "role";
	private static final String ADMIN = "admin";
	private static final String REDACTOR = "redactor";

	public void checkCommandSecurity(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String role = (String) request.getSession().getAttribute(ROLE);
		if (!(ADMIN.equals(role) || (REDACTOR.equals(role)))) {
			request.getRequestDispatcher("/WEB-INF/pages/tiles/error.jsp").forward(request, response);
		}
	}
}
