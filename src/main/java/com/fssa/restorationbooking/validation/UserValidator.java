package com.fssa.restorationbooking.validation;

import java.util.regex.Pattern;

import com.fssa.restorationbooking.errors.InvalidInputException;
import com.fssa.restorationbooking.errors.UserErrors;
import com.fssa.restorationbooking.model.User;
import com.fssa.restorationbooking.regex.UserValidationRegex;

public class UserValidator {

	public static boolean validateUser(User user) throws InvalidInputException {

		if (user == null) {
			throw new InvalidInputException(UserErrors.INVALID_USER_NULL);
		}
		validateEmailId(user.getEmailId());
		validateUserName(user.getUserName());
		validatePassword(user.getPassword());

		return true;
	}

	public static boolean validateEmailId(String emailId) throws InvalidInputException {

		if (emailId == null) {
			throw new InvalidInputException(UserErrors.INVALID_EMAIL_NULL);
		}

		if (emailId.trim().isEmpty()) {
			throw new InvalidInputException(UserErrors.INVALID_EMAIL_EMPTY);
		}

		boolean isMatch = emailId.matches(UserValidationRegex.EMAIL_REGEX);

		if (!isMatch) {
			throw new InvalidInputException(UserErrors.INVALID_EMAIL_FORMAT);
		}

		return true;

	}

	public static boolean validateUserName(String userName) throws InvalidInputException {

		userName = userName.trim();

		if (userName == null) {
			throw new InvalidInputException(UserErrors.INVALID_USERNAME_NULL);
		}

		if (userName.isEmpty()) {
			throw new InvalidInputException(UserErrors.INVALID_USERNAME_EMPTY);
		}

		if (userName.length() < 3) {
			throw new InvalidInputException(UserErrors.INVALID_USERNAME_SHORT);
		}

		if (userName.matches(".*\\d.*")) {
			throw new InvalidInputException(UserErrors.INVALID_USERNAME_NUMERIC);
		}

		if (userName.matches(".*[^a-zA-Z0-9].*")) {
			throw new InvalidInputException(UserErrors.INVALID_USERNAME_SPECIAL_CHAR);
		}

		return true;

	}

	public static boolean validatePassword(String password) throws InvalidInputException {

		if (password == null) {
			throw new InvalidInputException(UserErrors.INVALID_PASSWORD_NULL);
		}

		return true;

	}

}
