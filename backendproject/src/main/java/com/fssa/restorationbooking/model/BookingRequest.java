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


	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public int getBookingId() {
		return bookingId;
	}

	public void setBookingId(int bookingId) {
		this.bookingId = bookingId;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public boolean isBookingStatus() {
		return bookingStatus;
	}

	public void setBookingStatus(boolean bookingStatus) {
		this.bookingStatus = bookingStatus;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	public String getBookingUserName() {
		return bookingUserName;
	}

	public void setBookingUserName(String bookingUserName) {
		this.bookingUserName = bookingUserName;
	}

	public LocalDateTime getBookingTime() {
		return bookingTime;
	}

	public void setBookingTime(LocalDateTime bookingTime) {
		this.bookingTime = bookingTime;
	}

	public CategoryOfItem getCategoryOfItem() {
		return categoryOfItem;
	}

	public void setCategoryOfItem(CategoryOfItem categoryOfItem) {
		this.categoryOfItem = categoryOfItem;
	}

	public int getProductAge() {
		return productAge;
	}

	public void setProductAge(int productAge) {
		this.productAge = productAge;
	}

	public LocalDate getProductLastRepair() {
		return productLastRepair;
	}

	public void setProductLastRepair(LocalDate productLastRepair) {
		this.productLastRepair = productLastRepair;
	}

}