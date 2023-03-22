package by.htp.ex.service.impl;

import by.htp.ex.service.IUserService;
import by.htp.ex.service.ServiceException;

import java.util.ArrayList;

import by.htp.ex.bean.User;
import by.htp.ex.dao.DaoException;
import by.htp.ex.dao.IUserDAO;
import by.htp.ex.dao.DaoProvider;
import by.htp.ex.util.validation.UserDataValidationImpl;

public class UserServiceImpl implements IUserService {

	private static final String GUEST = "guest";

	private final IUserDAO userDAO = DaoProvider.getInstance().getUserDao();

	@Override
	public String signIn(String login, String password) throws ServiceException {

		try {

			UserDataValidationImpl validator = new UserDataValidationImpl();
			ArrayList<String> checkAuthenErrors = validator.checkAuthentData(login, password);
			String errors = "";
			for (String error : checkAuthenErrors) {
				errors = errors + error + ", ";
			}

			if (errors.length() != 0) {
				return errors;
			} else {
				return userDAO.logination(login, password);
			}

		} catch (DaoException e) {
			throw new ServiceException(e);
		}
	}

	@Override
	public int findIdUser(String login, String password) throws ServiceException {

		try {
			return userDAO.idUser(login, password);
		} catch (DaoException e) {
			throw new ServiceException(e);
		}
	}

	@Override
	public String registration(User user) throws ServiceException {

		try {
			UserDataValidationImpl validator = new UserDataValidationImpl();
			ArrayList<String> registrationErrors = validator.checkRegistrationData(user);
			String errors = "";
			for (String error : registrationErrors) {
				errors = errors + error + ", ";
			}

			if (errors.length() != 0) {
				return errors;
			} else if (userDAO.registration(user)) {
				return user.getRole();
			} else {
				return GUEST;
			}
		} catch (DaoException e) {
			throw new ServiceException(e);
		}
	}
}
