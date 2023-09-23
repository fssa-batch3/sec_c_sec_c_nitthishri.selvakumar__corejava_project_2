package com.fssa.restorationbooking.service;

import java.sql.SQLException;

import com.fssa.restorationbooking.dao.UserDao;
import com.fssa.restorationbooking.errors.DAOException;
import com.fssa.restorationbooking.errors.InvalidInputException;
import com.fssa.restorationbooking.model.User;
import com.fssa.restorationbooking.validation.UserValidator;
import com.google.protobuf.ServiceException;

public class UserService {

	UserDao userDAO = new UserDao();

	public boolean userSignUp(User user) throws ServiceException {

		try {
			if (UserValidator.validateUser(user))
				return userDAO.userRegistration(user);
		} catch (InvalidInputException | DAOException e) {
			throw new ServiceException(e.getMessage());
		}

		return false;

	} 

	public boolean deleteUser(String emailId) throws ServiceException {
	    try {
	        if (!UserValidator.validateEmailId(emailId)) {
	            throw new InvalidInputException("Invalid email format: " + emailId);
	        }

	        if (!userDAO.emailExists(emailId)) {
	            throw new ServiceException("Email Not Found: " + emailId);
	        }

	        return userDAO.deleteUser(emailId);
	    } catch (InvalidInputException e) {
	        // Handle validation errors
	        throw new ServiceException(e.getMessage());
	    } catch (DAOException | SQLException e) {
	        // Handle database access errors
	        throw new ServiceException("Error while accessing the database: " + e.getMessage());
	    }
	}

	public boolean userLogin(String emailId, String password) throws ServiceException {
	    try {
	        if (UserValidator.validateEmailId(emailId) && UserValidator.validatePassword(password)) {
	            if (userDAO.emailExists(emailId)) {
	                return userDAO.userLogin(emailId, password);
	            } else {
	                // Handle the case where the email does not exist in the database
	                return false;
	            }
	        } else {
	            // Handle the case where email or password validation fails
	            return false;
	        }
	    } catch (InvalidInputException e) { 
	        // Handle validation errors
	        throw new ServiceException("Invalid input: " + e.getMessage());
	    } catch (DAOException | SQLException e) {
	        // Handle database access errors
	        throw new ServiceException("Error while accessing the database: " + e.getMessage());
	    }
	}

	public User getUserByEmail(String emailId) throws ServiceException, SQLException {
		try {
			if (UserValidator.validateEmailId(emailId)) {
				if (userDAO.emailExists(emailId)) {
					return userDAO.getUserByEmail(emailId);
				} else {
					throw new DAOException("User not found for email: " + emailId);
				}
			}
		} catch (InvalidInputException | DAOException e) {
			throw new ServiceException(e.getMessage());
		}
		return null; // Invalid email format
	}

	public boolean updateUserProfile(User user) throws ServiceException, SQLException {
		try {
			if (UserValidator.validateUser(user)) {
				if (userDAO.emailExists(user.getEmailId())) {
					return userDAO.updateUserProfile(user);
				} else {
					throw new DAOException("Email not found: " + user.getEmailId());
				}
			}
		} catch (DAOException | InvalidInputException e) {
			throw new ServiceException("Error updating user profile: " + e.getMessage());
		}
		return false;
	}

}
