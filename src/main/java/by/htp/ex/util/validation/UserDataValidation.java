package by.htp.ex.util.validation;

import java.util.ArrayList;

import by.htp.ex.bean.User;

public interface UserDataValidation {
	ArrayList<String> checkAuthentData(String login, String password);
	ArrayList<String> checkRegistrationData(User user);
}
