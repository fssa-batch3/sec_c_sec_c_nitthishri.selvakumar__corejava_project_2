package com.fssa.restorationbooking.validation;


import java.time.LocalDateTime;

public class InvalidBookingDetailException extends RuntimeException {
	private static final long serialVersionUID = -8105491977357554060L;
	// Calling each super constructors for each of the types
	public InvalidBookingDetailException(String msg) {
		super(msg);
	}
	public InvalidBookingDetailException(Throwable te) {
		super(te);
	}
	public InvalidBookingDetailException(String msg, Throwable te) {
		super(msg, te);
	}

//public static boolean validateBookingDate(LocalDateTime bookingTime) throws InvalidBookingDetailException {
//	LocalDateTime currentTime = LocalDateTime.now();
//	if(bookingTime==null) {
//		throw new InvalidBookingDetailException("Booking Time cannot be empty or null");
//	}
//	if(bookingTime.isBefore(currentTime)) {
//		throw new InvalidBookingDetailException("Booking Time should be in the present");
//		
//		
//	}
//	return true;
//}
}