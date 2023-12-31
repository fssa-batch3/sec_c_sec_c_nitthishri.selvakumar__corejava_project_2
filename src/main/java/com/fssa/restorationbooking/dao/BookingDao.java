package com.fssa.restorationbooking.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import com.fssa.restorationbooking.errors.DAOException;
import com.fssa.restorationbooking.model.BookingRequest;
import com.fssa.restorationbooking.util.ConnectionUtil;
import com.fssa.restorationbooking.util.Logger;

public class BookingDao {

	// Logger instance to record log messages
	static Logger logger = new Logger();

//	  Adds a new booking request to the database.

	public static boolean addBooking(BookingRequest booking) throws SQLException {
		try (Connection connection = ConnectionUtil.getConnection()) {
			// Convert LocalDateTime to Timestamp

			// SQL query to insert a new booking request
			String query = "INSERT INTO booking_request(userEmail, productName, phoneNumber, bookingStatus, imageUrl, bookingUserName, categoryOfItem,productAge,reason) VALUES (?, ?, ?, ?, ?, ?, ?, ?,?)";

			// Prepare and execute the SQL statement
			try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
				logger.info("DAO");

				// Set parameter values for the SQL query
				preparedStatement.setString(1, booking.getUserEmail());
				preparedStatement.setString(2, booking.getProductName());
				preparedStatement.setString(3, booking.getPhoneNumber());
				preparedStatement.setBoolean(4, false);
				preparedStatement.setString(5, booking.getImageUrl());
				preparedStatement.setString(6, booking.getBookingUserName());
				preparedStatement.setString(7, booking.getCategoryOfItem());
				preparedStatement.setInt(8, booking.getProductAge());
				preparedStatement.setString(9, booking.getReason());
				// Execute the SQL query to insert the booking
				preparedStatement.executeUpdate();
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
			throw ex;
		}

		// Return true to indicate successful booking addition
		return true;
	}

//	  Updates an existing booking request in the database.

	public static boolean updateBooking(BookingRequest booking) throws SQLException, DAOException {
		String query = "UPDATE booking_request SET userEmail = ?, productName = ?, phoneNumber = ?, imageUrl = ?, bookingUserName = ?, productAge = ? WHERE bookingid = ?";
		try (Connection connection = ConnectionUtil.getConnection()) {
			try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
				preparedStatement.setString(1, booking.getUserEmail());
				preparedStatement.setString(2, booking.getProductName());
				preparedStatement.setString(3, booking.getPhoneNumber());
//				preparedStatement.setInt(4, booking.isBookingStatus());
				preparedStatement.setString(4, booking.getImageUrl());
				preparedStatement.setString(5, booking.getBookingUserName());
//				preparedStatement.setString(6, booking.getBookingCategory());
				preparedStatement.setInt(6, booking.getProductAge());
				preparedStatement.setInt(7, booking.getBookingId()); // Set bookingid for the update condition
				System.out.println(preparedStatement);
				preparedStatement.executeUpdate(); 
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
			throw new DAOException("Update Booking Method is failded");
		}
		return true;
	}
	

	// Read an selected existing booking request
	public static List<BookingRequest> getSelectedBookings(int BookingId) throws DAOException, SQLException {
		List<BookingRequest> bookingRequest = new ArrayList<>();
		try (Connection connection = ConnectionUtil.getConnection()) {
			try (PreparedStatement stmt = connection
					.prepareStatement("SELECT * FROM booking_request WHERE bookingid = ?")) {
				stmt.setInt(1, BookingId);
				try (ResultSet rs = stmt.executeQuery()) {
					if (rs.next()) {

						BookingRequest bRequest = new BookingRequest();
						bRequest.setUserEmail(rs.getString("userEmail"));
						bRequest.setProductName(rs.getString("productName"));
						bRequest.setPhoneNumber(rs.getString("phoneNumber"));
						bRequest.setBookingStatus(rs.getInt("bookingStatus"));
						bRequest.setImageUrl(rs.getString("imageUrl"));
						bRequest.setBookingUserName(rs.getString("bookingUserName"));
						bRequest.setProductAge(rs.getInt("productAge"));
						bRequest.setReason(rs.getString("reason"));
						bRequest.setBookingCategory(rs.getString("CategoryOfItem"));
						bRequest.setPickUpId(rs.getInt("PickupId"));
						bookingRequest.add(bRequest);

					}
				}

			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		}
		return bookingRequest;
	}

	// Read an all existing booking request
	public static List<BookingRequest> getAllBookings() throws DAOException, SQLException {
		List<BookingRequest> bookingRequest = new ArrayList<>();
		try (Connection connection = ConnectionUtil.getConnection()) {
			try (PreparedStatement stmt = connection.prepareStatement("SELECT * FROM booking_request")) {

				try (ResultSet rs = stmt.executeQuery()) {
					while (rs.next()) {

						Timestamp bookingTimeSql = rs.getTimestamp("bookingTime");
						LocalDateTime bookingTime = bookingTimeSql.toLocalDateTime();

						BookingRequest bRequest1 = new BookingRequest();
						bRequest1.setBookingId(rs.getInt("bookingId"));
						bRequest1.setUserEmail(rs.getString("userEmail"));
						bRequest1.setProductName(rs.getString("productName"));
						bRequest1.setPhoneNumber(rs.getString("phoneNumber"));
						bRequest1.setBookingStatus(rs.getInt("bookingStatus"));
						bRequest1.setImageUrl(rs.getString("imageUrl"));
						bRequest1.setBookingUserName(rs.getString("bookingUserName"));
						bRequest1.setBookingTime(bookingTime);
						bRequest1.setProductAge(rs.getInt("productAge"));
//	                	CategoryOfItem category = CategoryOfItem.valueOf(rs.getString("categoryOfItem"));
//	                	bRequest1.setCategoryOfItem(category);
						bRequest1.setBookingCategory(rs.getString("CategoryOfItem"));
						bRequest1.setReason(rs.getString("reason"));
						bookingRequest.add(bRequest1);

					}
				}

			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		}
		return bookingRequest;
	}

// * Deletes a booking request from the database based on the provided booking ID.

    public boolean deleteBooking(int bookingId) throws SQLException {
        String query = "DELETE FROM booking_request WHERE bookingid = ?";
        try (Connection connection = ConnectionUtil.getConnection()) {
            try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                preparedStatement.setInt(1, bookingId);
                int rowsAffected = preparedStatement.executeUpdate();
                return rowsAffected > 0; // Return true if rows were affected, else false
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            throw ex;
        }
    }

	// Select a detail through the email

	public static List<BookingRequest> getThroughEmail(String UserEmail) throws DAOException, SQLException {
		List<BookingRequest> bookingRequest = new ArrayList<>();
		try (Connection connection = ConnectionUtil.getConnection()) {
			try (PreparedStatement stmt = connection
					.prepareStatement("SELECT * FROM booking_request WHERE userEmail = ?")) {
				stmt.setString(1, UserEmail);
				try (ResultSet rs = stmt.executeQuery()) {
					while (rs.next()) {

						Timestamp bookingTimeSql = rs.getTimestamp("bookingTime");
						LocalDateTime bookingTime = bookingTimeSql.toLocalDateTime();
 
						BookingRequest bRequest2 = new BookingRequest(); 
						
						bRequest2.setBookingId(rs.getInt("bookingId"));
						bRequest2.setProductName(rs.getString("productName"));
						bRequest2.setPhoneNumber(rs.getString("phoneNumber"));
						bRequest2.setBookingStatus(rs.getInt("bookingStatus"));
						bRequest2.setImageUrl(rs.getString("imageUrl"));
						bRequest2.setBookingUserName(rs.getString("bookingUserName"));
						bRequest2.setProductAge(rs.getInt("productAge"));
						bRequest2.setBookingTime(bookingTime);
						bRequest2.setBookingCategory(rs.getString("CategoryOfItem"));
						bRequest2.setReason(rs.getString("reason"));
						bRequest2.setPickUpId(rs.getInt("PickUpId"));
						bookingRequest.add(bRequest2);

					}
				}

			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		}
		return bookingRequest;
	}

	// updating the booking status whether it is undergoing or accepted or rejected
	public static boolean updateStatusInDatabase(int bookingId, int status, String reason) {
		try (Connection connection = ConnectionUtil.getConnection()) {
			String sql = "UPDATE booking_request SET bookingStatus = ?, reason = ? WHERE bookingId= ?";

			try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
				preparedStatement.setInt(1, status);
				preparedStatement.setString(2, reason);
				preparedStatement.setInt(3, bookingId);

				preparedStatement.executeUpdate();
			}
		} catch (SQLException e) {

			e.printStackTrace();

		}

		return true;

	}
	
	public static boolean updatePickupId(int bookingId, int PickupId) {
		try (Connection connection = ConnectionUtil.getConnection()) {
			String sql = "UPDATE booking_request SET PickupId = ? WHERE bookingId= ?";

			try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
				preparedStatement.setInt(1, PickupId);
				preparedStatement.setInt(2, bookingId);
				

				preparedStatement.executeUpdate();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return true;

	}
	


}