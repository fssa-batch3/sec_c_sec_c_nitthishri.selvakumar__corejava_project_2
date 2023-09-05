package com.fssa.restorationbooking.builder;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

import com.fssa.restorationbooking.enums.CategoryOfItem;
import com.fssa.restorationbooking.model.BookingRequest;

public class BookingRequestBuilder {

	private String userEmailForBuilder;
	private String productNameForBuilder;
	private int bookingIdForBuilder;
	private String phoneNumberForBuilder;
	private boolean bookingStatusForBuilder;
	private String imageUrlForBuilder;
	private String bookingUserNameForBuilder;
	public String categoryOfItemForBuilder;
	private int productAgeForBuilder;
	private LocalDateTime bookingTimeForBuilder;

	public BookingRequestBuilder UserEmailBuilder(String userEmailForBuilder) {
		this.userEmailForBuilder = userEmailForBuilder;
		return this;
	}

	public BookingRequestBuilder ProductNameBuilder(String productNameForBuilder) {
		this.productNameForBuilder = productNameForBuilder;
		return this;
	}

	public BookingRequestBuilder BookingIdBuilder(int bookingIdForBuilder) {
		this.bookingIdForBuilder = bookingIdForBuilder;
		return this;
	}

	public BookingRequestBuilder PhoneNumberBuilder(String phoneNumberForBuilder) {
		this.phoneNumberForBuilder = phoneNumberForBuilder;
		return this;
	}

	public BookingRequestBuilder isBookingStatusBuilder(boolean bookingStatusForBuilder) {
		this.bookingStatusForBuilder = bookingStatusForBuilder;
		return this;
	}

	public BookingRequestBuilder ImageUrlBuilder(String imageUrlForBuilder) {
		this.imageUrlForBuilder = imageUrlForBuilder;
		return this;
	}

	public BookingRequestBuilder BookingUserNameBuilder(String bookingUserNameForBuilder) {
		this.bookingUserNameForBuilder = bookingUserNameForBuilder;
		return this;
	}

	public BookingRequestBuilder CategoryOfItemBuilder(String categoryOfItemForBuilder) {
		this.categoryOfItemForBuilder = categoryOfItemForBuilder;
		return this;
	}

	public BookingRequestBuilder ProductAgeBuilder(int productAgeForBuilder) {
		this.productAgeForBuilder = productAgeForBuilder;
		return this;
	}

	
	public BookingRequestBuilder getBookingTimeForBuilder(LocalDateTime bookingTimeForBuilder) {
		this.bookingTimeForBuilder = bookingTimeForBuilder;
		return this;
	}

	public BookingRequest build(){
		BookingRequest bookingRequest = new BookingRequest();
		bookingRequest.setUserEmail(userEmailForBuilder);
		bookingRequest.setProductName(productNameForBuilder);
		bookingRequest.setBookingId(bookingIdForBuilder);
		bookingRequest.setPhoneNumber(phoneNumberForBuilder);
		bookingRequest.setBookingStatus(bookingStatusForBuilder);
		bookingRequest.setImageUrl(imageUrlForBuilder);
		bookingRequest.setBookingUserName(bookingUserNameForBuilder);
		bookingRequest.setCategoryOfItem(categoryOfItemForBuilder); 
		bookingRequest.setProductAge(productAgeForBuilder);
		bookingRequest.setBookingTime(bookingTimeForBuilder);
		return bookingRequest;
		
	}
}

