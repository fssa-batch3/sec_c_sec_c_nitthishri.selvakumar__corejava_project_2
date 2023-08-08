package com.fssa.restorationbooking.validation;

import java.time.LocalDate;
import java.util.List;
import java.util.function.BooleanSupplier;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.fssa.restorationbooking.model.BookingErrors;
import com.fssa.restorationbooking.model.BookingRequest;

public class BookingValidation {
	public static boolean validateBookingDetails(BookingRequest bookingDetails) throws InvalidBookingDetailException {

		if (bookingDetails == null) {
			throw new InvalidBookingDetailException(BookingErrors.INVALID_OBJECT);
		} else {
			emailValidator(bookingDetails.getUserEmail());
			productNameValidator(bookingDetails.getProductName());
			bookingIdValidator(bookingDetails.getBookingId());
			phoneNumberValidator(bookingDetails.getPhoneNumber());
			// bookingStatusValidation(bookingDetails.isBookingStatus());
			imageUrlValidator(bookingDetails.getImageUrl());
			bookingUserNameValidator(bookingDetails.getBookingUserName());
			// bookingTimeValidator(bookingDetails.getBookingTime());
			productAgeValidator(bookingDetails.getProductAge());
//			validateProductLastRepair(bookingDetails.getProductLastRepair());
		}

		return true;

	}

//Method for the validation of the email given during booking
	public static boolean emailValidator(String userEmail) throws InvalidBookingDetailException {

		if (userEmail == null) {
			throw new InvalidBookingDetailException(BookingErrors.INVALID_OBJECT);
		}

		String regex = "^[a-zA-Z0-9_!#$%&'*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$";

		Boolean isMatchEmail = Pattern.matches(regex, userEmail);

		if (!isMatchEmail) {
			throw new InvalidBookingDetailException(BookingErrors.INVALID_EMAIL);
		}

		System.out.println("Valid Email Address");

		return true;

	}

//Method for the validation of the productName given during the booking
	public static boolean productNameValidator(String productName) throws InvalidBookingDetailException {

		System.out.println(productName);

		if (productName == null || productName.isEmpty()) {
			throw new InvalidBookingDetailException(BookingErrors.INVALID_OBJECT);
		}

		String nameregex = "^[a-zA-Z ]{2,35}$";
		Pattern pattern = Pattern.compile(nameregex);
		Matcher matcher = pattern.matcher(productName);
		Boolean isMatch = matcher.matches();

		if (!isMatch) {
			throw new InvalidBookingDetailException(BookingErrors.INVALID_NAME);

		}

		return true;

	}

//  Method for the validation of the bookingid given during the booking

	public static boolean bookingIdValidator(int bookingId) throws InvalidBookingDetailException {

		if (bookingId == 0) {
			throw new InvalidBookingDetailException(BookingErrors.INVALID_ID);
		}

		return true;

	}

// Method for the validation of the phonenumber given during the booking

	public static boolean phoneNumberValidator(String phoneNumber) throws InvalidBookingDetailException {

		if (phoneNumber == null || "".equals(phoneNumber.trim())) {
			throw new InvalidBookingDetailException(BookingErrors.INVALID_OBJECT);
		}

//    regex pattern for India's phone number format
		String numberregex = "[2-9][0-9]{9}";
		Pattern pattern = Pattern.compile(numberregex);
		Matcher matcher = pattern.matcher(phoneNumber);
		Boolean isMatchPhoneNumber = matcher.matches();

		if (!isMatchPhoneNumber) {
			throw new InvalidBookingDetailException(BookingErrors.INVALID_PHONENUMBER);

		}

		return true;

	}

// Method for the validation of the imageurl given during the booking

	public static boolean imageUrlValidator(String imageUrl) throws InvalidBookingDetailException {
		if (imageUrl == null || "".equals(imageUrl.trim())) {
			throw new InvalidBookingDetailException(BookingErrors.INVALID_OBJECT);
		}

		// regex pattern for image URL format
		String imageurlregex = "\\bhttps?:\\/\\/\\S+\\.(?:png|jpe?g|gif|bmp|webp)\\b";
		Pattern pattern = Pattern.compile(imageurlregex);
		Matcher matcher = pattern.matcher(imageUrl);
		boolean isMatchImageUrl = matcher.matches();

		if (!isMatchImageUrl) {
			throw new InvalidBookingDetailException(BookingErrors.INVALID_IMAGEURL);
		}

		return true;
	}

// Method for the validation of the bookingusername given during the booking
	public static boolean bookingUserNameValidator(String bookingUserName) throws InvalidBookingDetailException {
		
		System.out.println(bookingUserName);

		if (bookingUserName == null || "".equals(bookingUserName.trim())) {
			throw new InvalidBookingDetailException(BookingErrors.INVALID_OBJECT);
		}

		String nameregex = "^[^0-9]*$";
//		Pattern pattern = Pattern.compile(nameregex);
//		Matcher matcher = pattern.matcher(bookingUserName);
		Boolean isMatchBookingUserName = Pattern.matches(nameregex, bookingUserName);

		if (!isMatchBookingUserName || bookingUserName.length() < 3 ||  bookingUserName.length() > 35 ) {
			throw new InvalidBookingDetailException(BookingErrors.INVALID_NAME);

		}

		return true;

	}



	public static boolean productAgeValidator(int productAge) {

		if (productAge <= 10) {
			throw new InvalidBookingDetailException(BookingErrors.INVALID_PRODUCTAGE);

		}

		return true;
	}



//	public static boolean validateProductLastRepair(LocalDate productLastRepair) {
//		LocalDate currentDate = LocalDate.now();
//		if (productLastRepair == null) {
//			throw new InvalidBookingDetailException(BookingErrors.INVALID_OBJECT);
//		}
//		if (productLastRepair.isAfter(currentDate)) {
//			throw new InvalidBookingDetailException(BookingErrors.INVALID_TIME);
//		}
//		if (productLastRepair.equals(currentDate)) {
//			throw new InvalidBookingDetailException(BookingErrors.INVALID_TIME);
//		}
//
////        LocalDate minimumRepairDate = currentDate.minusYears(10);
////
////        if (productLastRepair.isAfter(minimumRepairDate)) {
////        	 throw new InvalidBookingDetailException(BookingErrors.INVALID_PRODUCT);
////        }
//
//		return true;
//
//	}

}
