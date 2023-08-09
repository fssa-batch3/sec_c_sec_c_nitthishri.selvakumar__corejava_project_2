<<<<<<< HEAD
package com.jssa.restorationbooking.service;

import java.sql.SQLException;
import java.time.LocalDateTime;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.fssa.restorationbooking.dao.BookingDao;
import com.fssa.restorationbooking.dao.DAOException;
import com.fssa.restorationbooking.enums.CategoryOfItem;
import com.fssa.restorationbooking.model.BookingRequest;
import com.fssa.restorationbooking.service.BookingService;
import com.fssa.restorationbooking.validation.BookingValidation;

public class TestbookingServiceValidation {

	public BookingRequest getBooking() {
		BookingRequest booking = new BookingRequest("nithi@gmail.com", "antiquetable", "6380628123", false,
				"https://iili.io/HZ8lwOX.png", "JohnWick", LocalDateTime.of(2023, 8, 3, 23, 0), CategoryOfItem.AMPLIFIER,23,2);
		
		return booking;
	}
	
	public BookingRequest getBooking2() {
		BookingRequest booking = new BookingRequest("nithi@gmail.com", "antiquetable", "6380628123", false,
				"https://iili.io/HZ8lwOX.png", "JohnWick", LocalDateTime.of(2023, 8, 3, 23, 0), CategoryOfItem.AMPLIFIER,23);
		
		return booking;
	}



	public BookingService getBookingService() {
		BookingValidation bookingValidation = new BookingValidation();
		BookingDao bookingDao = new BookingDao();
		BookingService bookingService = new BookingService(bookingValidation, bookingDao);
		return bookingService; 
	} 
	
	@Test
	public void testAddBooking() throws DAOException, SQLException {
		BookingRequest booking = getBooking();
		BookingService bookingService = getBookingService();
		
		Assertions.assertTrue(bookingService.addBooking(booking));
	}
 
	@Test
	public void testUpdateBooking() throws DAOException, SQLException {
		BookingRequest booking = getBooking();
		BookingService bookingService = getBookingService();
		
		Assertions.assertTrue(bookingService.updateBooking(booking));
	}

	@Test
	public void testDeleteBooking() throws DAOException, SQLException {
		// BookingRequest booking = getBooking1();
		BookingService bookingService = getBookingService();
		Assertions.assertTrue(bookingService.deleteBooking(3));
	}

	@Test
	public void testGetBookingDetails() throws DAOException, SQLException {
		// BookingRequest booking = getBooking1();
		BookingService bookingService = getBookingService();
		Assertions.assertTrue(bookingService.getAllBooking());
	}
}
=======
package com.jssa.restorationbooking.service;

import java.sql.SQLException;
import java.time.LocalDateTime;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.fssa.restorationbooking.dao.BookingDao;
import com.fssa.restorationbooking.dao.DAOException;
import com.fssa.restorationbooking.enums.CategoryOfItem;
import com.fssa.restorationbooking.model.BookingRequest;
import com.fssa.restorationbooking.service.BookingService;
import com.fssa.restorationbooking.validation.BookingValidation;

public class TestbookingServiceValidation {

	public BookingRequest getBooking() {
		BookingRequest booking = new BookingRequest("nikis@gmail.com", "antiquetable", "6380628123", false,
				"https://iili.io/HZ8lwOX.png", "JohnWick", LocalDateTime.of(2023, 8, 3, 23, 0), CategoryOfItem.AMPLIFIER,23,1);
		
		return booking;
	}


	public BookingService getBookingService() {
		BookingValidation bookingValidation = new BookingValidation();
		BookingDao bookingDao = new BookingDao();
		BookingService bookingService = new BookingService(bookingValidation, bookingDao);
		return bookingService;
	} 
	
	@Test
	public void testAddBooking() throws DAOException, SQLException {
		BookingRequest booking = getBooking();
		BookingService bookingService = getBookingService();
		
		Assertions.assertTrue(bookingService.addBooking(booking));
	}
 
	@Test
	public void testUpdateBooking() throws DAOException, SQLException {
		BookingRequest booking = getBooking();
		BookingService bookingService = getBookingService();
		
		Assertions.assertTrue(bookingService.updateBooking(booking));
	}

	@Test
	public void testDeleteBooking() throws DAOException, SQLException {
		// BookingRequest booking = getBooking1();
		BookingService bookingService = getBookingService();
		Assertions.assertTrue(bookingService.deleteBooking(1));
	}

	@Test
	public void testGetBookingDetails() throws DAOException, SQLException {
		// BookingRequest booking = getBooking1();
		BookingService bookingService = getBookingService();
		Assertions.assertTrue(bookingService.getAllBooking());
	}
}
>>>>>>> 16945bd60c50791654cfe1cb6a7b8b3e99b29cc2
