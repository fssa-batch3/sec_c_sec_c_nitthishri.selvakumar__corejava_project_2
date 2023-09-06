package com.jssa.restorationbooking.service;

import java.sql.SQLException;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.fssa.restorationbooking.dao.BookingDao;
import com.fssa.restorationbooking.dao.DAOException;
import com.fssa.restorationbooking.enums.CategoryOfItem;
import com.fssa.restorationbooking.model.BookingRequest;
import com.fssa.restorationbooking.service.BookingService;
import com.fssa.restorationbooking.util.Logger;
import com.fssa.restorationbooking.validation.BookingValidation;

public class TestbookingServiceValidation {

 
	
// Creates and returns a sample BookingRequest object for testing.
     
    public  static BookingRequest getBooking() {
        BookingRequest booking = new BookingRequest("kavi@gmail.com", "antiquetable", "6380628123", false,
                "https://iili.io/HZ8lwOX.png", "Nitthi", "AMPLIFIER", 23, 1);
 
        
         
//    	BookingRequest bookingRequest = new BookingRequest();
//		bookingRequest.setUserEmail(userEmailForBuilder);
//		bookingRequest.setProductName(productNameForBuilder);
//		bookingRequest.setBookingId(bookingIdForBuilder);
//		bookingRequest.setPhoneNumber(phoneNumberForBuilder);
//		bookingRequest.setBookingStatus(bookingStatusForBuilder);
//		bookingRequest.setImageUrl(imageUrlForBuilder);
//		bookingRequest.setBookingUserName(bookingUserNameForBuilder);
//		bookingRequest.setCategoryOfItem(categoryOfItemForBuilder);
//		bookingRequest.setProductAge(productAgeForBuilder);
//		bookingRequest.setBookingTime(bookingTimeForBuilder);
        
        return booking;
    }
//CategoryOfItem.valueOf()
  
//  Creates and returns another sample BookingRequest object for testing.
//    
//    public BookingRequest getBooking2() {
//        BookingRequest booking = new BookingRequest("kavi@gmail.com", "antiquetable", "6380628123", false,
//                "https://iili.io/HZ8lwOX.png", "JohnWick", CategoryOfItem.AMPLIFIER, 21);
//
//        return booking;
//    }

//      Creates and returns a BookingService object with associated dependencies for testing.
     
    public BookingService getBookingService() {
    	
        BookingValidation bookingValidation = new BookingValidation();
        BookingDao bookingDao = new BookingDao();
        BookingService bookingService = new BookingService(bookingValidation, bookingDao);
        return bookingService;
        
    }
    BookingService bookingService = new BookingService();

//     Test case for adding a booking using BookingService.
     
    @Test
    public void testAddBooking() throws DAOException, SQLException {
      
    	BookingRequest bookingService1 =getBooking();

        Assertions.assertTrue(bookingService.addBooking(bookingService1));
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
        Assertions.assertTrue(bookingService.deleteBooking(1));
    }

   
//      Test case for retrieving booking details using BookingService.
    
    @Test
    public void testGetParticularBookingDetails() throws DAOException, SQLException {
        BookingService bookingService = getBookingService();
        List<BookingRequest> bookingList = bookingService.getParticularBooking(3);
        for(BookingRequest ele:bookingList) {
        	Logger.info(ele);
        } 
    }
    @Test
    public void testGetAllBookings() throws DAOException, SQLException {
    	 BookingService bookingService = getBookingService();
         List<BookingRequest> bookingList1 = bookingService.getFullBooking();
         for(BookingRequest ele:bookingList1) {
         	Logger.info(ele);
         }
         
    }
    
    @Test
    public void testGetThroughEmail() throws DAOException, SQLException {
        BookingService bookingService = getBookingService();
        List<BookingRequest> bookingList2 = bookingService.getThroughEmail("kavi@gmail.com");
        for(BookingRequest ele:bookingList2) {
        	Logger.info(ele);
        } 

    }
    
}
