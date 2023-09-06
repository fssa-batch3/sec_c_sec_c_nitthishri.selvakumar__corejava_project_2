package com.fssa.restorationbooking.model;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import com.fssa.restorationbooking.enums.CategoryOfItem;

public class BookingRequest {

	


//	public static Object CategoryOfItem;



	public BookingRequest() {
		super();
	}


	// Properties of the BookingRequest class
	private String userEmail;
	private String productName;
	private int bookingId;
	private String phoneNumber;
	private boolean bookingStatus;
	private String imageUrl;
	private String bookingUserName;
	public String categoryOfItem;
	
	
	public void setBookingCategory(String categoryOfItem) {
		this.categoryOfItem = categoryOfItem;
	}


	private LocalDateTime bookingTime1;

	
	public LocalDateTime getBookingTime1() {
		return bookingTime1;
	}


	public void setBookingTime1(LocalDateTime bookingTime1) {
		this.bookingTime1 = bookingTime1;
	}


	public String getCategoryOfItem() {
		return categoryOfItem;
	}




	private int productAge;
	


	
	public BookingRequest(String userEmail, String productName, String phoneNumber, boolean bookingStatus,
			String imageUrl, String bookingUserName, String categoryOfItem,int productAge){
			
		this.userEmail = userEmail;
		this.productName = productName;
		this.phoneNumber = phoneNumber;
		this.bookingStatus = bookingStatus;
		this.imageUrl = imageUrl; 
		this.bookingUserName = bookingUserName;
		this.bookingTime1 = bookingTime1;
		this.categoryOfItem = categoryOfItem;
		this.productAge = productAge;
	}


	// Constructor with all the properties as parameters
	public BookingRequest(String userEmail, String productName, String phoneNumber, boolean bookingStatus,
			String imageUrl, String bookingUserName, String amplifier,int productAge,int bookingId){
			
		this.userEmail = userEmail;
		this.productName = productName;
		this.phoneNumber = phoneNumber;
		this.bookingStatus = bookingStatus;
		this.imageUrl = imageUrl; 
		this.bookingUserName = bookingUserName;
		this.bookingTime1 = bookingTime1;
		this.categoryOfItem = amplifier;
		this.bookingId = bookingId;
		this.productAge = productAge;
	}

	// Default constructor
	

	// Another constructor with some parameters (but not all)

	
//	  Get the email address of the user who made the booking.
	
	

	public String getUserEmail() {
		return userEmail;
	}

	
//	 Set the email address of the user who made the booking.
	
	

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}


//	 Get the name of the product being booked for restoration.
	 
	public String getProductName() {
		return productName;
	}

	
//	  Set the name of the product being booked for restoration.
	 
	public void setProductName(String productName) {
		this.productName = productName;
	}

	
//	 Get the unique identifier of the booking.
	
	public int getBookingId() {
		return bookingId;
	}


//	  Set the unique identifier of the booking.
	
	public void setBookingId(int bookingId) {
		this.bookingId = bookingId;
	}

	
//	  Get the contact phone number of the user who made the booking.
	 
	public String getPhoneNumber() {
		return phoneNumber;
	}


//	 Set the contact phone number of the user who made the booking.
	
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	
//	  Check if the booking status is confirmed.
	
	public boolean isBookingStatus() {
		return bookingStatus;
	}

	
//	  Set the booking status.
	 
	public void setBookingStatus(boolean bookingStatus) {
		this.bookingStatus = bookingStatus;
	}

	
//	  Get the URL of the image representing the booked product.
	
	public String getImageUrl() {
		return imageUrl;
	}

	
//	 Set the URL of the image representing the booked product.
	
	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	
//	  Get the name of the user who made the booking.
	
	public String getBookingUserName() {
		return bookingUserName;
	}

	
//	 Set the name of the user who made the booking.
	
	public void setBookingUserName(String bookingUserName) {
		this.bookingUserName = bookingUserName;
	}

	
//	 Get the date and time of the booking request.
	 
	public LocalDateTime getBookingTime() {
		return bookingTime1;
	}


//	  Set the date and time of the booking request.
	
	public void setBookingTime(LocalDateTime timestamp) {
		this.bookingTime1 = timestamp;
	}

//	  Get the category of the item being booked.
	
//	public CategoryOfItem getCategoryOfItem() {
//		return categoryOfItem;
//	}


//	  Set the category of the item being booked.
	 

	
//	  Get the age of the product being booked in years.
	
	public int getProductAge() {
		return productAge;
	}

	
//	  Set the age of the product being booked in years.
	 
	public void setProductAge(int productAge) {
		this.productAge = productAge;
	}


	public boolean addBooking(BookingRequest booking) {
		// TODO Auto-generated method stub
		return false;
	}



	@Override
	public String toString() {
		return "BookingRequest [userEmail=" + userEmail + ", productName=" + productName + ", bookingId=" + bookingId
				+ ", phoneNumber=" + phoneNumber + ", bookingStatus=" + bookingStatus + ", imageUrl=" + imageUrl
				+ ", bookingUserName=" + bookingUserName + ", categoryOfItem=" + categoryOfItem + ", bookingTime1="
				+ bookingTime1 + ", productAge=" + productAge + "]";
	}


	public String getBookingCategory() {
		// TODO Auto-generated method stub
		return categoryOfItem;

	}


	public void setCategoryOfItem(String categoryOfItemForBuilder) {
		// TODO Auto-generated method stub
		
	}







//
//	public String getBookingCategory() {
//		// TODO Auto-generated method stub
//		return categoryOfItem;
//	}

}