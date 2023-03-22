package by.htp.ex.util.validation;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import by.htp.ex.bean.User;

public class UserDataValidationImpl implements UserDataValidation {

	private static final String LOGIN_ERROR = "login invalid";
	private static final String PASSWORD_ERROR = "password invalid";
	private static final String NAME_ERROR = "name invalid";
	private static final String SURNAME_ERROR = "surname invalid";
	private static final String PHONE_ERROR = "phone invalid";
	private static final String EMAIL_ERROR = "email invalid";
	private static final String BIRTHDAY_ERROR = "birthday invalid";

	private static final String LOGIN_PATTERN = "^[a-zA-Z0-9-]{1,45}$";
	private static final String PASSWORD_PATTERN = "^[a-zA-Z0-9-]{1,45}$";
	private static final String NAME_PATTERN = "^[a-zA-Z-]{1,20}$";
	private static final String SURNAME_PATTERN = "^[a-zA-Z-]{1,45}$";
	private static final String PHONE_PATTERN = "([0-9]{12})?$";
	private static final String EMAIL_PATTERN = "^[a-zA-Z0-9-]+(\\.[a-zA-Z0-9-]+)*@[a-zA-Z0-9-]+(\\.[a-zA-Z0-9]+)*(\\.[a-zA-Z]{2,})$";
	private static final String BIRTHDAY_PATTERN = "((19|20)\\d\\d)\\-(0[1-9]|1[012])\\-(0[1-9]|[12][0-9]|3[01])";

	@Override
	public ArrayList<String> checkAuthentData(String login, String password) {

		ArrayList<String> checkAuthenErrors = new ArrayList<String>();

		Pattern loginPattern = Pattern.compile(LOGIN_PATTERN);
		Matcher loginMatcher = loginPattern.matcher(login);
		if (!loginMatcher.matches()) {
			checkAuthenErrors.add(LOGIN_ERROR);
		}

		Pattern passwordPattern = Pattern.compile(PASSWORD_PATTERN);
		Matcher passwordMatcher = passwordPattern.matcher(password);
		if (!passwordMatcher.matches()) {
			checkAuthenErrors.add(PASSWORD_ERROR);
		}

		return checkAuthenErrors;
	}

	@Override
	public ArrayList<String> checkRegistrationData(User user) {

		ArrayList<String> registrationErrors = new ArrayList<String>();

		String login = user.getLogin();
		String password = user.getPassword();
		String name = user.getName();
		String surname = user.getSurname();
		String phone = user.getPhone();
		String email = user.getEmail();
		String birthday = user.getBirthday();

		Pattern loginPattern = Pattern.compile(LOGIN_ERROR);
		Matcher loginMatcher = loginPattern.matcher(login);
		if (!loginMatcher.matches()) {
			registrationErrors.add(LOGIN_ERROR);
		}

		Pattern passwordPattern = Pattern.compile(PASSWORD_ERROR);
		Matcher passwordMatcher = passwordPattern.matcher(password);
		if (!passwordMatcher.matches()) {
			registrationErrors.add(PASSWORD_ERROR);
		}

		Pattern namePattern = Pattern.compile(NAME_PATTERN);
		Matcher nameMatcher = namePattern.matcher(name);
		if (!nameMatcher.matches()) {
			registrationErrors.add(NAME_ERROR);
		}

		Pattern surnamePattern = Pattern.compile(SURNAME_PATTERN);
		Matcher surnameMatcher = surnamePattern.matcher(surname);
		if (!surnameMatcher.matches()) {
			registrationErrors.add(SURNAME_ERROR);
		}

		Pattern phonePattern = Pattern.compile(PHONE_PATTERN);
		Matcher phoneMatcher = phonePattern.matcher(phone);
		if (!phoneMatcher.matches()) {
			registrationErrors.add(PHONE_ERROR);
		}

		Pattern emailPattern = Pattern.compile(EMAIL_PATTERN);
		Matcher emailMatcher = emailPattern.matcher(email);
		if (!emailMatcher.matches()) {
			registrationErrors.add(EMAIL_ERROR);
		}

		Pattern birthdayPattern = Pattern.compile(BIRTHDAY_PATTERN);
		Matcher birthdayMatcher = birthdayPattern.matcher(birthday);
		if (!birthdayMatcher.matches()) {
			registrationErrors.add(BIRTHDAY_ERROR);
		}

		return registrationErrors;
	}
}
