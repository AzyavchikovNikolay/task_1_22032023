package by.htp.ex.controller.impl;

import java.io.IOException;

import by.htp.ex.controller.Command;
import by.htp.ex.service.ServiceException;
import by.htp.ex.service.ServiceProvider;
import by.htp.ex.service.IUserService;
import by.htp.ex.service.impl.UserServiceImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class DoSignIn implements Command {

	private final IUserService service = ServiceProvider.getInstance().getUserService();
	private static final String JSP_LOGIN_PARAM = "login";
	private static final String JSP_PASSWORD_PARAM = "password";
	private static final String SESSION_WARNING = "session_warning";
	private static final String WARNING = "warning";
	private static final String ADMIN = "admin";
	private static final String REDACTOR = "redactor";
	private static final String USER = "user";
	private static final String GUEST = "guest";
	private static final String ROLE = "role";

	private static final String ACTIVE = "active";
	private static final String NOT_ACTIVE = "not active";
	private static final String WELCOME = "welcome";
	private static final String ID_USER = "idUser";
	private static final String AUTHENTIFICATION_ERROR = "AuthenticationError";

	private static final String LOGIN_INVALID = "login invalid";
	private static final String PASSWORD_INVALID = "password invalid";

	private static final String LOGIN_INVALID_BUNDLE_KEY = "local.registration_form.login_invalid";
	private static final String PASSWORD_INVALID_BUNDLE_KEY = "local.registration_form.password_invalid";
	private static final String AUTHENTIFICATION_ERROR_BUNDLE_KEY = "local.registration.auth_error";

	private static final String SESSION_ATTRIBUTE_LOGIN_INVALID = "loginInvalid";
	private static final String SESSION_ATTRIBUTE_PASSWORD_INVALID = "passwordInvalid";

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String login;
		String password;
		login = request.getParameter(JSP_LOGIN_PARAM);
		password = request.getParameter(JSP_PASSWORD_PARAM);
		int idUser = 0;
		try {

			if (request.getSession() == null) {
				request.getSession(true).setAttribute(SESSION_WARNING, WARNING);
				response.sendRedirect("controller?command=go_to_base_page");
			}
			String role = service.signIn(login, password);

			if (ADMIN.equals(role) || REDACTOR.equals(role) || USER.equals(role)) {
				idUser = service.findIdUser(login, password);
				request.getSession().setAttribute(USER, ACTIVE);
				request.getSession().setAttribute(WELCOME, login);
				request.getSession().setAttribute(ROLE, role);
				request.getSession().setAttribute(ID_USER, idUser);
				response.sendRedirect("controller?command=go_to_news_list");
			} else if (role.equals(GUEST)) {
				request.getSession().setAttribute(USER, NOT_ACTIVE);
				request.setAttribute(AUTHENTIFICATION_ERROR, AUTHENTIFICATION_ERROR_BUNDLE_KEY);
				request.getRequestDispatcher("/WEB-INF/pages/layouts/baseLayout.jsp").forward(request, response);
			} else {
				String loginInvalid = null;
				String passwordInvalid = null;
				String[] errors = role.split(", ");
				for (String error : errors) {
					if (LOGIN_INVALID.equals(error)) {
						loginInvalid = LOGIN_INVALID_BUNDLE_KEY;
					}
					if (PASSWORD_INVALID.equals(error)) {
						passwordInvalid = PASSWORD_INVALID_BUNDLE_KEY;
					}
				}

				request.getSession().setAttribute(USER, NOT_ACTIVE);
				request.setAttribute(SESSION_ATTRIBUTE_LOGIN_INVALID, loginInvalid);
				request.setAttribute(SESSION_ATTRIBUTE_PASSWORD_INVALID, passwordInvalid);
				request.getRequestDispatcher("/WEB-INF/pages/layouts/baseLayout.jsp").forward(request, response);
			}
		} catch (ServiceException e) {
			request.getRequestDispatcher("/WEB-INF/pages/tiles/error.jsp").forward(request, response);
		}
	}
}
