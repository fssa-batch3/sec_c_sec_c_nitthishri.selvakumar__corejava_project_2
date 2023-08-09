package com.fssa.restorationbooking.model;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import com.fssa.restorationbooking.enums.CategoryOfItem;

public class BookingRequest {

	// Properties of the BookingRequest class
	private String userEmail;
	private String productName;
	private int bookingId;
	private String phoneNumber;
	private boolean bookingStatus;
	private String imageUrl;
	private String bookingUserName;
	private CategoryOfItem categoryOfItem;
	private int productAge;
	private LocalDate productLastRepair;
	private LocalDateTime bookingTime;

//	public BookingRequest(String userEmail, String productName, int bookingId, String phoneNumber,
//			boolean bookingStatus, String imageUrl, String bookingUserName, CategoryOfItem categoryOfItem,
//			int productAge, LocalDate productLastRepair, LocalDateTime bookingTime) {
//
//		this.userEmail = userEmail;
//		this.productName = productName;
//		this.bookingId = bookingId;
//		this.phoneNumber = phoneNumber;
//		this.bookingStatus = bookingStatus;
//		this.imageUrl = imageUrl;
//		this.bookingUserName = bookingUserName;
//		this.categoryOfItem = categoryOfItem;
//		this.productAge = productAge;
//		this.productLastRepair = productLastRepair;
//		this.bookingTime = bookingTime;
//	}
	
	public BookingRequest(String userEmail, String productName, String phoneNumber, boolean bookingStatus,
			String imageUrl, String bookingUserName, LocalDateTime bookingTime, CategoryOfItem categoryOfItem,int productAge){
			
		this.userEmail = userEmail;
		this.productName = productName;
		this.phoneNumber = phoneNumber;
		this.bookingStatus = bookingStatus;
		this.imageUrl = imageUrl; 
		this.bookingUserName = bookingUserName;
		this.bookingTime = bookingTime;
		this.categoryOfItem = categoryOfItem;
	
		this.productAge = productAge;
	}


	// Constructor with all the properties as parameters
	public BookingRequest(String userEmail, String productName, String phoneNumber, boolean bookingStatus,
			String imageUrl, String bookingUserName, LocalDateTime bookingTime, CategoryOfItem categoryOfItem,int productAge,int bookingId){
			
		this.userEmail = userEmail;
		this.productName = productName;
		this.phoneNumber = phoneNumber;
		this.bookingStatus = bookingStatus;
		this.imageUrl = imageUrl; 
		this.bookingUserName = bookingUserName;
		this.bookingTime = bookingTime;
		this.categoryOfItem = categoryOfItem;
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
		return bookingTime;
	}


//	  Set the date and time of the booking request.
	
	public void setBookingTime(LocalDateTime bookingTime) {
		this.bookingTime = bookingTime;
	}

//	  Get the category of the item being booked.
	
	public CategoryOfItem getCategoryOfItem() {
		return categoryOfItem;
	}


//	  Set the category of the item being booked.
	 
	public void setCategoryOfItem(CategoryOfItem categoryOfItem) {
		this.categoryOfItem = categoryOfItem;
	}

	
//	  Get the age of the product being booked in years.
	
	public int getProductAge() {
		return productAge;
	}

	
//	  Set the age of the product being booked in years.
	 
	public void setProductAge(int productAge) {
		this.productAge = productAge;
	}

//	  Get the date of the last repair for the product, if available.
	
	public LocalDate getProductLastRepair() {
		return productLastRepair;
	}

	
//	  Set the date of the last repair for the product.
	 
	public void setProductLastRepair(LocalDate productLastRepair) {
		this.productLastRepair = productLastRepair;
	}


}