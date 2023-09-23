package com.fssa.restorationbooking.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.fssa.restorationbooking.errors.DAOException;
import com.fssa.restorationbooking.model.User;
import com.fssa.restorationbooking.util.ConnectionUtil;

public class UserDao {

	public boolean userRegistration(User user) throws DAOException {
		try (Connection connection = ConnectionUtil.getConnection()) {

			String insertQuery = "INSERT INTO users(email_id, user_name, password) VALUES (?, ?, ?)";
			try (PreparedStatement psmt = connection.prepareStatement(insertQuery)) {

				psmt.setString(1, user.getEmailId());
				psmt.setString(2, user.getUserName());
				psmt.setString(3, user.getPassword()); 

				int rowAffected = psmt.executeUpdate();
				return rowAffected > 0;
			}
		} catch (SQLException e) {
			throw new DAOException("Error while registering user: " + e.getMessage());
		}
	}

	public boolean deleteUser(String emailId) throws DAOException, SQLException {
		try (Connection connection = ConnectionUtil.getConnection()) {

			String deleteQuery = "DELETE FROM users WHERE email_id = ?";
			try (PreparedStatement psmt = connection.prepareStatement(deleteQuery)) {

				psmt.setString(1, emailId);
				int rowAffected = psmt.executeUpdate();
				return rowAffected > 0;
			}
		}
	}

	public boolean emailExists(String emailId) throws DAOException, SQLException {
		try (Connection connection = ConnectionUtil.getConnection()) {
			try (PreparedStatement psmt = connection.prepareStatement("SELECT user_id FROM users WHERE email_id = ?")) {
				psmt.setString(1, emailId);
				try (ResultSet rs = psmt.executeQuery()) {

					if (rs.next()) {

						int rows = rs.getInt("user_id");
						System.out.println(rows);

						return rows > 0;

					}
				}

			} catch (SQLException e) {
				throw new DAOException("Error while checking email existence: " + e.getMessage());
			}
		}

		return false;

	}

	public static void main(String[] args) throws DAOException, SQLException {
		UserDao user = new UserDao();
		System.out.println(user.emailExists("jallel@gmail.com"));
	}

	public boolean userLogin(String emailId, String password) throws DAOException, SQLException {
		try (Connection connection = ConnectionUtil.getConnection()) {
			String selectQuery = "SELECT COUNT(*) FROM users WHERE email_id = ? AND password = ?";
			try (PreparedStatement psmt = connection.prepareStatement(selectQuery)) {
				psmt.setString(1, emailId);
				psmt.setString(2, password);

				try (ResultSet rs = psmt.executeQuery()) {
					if (rs.next()) {
						int count = rs.getInt(1);
						return count==1 ; // Return true if count is greater than 0 (successful login)
					}
				}
			}
		} catch (SQLException e) {
			throw new DAOException("Error while checking login for email: " + emailId, e);
		}

		// Return false if no user with the given email and password was found
		return false;
	}

	public User getUserByEmail(String emailId) throws DAOException {

		try (Connection connection = ConnectionUtil.getConnection()) {

			String selectQuery = "SELECT user_id, email_Id, user_name, password FROM users WHERE email_Id = ?";
			try (PreparedStatement psmt = connection.prepareStatement(selectQuery)) {
				psmt.setString(1, emailId);

				try (ResultSet rs = psmt.executeQuery()) {
					if (rs.next()) {
						User user = new User();
						user.setUserId(rs.getInt("user_id"));
						user.setEmailId(rs.getString("email_id"));
						user.setUserName(rs.getString("user_name"));
						user.setPassword(rs.getString("password"));
						return user;
					}
				}
			}
		} catch (SQLException e) {
			throw new DAOException(e.getMessage());
		}
		return null; // User not found
	}

	
	public boolean updateUserProfile(User user) throws DAOException {
		String updateQuery = "UPDATE users SET user_name = ?, password = ? WHERE email_Id = ?";
		try (Connection connection = ConnectionUtil.getConnection();
				PreparedStatement psmt = connection.prepareStatement(updateQuery)) {
			psmt.setString(1, user.getUserName());
			psmt.setString(2, user.getPassword());
			psmt.setString(3, user.getEmailId());

			int rowsUpdated = psmt.executeUpdate();

			return rowsUpdated > 0;

		} catch (SQLException e) {
			throw new DAOException("Error updating user profile: " + e.getMessage());
		}
	}

}