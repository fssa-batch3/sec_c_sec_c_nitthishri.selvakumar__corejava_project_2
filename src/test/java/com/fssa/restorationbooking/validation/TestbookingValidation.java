package com.fssa.restorationbooking.validation;

import java.time.LocalDate; 
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.fssa.restorationbooking.model.BookingErrors;
import com.fssa.restorationbooking.validation.BookingValidation;
import com.fssa.restorationbooking.validation.InvalidBookingDetailException;

public class TestbookingValidation {

	// test case for the valid all booking details
	
	@Test
	public void testInvalidateBookingDetails() {
		try{
			BookingValidation.validateBookingDetails(null);
			Assertions.fail(BookingErrors.INVALID_METHOD); 
		}
		catch (InvalidBookingDetailException e) {
			Assertions.assertEquals(BookingErrors.INVALID_OBJECT, e.getMessage());
		}		
	}

	// test case for the valid emailID
	
	@Test
	public void testValidEmailValidator() {
		Assertions.assertTrue(BookingValidation.emailValidator("nitthishri@gmail.com"));
	}

	// test case for the Invalid emailID
	
	@Test
	public void testInvalidEmailValidator() {

		try {

			BookingValidation.emailValidator(null);
			Assertions.fail(BookingErrors.INVALID_METHOD);
		} catch (InvalidBookingDetailException e) {
			Assertions.assertEquals(BookingErrors.INVALID_OBJECT, e.getMessage());
		}

		try {

			BookingValidation.emailValidator("nitthi234gmail.com");
			Assertions.fail(BookingErrors.INVALID_OBJECT);
		} catch (InvalidBookingDetailException e) {
			Assertions.assertEquals(BookingErrors.INVALID_EMAIL, e.getMessage());
		}
	}

	// test case for the valid productname
	@Test
	public void testValidProductName() {
		Assertions.assertTrue(BookingValidation.emailValidator("nitthishri@gmail.com"));
	}

	// test case for the Invalid productname
	@Test
	public void testInvalidProductName() {

		try {
 
			BookingValidation.productNameValidator(null);
			Assertions.fail(BookingErrors.INVALID_METHOD);
		} catch (InvalidBookingDetailException e) {
			Assertions.assertEquals(BookingErrors.INVALID_OBJECT, e.getMessage());
		}

		try {

			BookingValidation.productNameValidator("p");
			Assertions.fail(BookingErrors.INVALID_METHOD);
		} catch (InvalidBookingDetailException e) {
			Assertions.assertEquals(BookingErrors.INVALID_NAME, e.getMessage());
		}
	}

//	test for valid booking Id
	@Test
	public void testValidBookingIdValidator() {
		Assertions.assertTrue(BookingValidation.bookingIdValidator(23));

	}

//	test for invalid booking Id
	@Test
	public void testInvalidBookingIdValidator() {

		try {

			BookingValidation.bookingIdValidator(0);
			Assertions.fail(BookingErrors.INVALID_METHOD);
		} catch (InvalidBookingDetailException e) {
			Assertions.assertEquals(BookingErrors.INVALID_ID, e.getMessage());
		}
	}

	// test case for the valid phoneNumber
	@Test
	public void testValidPhoneNumber() {
		Assertions.assertTrue(BookingValidation.phoneNumberValidator("9876543215"));
	}

	// test case for the Invalid phoneNumber
	@Test
	public void testInvalidPhoneNumber() {

		try {

			BookingValidation.phoneNumberValidator(null);
			Assertions.fail(BookingErrors.INVALID_METHOD);
		} catch (InvalidBookingDetailException e) {
			Assertions.assertEquals(BookingErrors.INVALID_OBJECT, e.getMessage());
		}

		try {

			BookingValidation.phoneNumberValidator("234");
			Assertions.fail(BookingErrors.INVALID_METHOD);
		} catch (InvalidBookingDetailException e) {
			Assertions.assertEquals(BookingErrors.INVALID_PHONENUMBER, e.getMessage());
		}
	}

	// test case for the valid phoneNumber
	@Test
	public void testValidImageUrl() {
		Assertions.assertTrue(BookingValidation.imageUrlValidator("https://iili.io/HZoYqJa.png"));

	}

	// test case for the Invalid phoneNumber
	@Test
	public void testInvalidImageUrl() {

		try {

			BookingValidation.imageUrlValidator(null);
			Assertions.fail(BookingErrors.INVALID_METHOD);
		} catch (InvalidBookingDetailException e) {
			Assertions.assertEquals(BookingErrors.INVALID_OBJECT, e.getMessage());
		}

		try {
			BookingValidation.imageUrlValidator("piano");
			Assertions.fail(BookingErrors.INVALID_METHOD);
		} catch (InvalidBookingDetailException e) {
			Assertions.assertEquals(BookingErrors.INVALID_IMAGEURL, e.getMessage());
		}
	}

	// test case for the valid bookingusername
	@Test
	public void testValidBookingUserName() {
		Assertions.assertTrue(BookingValidation.emailValidator("nitthishri@gmail.com"));
	}

	// test case for the Invalid bookingusername
	@Test
	public void testInvalidBookingUserName() {

		try {

			BookingValidation.bookingUserNameValidator(null);
			Assertions.fail(BookingErrors.INVALID_METHOD);
		} catch (InvalidBookingDetailException e) {
			Assertions.assertEquals(BookingErrors.INVALID_OBJECT, e.getMessage());
		}

		try {

			BookingValidation.bookingUserNameValidator("p");
			Assertions.fail(BookingErrors.INVALID_METHOD);
		} catch (InvalidBookingDetailException e) {
			Assertions.assertEquals(BookingErrors.INVALID_NAME, e.getMessage());
		}
	}

//				test for valid booking Id
	@Test
	public void testValidAgeValidator() {
		Assertions.assertTrue(BookingValidation.productAgeValidator(23));

	}

//				test for invalid booking Id
	@Test
	public void testInvalidAgeValidator() {

		try {

			BookingValidation.productAgeValidator(0);
			Assertions.fail(BookingErrors.INVALID_METHOD);
		} catch (InvalidBookingDetailException e) {
			Assertions.assertEquals(BookingErrors.INVALID_PRODUCTAGE, e.getMessage());

		}
	}



}
