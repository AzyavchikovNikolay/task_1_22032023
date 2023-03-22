package by.htp.ex.controller.impl;

import java.io.IOException;

import by.htp.ex.controller.Command;
import by.htp.ex.service.ServiceProvider;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import by.htp.ex.service.IUserService;
import by.htp.ex.service.ServiceException;
import by.htp.ex.bean.User;

public class DoRegistration implements Command {

	private final IUserService service = ServiceProvider.getInstance().getUserService();

	private static final String JSP_LOGIN_REG_PARAM = "loginReg";
	private static final String JSP_PASSWORD_REG_PARAM = "passwordReg";
	private static final String JSP_ROLE_PARAM = "role";
	private static final String JSP_SURNAME_PARAM = "surname";
	private static final String JSP_NAME_PARAM = "name";
	private static final String JSP_PHONE_PARAM = "phone";
	private static final String JSP_EMAIL_PARAM = "email";
	private static final String JSP_BIRTHDAY_PARAM = "birthday";
	private static final String SESSION_WARNING = "session_warning";
	private static final String WARNING = "warning";
	private static final String REGISTRATION_WARNING = "warningReg";
	private static final String REGISTRATION_WARNING_USER_EXISTS = "warningReg2";

	private static final String LOGIN_INVALID = "login invalid";
	private static final String PASSWORD_INVALID = "password invalid";
	private static final String NAME_INVALID = "name invalid";
	private static final String SURNAME_INVALID = "surname invalid";
	private static final String PHONE_INVALID = "phone invalid";
	private static final String EMAIL_INVALID = "email invalid";
	private static final String BIRTHDAY_INVALID = "birthday invalid";

	private static final String LOGIN_INVALID_BUNDLE_KEY = "local.registration_form.login_invalid";
	private static final String PASSWORD_INVALID_BUNDLE_KEY = "local.registration_form.password_invalid";
	private static final String NAME_INVALID_BUNDLE_KEY = "local.registration_form.name_invalid";
	private static final String SURNAME_INVALID_BUNDLE_KEY = "local.registration_form.surname_invalid";
	private static final String PHONE_INVALID_BUNDLE_KEY = "local.registration_form.phone_invalid";
	private static final String EMAIL_INVALID_BUNDLE_KEY = "local.registration_form.email_invalid";
	private static final String BIRTHDAY_INVALID_BUNDLE_KEY = "local.registration_form.birthday_invalid";

	private static final String ADMIN = "admin";
	private static final String REDACTOR = "redactor";
	private static final String USER = "user";
	private static final String GUEST = "guest";

	private static final String REGISTRATION = "registration";
	private static final String SUCCESS = "success";
	private static final String ACTIVE = "active";
	private static final String ROLE = "role";
	private static final String REGISTRATION_DATA = "registrationData";

	private static final String SESSION_ATTRIBUTE_LOGIN_INVALID = "loginInvalid";
	private static final String SESSION_ATTRIBUTE_PASSWORD_INVALID = "passwordInvalid";
	private static final String SESSION_ATTRIBUTE_NAME_INVALID = "nameInvalid";
	private static final String SESSION_ATTRIBUTE_SURNAME_INVALID = "surnameInvalid";
	private static final String SESSION_ATTRIBUTE_PHONE_INVALID = "phoneInvalid";
	private static final String SESSION_ATTRIBUTE_EMAIL_INVALID = "emailInvalid";
	private static final String SESSION_ATTRIBUTE_BIRTHDAY_INVALID = "birthdayInvalid";

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String loginReg = request.getParameter(JSP_LOGIN_REG_PARAM);
		String passwordReg = request.getParameter(JSP_PASSWORD_REG_PARAM);
		String role = request.getParameter(JSP_ROLE_PARAM);
		String surname = request.getParameter(JSP_SURNAME_PARAM);
		String name = request.getParameter(JSP_NAME_PARAM);
		String phone = request.getParameter(JSP_PHONE_PARAM);
		String email = request.getParameter(JSP_EMAIL_PARAM);
		String birthday = request.getParameter(JSP_BIRTHDAY_PARAM);

		try {
			CommandSecurity checkCommand = new CommandSecurity();
			checkCommand.checkCommandSecurity(request, response);

			if (request.getSession() == null) {
				request.getSession(true).setAttribute(SESSION_WARNING, WARNING);
				response.sendRedirect("controller?command=go_to_base_page");
			}
			User u = new User(loginReg, passwordReg, role, surname, name, phone, email, birthday);
			String check = "";

			if (check.equals(loginReg) || check.equals(passwordReg) || check.equals(role) || check.equals(surname)
					|| check.equals(name) || check.equals(phone) || check.equals(email) || check.equals(birthday)) {
				request.getSession().setAttribute(REGISTRATION_WARNING, WARNING);
				response.sendRedirect("controller?command=go_to_registration_page");

			} else {

				String loginInvalid = null;
				String passwordInvalid = null;
				String nameInvalid = null;
				String surnameInvalid = null;
				String phoneInvalid = null;
				String emailInvalid = null;
				String birthdayInvalid = null;

				String role1 = service.registration(u);
				String[] errors = role1.split(", ");
				for (String error : errors) {
					if (LOGIN_INVALID.equals(error)) {
						loginInvalid = LOGIN_INVALID_BUNDLE_KEY;
					}
					if (PASSWORD_INVALID.equals(error)) {
						passwordInvalid = PASSWORD_INVALID_BUNDLE_KEY;
					}
					if (NAME_INVALID.equals(error)) {
						nameInvalid = NAME_INVALID_BUNDLE_KEY;
					}
					if (SURNAME_INVALID.equals(error)) {
						surnameInvalid = SURNAME_INVALID_BUNDLE_KEY;
					}
					if (PHONE_INVALID.equals(error)) {
						phoneInvalid = PHONE_INVALID_BUNDLE_KEY;
					}
					if (EMAIL_INVALID.equals(error)) {
						emailInvalid = EMAIL_INVALID_BUNDLE_KEY;
					}
					if (BIRTHDAY_INVALID.equals(error)) {
						birthdayInvalid = BIRTHDAY_INVALID_BUNDLE_KEY;
					}
				}
				if (ADMIN.equals(role1) || REDACTOR.equals(role1) || USER.equals(role1)) {
					request.getSession().setAttribute(REGISTRATION, SUCCESS);
					request.getSession(true).setAttribute(USER, ACTIVE);
					request.getSession(true).setAttribute(ROLE, role1);
					User uCleanData = null;
					request.getSession().setAttribute(REGISTRATION_DATA, uCleanData);
					response.sendRedirect("controller?command=go_to_news_list");
				} else if (role1.equals(GUEST)) {
					request.getSession().setAttribute(REGISTRATION_WARNING_USER_EXISTS, WARNING);
					response.sendRedirect("controller?command=go_to_registration_page");
				} else {
					request.getSession().setAttribute(SESSION_ATTRIBUTE_LOGIN_INVALID, loginInvalid);
					request.getSession().setAttribute(SESSION_ATTRIBUTE_PASSWORD_INVALID, passwordInvalid);
					request.getSession().setAttribute(SESSION_ATTRIBUTE_NAME_INVALID, nameInvalid);
					request.getSession().setAttribute(SESSION_ATTRIBUTE_SURNAME_INVALID, surnameInvalid);
					request.getSession().setAttribute(SESSION_ATTRIBUTE_PHONE_INVALID, phoneInvalid);
					request.getSession().setAttribute(SESSION_ATTRIBUTE_EMAIL_INVALID, emailInvalid);
					request.getSession().setAttribute(SESSION_ATTRIBUTE_BIRTHDAY_INVALID, birthdayInvalid);
					request.getSession().setAttribute(REGISTRATION_DATA, u);
					response.sendRedirect("controller?command=go_to_registration_page");
				}
			}
		} catch (ServiceException e) {
			request.getRequestDispatcher("/WEB-INF/pages/tiles/error.jsp").forward(request, response);
		}
	}
}