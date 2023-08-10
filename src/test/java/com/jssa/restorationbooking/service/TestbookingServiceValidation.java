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

 
//      Creates and returns a sample BookingRequest object for testing.
     
    public BookingRequest getBooking() {
        BookingRequest booking = new BookingRequest("nithi@gmail.com", "antiquetable", "6380628123", false,
                "https://iili.io/HZ8lwOX.png", "JohnWick", LocalDateTime.of(2023, 8, 3, 23, 0), CategoryOfItem.AMPLIFIER, 23, 2);

        return booking;
    }

  
//     Creates and returns another sample BookingRequest object for testing.
    
    public BookingRequest getBooking2() {
        BookingRequest booking = new BookingRequest("nithi@gmail.com", "antiquetable", "6380628123", false,
                "https://iili.io/HZ8lwOX.png", "JohnWick", LocalDateTime.of(2023, 8, 3, 23, 0), CategoryOfItem.AMPLIFIER, 23);

        return booking;
    }

//      Creates and returns a BookingService object with associated dependencies for testing.
     
    public BookingService getBookingService() {
        BookingValidation bookingValidation = new BookingValidation();
        BookingDao bookingDao = new BookingDao();
        BookingService bookingService = new BookingService(bookingValidation, bookingDao);
        return bookingService;
    }


//     Test case for adding a booking using BookingService.
     
    @Test
    public void testAddBooking() throws DAOException, SQLException {
        BookingRequest booking = getBooking();
        BookingService bookingService = getBookingService();

        Assertions.assertTrue(bookingService.addBooking(booking));
    }

 
//      Test case for updating a booking using BookingService.
    
    @Test
    public void testUpdateBooking() throws DAOException, SQLException {
        BookingRequest booking = getBooking();
        BookingService bookingService = getBookingService();

        Assertions.assertTrue(bookingService.updateBooking(booking));
    }


//      Test case for deleting a booking using BookingService.
    
    @Test
    public void testDeleteBooking() throws DAOException, SQLException {
        BookingService bookingService = getBookingService();
        Assertions.assertTrue(bookingService.deleteBooking(3));
    }

   
//      Test case for retrieving booking details using BookingService.
    
    @Test
    public void testGetBookingDetails() throws DAOException, SQLException {
        BookingService bookingService = getBookingService();
        Assertions.assertTrue(bookingService.getAllBooking());
    }
}
