package com.fssa.restorationbooking.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.fssa.restorationbooking.enums.CategoryOfItem;
import com.fssa.restorationbooking.model.BookingRequest;
import com.fssa.restorationbooking.util.ConnectionUtil;
import com.fssa.restorationbooking.util.Logger;

public class BookingDao {
	
	 static Logger logger = new Logger();
	public static void main(String[] args) throws SQLException,DAOException {
		BookingRequest booking = new BookingRequest("vishui@gmail.com", "antique clock", "6380628123", false,
				"https://iili.io/HZ8lwOX.png", "nitthi", LocalDateTime.of(2023, 8, 3, 22, 0), CategoryOfItem.CAMERA, 24,
				59);
	addBooking(booking);
//		getupdate();
	}

 

	public static boolean addBooking(BookingRequest booking) throws SQLException {
try(Connection connection = ConnectionUtil.getConnection()){
		LocalDateTime startTime = booking.getBookingTime();
		Timestamp startTimeTs = Timestamp.valueOf(startTime);

		String query = "INSERT INTO product_booking (userEmail, productName, phoneNumber, bookingStatus, imageUrl, bookingUserName, bookingTime, categoryOfItem,productAge) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";

		try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {

			logger.info("DAO");

			preparedStatement.setString(1, booking.getUserEmail());
			preparedStatement.setString(2, booking.getProductName());
			preparedStatement.setString(3, booking.getPhoneNumber());
			preparedStatement.setBoolean(4, false);
			preparedStatement.setString(5, booking.getImageUrl());
			preparedStatement.setString(6, booking.getBookingUserName());
			preparedStatement.setTimestamp(7, Timestamp.valueOf(booking.getBookingTime()));
			preparedStatement.setString(8, booking.getCategoryOfItem().getBookingCategory());
			preparedStatement.setInt(9, booking.getProductAge());
			//preparedStatement.setInt(10, booking.getBookingId());
			// Set bookingid here based on your requirements, e.g.,
			// preparedStatement.setInt(10, booking.getBookingId());
			preparedStatement.executeUpdate();
		} 
}
catch (SQLException ex) {
			ex.printStackTrace();
			throw ex;
		}

		return true; 
	}

	public static List<BookingRequest> getAllBookings() throws SQLException {
		List<BookingRequest> bookings = new ArrayList<>();
		String query = "SELECT * FROM product_booking";
		try(Connection connection = ConnectionUtil.getConnection()){
		try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
			try (ResultSet resultSet = preparedStatement.executeQuery()) {
				while (resultSet.next()) {
					logger.info("userEmail: " + resultSet.getString(1));
					logger.info("Product Name: " + resultSet.getString(2));
					logger.info("Phone Number: " + resultSet.getString(3));
					logger.info("BookingStatus: " + resultSet.getString(4));
					logger.info("ImageUrl: " + resultSet.getString(5));  
					logger.info("User Name: " + resultSet.getString(6));
					logger.info("Booking Time: " + resultSet.getString(7));
					logger.info("Category Of Item: " + resultSet.getString(8));
					logger.info("BookingId: " + resultSet.getString(9));
					
					
				}
			}
		} 
		}
		catch (SQLException ex) {
			ex.printStackTrace();
			throw ex;
		}
		return bookings;
	} 

	public static boolean updateBooking(BookingRequest booking) throws SQLException {
		String query = "UPDATE product_booking SET userEmail = ?, productName = ?, phoneNumber = ?, bookingStatus = ?, imageUrl = ?, bookingUserName = ?, bookingTime = ?, categoryOfItem = ?, productAge = ? WHERE bookingid = ?";
		try(Connection connection = ConnectionUtil.getConnection()){
		try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
			preparedStatement.setString(1, booking.getUserEmail());
			preparedStatement.setString(2, booking.getProductName());
			preparedStatement.setString(3, booking.getPhoneNumber());
			preparedStatement.setBoolean(4, booking.isBookingStatus());
			preparedStatement.setString(5, booking.getImageUrl());
			preparedStatement.setString(6, booking.getBookingUserName());
			preparedStatement.setTimestamp(7, Timestamp.valueOf(booking.getBookingTime()));
			preparedStatement.setString(8, booking.getCategoryOfItem().getBookingCategory());
			preparedStatement.setInt(9, booking.getProductAge());
			preparedStatement.setInt(10, booking.getBookingId()); // Set bookingid for the update condition
			preparedStatement.executeUpdate();
		} 
		}
		catch (SQLException ex) {
			ex.printStackTrace();
			throw ex;
		}
		return true;
	}

	public boolean deleteBooking(int bookingId) throws SQLException {
		String query = "DELETE FROM product_booking WHERE bookingid = ?";
		try(Connection connection = ConnectionUtil.getConnection()){
		try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
			preparedStatement.setInt(1, bookingId);
			preparedStatement.executeUpdate();
		}  
		}
		catch (SQLException ex) {
			ex.printStackTrace();
			throw ex;
		}
		return true;
	}
}
