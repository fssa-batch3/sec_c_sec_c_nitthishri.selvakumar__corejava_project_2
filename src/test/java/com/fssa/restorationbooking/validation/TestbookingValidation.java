package com.fssa.restorationbooking.validation;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.fssa.restorationbooking.model.BookingErrors;

public class TestbookingValidation {

	// test case for the valid all booking details

	@Test
	void testInvalidateBookingDetails() {
		try {
			BookingValidation.validateBookingDetails(null);
			Assertions.fail(BookingErrors.INVALID_METHOD);
		} catch (InvalidBookingDetailException e) {
			Assertions.assertEquals(BookingErrors.INVALID_OBJECT, e.getMessage());
		}
	}

	// test case for the valid emailID

	@Test
	void testValidEmailValidator() {
		Assertions.assertTrue(BookingValidation.emailValidator("nitthishri@gmail.com"));
	}

	// test case for the Invalid emailID

	@Test
	void testInvalidEmailValidator() {

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
	void testValidProductName() {
		Assertions.assertTrue(BookingValidation.emailValidator("nitthishri@gmail.com"));
	}

	// test case for the Invalid productname
	@Test
	void testInvalidProductName() {

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
	 void testValidBookingIdValidator() {
		Assertions.assertTrue(BookingValidation.bookingIdValidator(23));

	}

//	test for invalid booking Id
	@Test
	 void testInvalidBookingIdValidator() {

		try {

			BookingValidation.bookingIdValidator(0);
			Assertions.fail(BookingErrors.INVALID_METHOD);
		} catch (InvalidBookingDetailException e) {
			Assertions.assertEquals(BookingErrors.INVALID_ID, e.getMessage());
		}
	}

	// test case for the valid phoneNumber
	@Test
	 void testValidPhoneNumber() {
		Assertions.assertTrue(BookingValidation.phoneNumberValidator("9876543215"));
	}

	// test case for the Invalid phoneNumber
	@Test
	 void testInvalidPhoneNumber() {

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
	 void testValidImageUrl() {
		Assertions.assertTrue(BookingValidation.imageUrlValidator("https://iili.io/HZoYqJa.png"));

	}

	// test case for the Invalid phoneNumber
	@Test
	 void testInvalidImageUrl() {

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
	 void testValidBookingUserName() {
		Assertions.assertTrue(BookingValidation.emailValidator("nitthishri@gmail.com"));
	}

	// test case for the Invalid bookingusername
	@Test
	 void testInvalidBookingUserName() {

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
	 void testValidAgeValidator() {
		Assertions.assertTrue(BookingValidation.productAgeValidator(23));

	}

//				test for invalid booking Id
	@Test
	 void testInvalidAgeValidator() {

		try {

			BookingValidation.productAgeValidator(0);
			Assertions.fail(BookingErrors.INVALID_METHOD);
		} catch (InvalidBookingDetailException e) {
			Assertions.assertEquals(BookingErrors.INVALID_PRODUCTAGE, e.getMessage());

		}
	}

}
