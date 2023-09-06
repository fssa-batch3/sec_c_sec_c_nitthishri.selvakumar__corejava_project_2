package com.fssa.restorationbooking.dao;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.sql.Timestamp;
import java.time.LocalDateTime;

import java.util.ArrayList;
import java.util.List;

import com.fssa.restorationbooking.model.BookingRequest;
import com.fssa.restorationbooking.util.ConnectionUtil;
import com.fssa.restorationbooking.util.Logger;

public class BookingDao {

	// Logger instance to record log messages
	static Logger logger = new Logger();

//	public static void main(String[] args) throws SQLException, DAOException {
//		// Create a BookingRequest object with sample data
//		BookingRequest booking = new BookingRequest("vishui@gmail.com", "antique clock", "6380628123", false,
//				"https://iili.io/HZ8lwOX.png", "nitthi", LocalDateTime.of(2023, 8, 3, 22, 0), CategoryOfItem.CAMERA, 24,
//				59);
//
//		// Call the addBooking method to insert the booking into the database
//		addBooking(booking);
//
//		// Call other methods for testing (e.g., getAllBookings, updateBooking,
//		// deleteBooking)
//		// getupdate();
//	} 

//	  Adds a new booking request to the database.

	public static boolean addBooking(BookingRequest booking) throws SQLException {
		try (Connection connection = ConnectionUtil.getConnection()) {
			// Convert LocalDateTime to Timestamp

			// SQL query to insert a new booking request
			String query = "INSERT INTO booking_Request(userEmail, productName, phoneNumber, bookingStatus, imageUrl, bookingUserName, categoryOfItem,productAge) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

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
//				preparedStatement.setTimestamp(7, Timestamp.valueOf(booking.getBookingTime()));
				preparedStatement.setString(7, booking.getCategoryOfItem()+"");
				preparedStatement.setInt(8, booking.getProductAge());

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
	
	public static boolean updateBooking(BookingRequest booking) throws SQLException {
		String query = "UPDATE booking_Request SET userEmail = ?, productName = ?, phoneNumber = ?, bookingStatus = ?, imageUrl = ?, bookingUserName = ?, categoryOfItem = ?, productAge = ? WHERE bookingid = ?";
		try (Connection connection = ConnectionUtil.getConnection()) {
			try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
				preparedStatement.setString(1, booking.getUserEmail());
				preparedStatement.setString(2, booking.getProductName());
				preparedStatement.setString(3, booking.getPhoneNumber());
				preparedStatement.setBoolean(4, booking.isBookingStatus());
				preparedStatement.setString(5, booking.getImageUrl());
				preparedStatement.setString(6, booking.getBookingUserName());
//				preparedStatement.setTimestamp(7, Timestamp.valueOf(booking.getBookingTime()));
				preparedStatement.setString(7, booking.getBookingCategory());
				preparedStatement.setInt(8, booking.getProductAge());
				preparedStatement.setInt(9, booking.getBookingId()); // Set bookingid for the update condition
				preparedStatement.executeUpdate();
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
			throw ex;
		}
		return true;
	}
	
	//Read an selected existing booking request
	public static List<BookingRequest> getSelectedBookings(int BookingId) throws DAOException, SQLException{
		List<BookingRequest> bookingRequest = new ArrayList<>();
	    try (Connection connection = ConnectionUtil.getConnection()) {
	        try (PreparedStatement stmt = connection.prepareStatement("SELECT * FROM booking_Request WHERE bookingid = ?")) {
	            stmt.setInt(1, BookingId);
	            try (ResultSet rs = stmt.executeQuery()) {
	                if (rs.next()) {
	                	
	                	BookingRequest bRequest = new BookingRequest();
	                	bRequest.setUserEmail(rs.getString("userEmail"));
	                	bRequest.setProductName(rs.getString("productName"));
	                	bRequest.setPhoneNumber(rs.getString("phoneNumber"));
	                	bRequest.setBookingStatus(rs.getBoolean("bookingStatus"));
	                	bRequest.setImageUrl(rs.getString("imageUrl"));
	                	bRequest.setBookingUserName(rs.getString("bookingUserName"));
	                	bRequest.setProductAge(rs.getInt("productAge"));
//	                	CategoryOfItem cate = CategoryOfItem.valueOf(rs.getString("categoryOfItem"));
//	                	bRequest.setCategoryOfItem(cate);
	                	bRequest.setBookingCategory(rs.getString("CategoryOfItem"));
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
	
	//Read an all existing booking request
	public static List<BookingRequest> getAllBookings() throws DAOException, SQLException{
		List<BookingRequest> bookingRequest = new ArrayList<>();
	    try (Connection connection = ConnectionUtil.getConnection()) {
	        try (PreparedStatement stmt = connection.prepareStatement("SELECT * FROM booking_Request")) {
	          
	            try (ResultSet rs = stmt.executeQuery()) {
	                while (rs.next()) {
	                	
	                	Timestamp bookingTimeSql= rs.getTimestamp("bookingTime");
						LocalDateTime bookingTime = bookingTimeSql.toLocalDateTime();
	                	
	                	BookingRequest bRequest1 = new BookingRequest();
	                	bRequest1.setBookingId(rs.getInt("bookingId"));
	                	bRequest1.setUserEmail(rs.getString("userEmail"));
	                	bRequest1.setProductName(rs.getString("productName"));
	                	bRequest1.setPhoneNumber(rs.getString("phoneNumber"));
	                	bRequest1.setBookingStatus(rs.getBoolean("bookingStatus"));
	                	bRequest1.setImageUrl(rs.getString("imageUrl"));
	                	bRequest1.setBookingUserName(rs.getString("bookingUserName"));
	                	bRequest1.setBookingTime(bookingTime);
	                	bRequest1.setProductAge(rs.getInt("productAge"));
//	                	CategoryOfItem category = CategoryOfItem.valueOf(rs.getString("categoryOfItem"));
//	                	bRequest1.setCategoryOfItem(category);
	                	bRequest1.setBookingCategory(rs.getString("CategoryOfItem"));
	                	
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
		String query = "DELETE FROM booking_Request WHERE bookingid = ?";
		try (Connection connection = ConnectionUtil.getConnection()) {
			try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
				preparedStatement.setInt(1, bookingId);
				preparedStatement.executeUpdate();
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
			throw ex;
		}
		return true;
	}
	
	
	
	//Select a detail through the email
	
	public static List<BookingRequest> getThroughEmail(String UserEmail) throws DAOException, SQLException{
		List<BookingRequest> bookingRequest = new ArrayList<>();
	    try (Connection connection = ConnectionUtil.getConnection()) {
	        try (PreparedStatement stmt = connection.prepareStatement("SELECT * FROM booking_Request WHERE userEmail = ?")) {
	            stmt.setString(1, UserEmail);
	            try (ResultSet rs = stmt.executeQuery()) {
	               while(rs.next()) {
	                	
	                	Timestamp bookingTimeSql= rs.getTimestamp("bookingTime");
						LocalDateTime bookingTime = bookingTimeSql.toLocalDateTime();
						
	                	BookingRequest bRequest2 = new BookingRequest();
	                	bRequest2.setBookingId(rs.getInt("bookingId"));
	                	bRequest2.setProductName(rs.getString("productName"));
	                	bRequest2.setPhoneNumber(rs.getString("phoneNumber"));
	                	bRequest2.setBookingStatus(rs.getBoolean("bookingStatus"));
	                	bRequest2.setImageUrl(rs.getString("imageUrl"));
	                	bRequest2.setBookingUserName(rs.getString("bookingUserName"));
	                	bRequest2.setProductAge(rs.getInt("productAge"));
	                	bRequest2.setBookingTime(bookingTime);
	                	bRequest2.setBookingCategory(rs.getString("CategoryOfItem"));
	                	
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
}

