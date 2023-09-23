package com.jssa.restorationbooking.service;

import java.sql.SQLException;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.fssa.restorationbooking.dao.BookingDao;
import com.fssa.restorationbooking.errors.DAOException;
import com.fssa.restorationbooking.model.BookingRequest;
import com.fssa.restorationbooking.service.BookingService;
import com.fssa.restorationbooking.util.Logger;
import com.fssa.restorationbooking.validation.BookingValidation;
public class TestbookingServiceValidation {

 
	
// Creates and returns a sample BookingRequest object for testing.
     
    public  static BookingRequest getBooking() {
        BookingRequest booking = new BookingRequest("kavi@gmail.com", "antiquetable", "6380628123", 1,
                "https://iili.io/HZ8lwOX.png", "Ramana", "AMPLIFIER", 23,"no spare",11);
 
        
         
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
    
    public  static BookingRequest getBooking2() {
        BookingRequest booking2 = new BookingRequest("kavi@gmail.com", "antiquetable", "6380628123",
                "https://iili.io/HZ8lwOX.png", "Madhuma",23, 12);
		return booking2;
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
        BookingRequest book = getBooking2();
        BookingService bookingService = getBookingService();
 
        Assertions.assertTrue(bookingService.updateBooking(book));
        
    }


//      Test case for deleting a booking using BookingService.
    
    @Test
    public void testDeleteBooking() throws DAOException, SQLException {
        BookingService bookingService = getBookingService();
        Assertions.assertTrue(bookingService.deleteBooking(7));
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
    
    @Test
    public void testUpdateStatus() throws DAOException, SQLException {
    	BookingService bookingSerice = getBookingService();
    	Assertions.assertTrue(bookingService.updateStatus(1,2,"there is no spare parts"));
    	
    }
    
    @Test 
    public void testUpdatePickupId()throws DAOException, SQLException {
    	BookingService bookingSerice = getBookingService();
    	Assertions.assertTrue(bookingService.updatePickupId(1,2));
   
    }
    
}
