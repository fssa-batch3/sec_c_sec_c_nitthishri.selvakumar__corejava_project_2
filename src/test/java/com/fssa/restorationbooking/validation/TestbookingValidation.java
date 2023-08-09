<<<<<<< HEAD
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

	// test case for the valid productlastRepair
//	@Test
//	public void TestValidProductLastRepair() {
//		LocalDate currentDate = LocalDate.now();
//		LocalDate minimumDate = currentDate.minusYears(10);
//		Assertions.assertTrue(BookingValidation.validateProductLastRepair(minimumDate));
//	}
//
//	// test case for the Invalid productlastrepair
//	@Test
//	public void TestInvalidProductLastRepair() {
//
//		try {
//			BookingValidation.validateProductLastRepair(null);
//			Assertions.fail(BookingErrors.INVALID_METHOD);
//		} catch (InvalidBookingDetailException e) {
//			Assertions.assertEquals(BookingErrors.INVALID_OBJECT, e.getMessage());
//		}
//
//		try {
//			LocalDate currentDate = LocalDate.now();
//			BookingValidation.validateProductLastRepair(currentDate);
//			Assertions.fail(BookingErrors.INVALID_METHOD);
//		} catch (InvalidBookingDetailException e) {
//			Assertions.assertEquals(BookingErrors.INVALID_TIME, e.getMessage());
//		}
//		try {
//			LocalDate currentDate = LocalDate.now();
//			LocalDate productLastRepair = currentDate.plusDays(1);
//			BookingValidation.validateProductLastRepair(productLastRepair);
//			Assertions.fail(BookingErrors.INVALID_METHOD);
//		} catch (InvalidBookingDetailException e) {
//			Assertions.assertEquals(BookingErrors.INVALID_TIME, e.getMessage());
//		}
//	}
	
//	@Test
//	 public void TestValidCategoryOfItem() {
//		String[] arr = {"home furniture","radio","camera","voice recorder","vintage switch","gramophone","walkman","amplifier","calculator","television","computer","television","computer","tailoring machine","bettermass light","fan","other"};
//	        List<String> validCategoryOfItem = Arrays.asList(arr);
//	        Assertions.assertTrue(BookingValidation.categoryOfItemValidator(validCategoryOfItem));
//	    }
//	@Test 
//	public void TestInvalidCategoryOfItem() {
//		try {
//			BookingValidation.categoryOfItemValidator(null);
//			Assertions.fail(BookingErrors.INVALID_METHOD);
//		}
//		catch(InvalidBookingDetailException e){
//			Assertions.assertEquals(BookingErrors.INVALID_OBJECT, e.getMessage());
//		}
//	}

}
=======
package com.fssa.restorationbooking.validation;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.fssa.restorationbooking.model.BookingErrors;
import com.fssa.restorationbooking.validation.BookingValidation;
import com.fssa.restorationbooking.validation.InvalidBookingDetailException;

//Hello
//Hello 2

public class TestbookingValidation {

	// test case for the valid all booking details
	
	@Test
	public void TestInvalidateBookingDetails() {
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
	public void TestValidEmailValidator() {
		Assertions.assertTrue(BookingValidation.emailValidator("nitthishri@gmail.com"));
	}

	// test case for the Invalid emailID
	
	@Test
	public void TestInvalidEmailValidator() {

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
	public void TestValidProductName() {
		Assertions.assertTrue(BookingValidation.emailValidator("nitthishri@gmail.com"));
	}

	// test case for the Invalid productname
	@Test
	public void TestInvalidProductName() {

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
	public void TestValidBookingIdValidator() {
		Assertions.assertTrue(BookingValidation.bookingIdValidator(23));

	}

//	test for invalid booking Id
	@Test
	public void TestInvalidBookingIdValidator() {

		try {

			BookingValidation.bookingIdValidator(0);
			Assertions.fail(BookingErrors.INVALID_METHOD);
		} catch (InvalidBookingDetailException e) {
			Assertions.assertEquals(BookingErrors.INVALID_ID, e.getMessage());
		}
	}

	// test case for the valid phoneNumber
	@Test
	public void TestValidPhoneNumber() {
		Assertions.assertTrue(BookingValidation.phoneNumberValidator("9876543215"));
	}

	// test case for the Invalid phoneNumber
	@Test
	public void TestInvalidPhoneNumber() {

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
	public void TestValidImageUrl() {
		Assertions.assertTrue(BookingValidation.imageUrlValidator("https://iili.io/HZoYqJa.png"));

	}

	// test case for the Invalid phoneNumber
	@Test
	public void TestInvalidImageUrl() {

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
	public void TestValidBookingUserName() {
		Assertions.assertTrue(BookingValidation.emailValidator("nitthishri@gmail.com"));
	}

	// test case for the Invalid bookingusername
	@Test
	public void TestInvalidBookingUserName() {

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
	public void TestValidAgeValidator() {
		Assertions.assertTrue(BookingValidation.productAgeValidator(23));

	}

//				test for invalid booking Id
	@Test
	public void TestInvalidAgeValidator() {

		try {

			BookingValidation.productAgeValidator(0);
			Assertions.fail(BookingErrors.INVALID_METHOD);
		} catch (InvalidBookingDetailException e) {
			Assertions.assertEquals(BookingErrors.INVALID_PRODUCTAGE, e.getMessage());

		}
	}

	// test case for the valid productlastRepair
//	@Test
//	public void TestValidProductLastRepair() {
//		LocalDate currentDate = LocalDate.now();
//		LocalDate minimumDate = currentDate.minusYears(10);
//		Assertions.assertTrue(BookingValidation.validateProductLastRepair(minimumDate));
//	}
//
//	// test case for the Invalid productlastrepair
//	@Test
//	public void TestInvalidProductLastRepair() {
//
//		try {
//			BookingValidation.validateProductLastRepair(null);
//			Assertions.fail(BookingErrors.INVALID_METHOD);
//		} catch (InvalidBookingDetailException e) {
//			Assertions.assertEquals(BookingErrors.INVALID_OBJECT, e.getMessage());
//		}
//
//		try {
//			LocalDate currentDate = LocalDate.now();
//			BookingValidation.validateProductLastRepair(currentDate);
//			Assertions.fail(BookingErrors.INVALID_METHOD);
//		} catch (InvalidBookingDetailException e) {
//			Assertions.assertEquals(BookingErrors.INVALID_TIME, e.getMessage());
//		}
//		try {
//			LocalDate currentDate = LocalDate.now();
//			LocalDate productLastRepair = currentDate.plusDays(1);
//			BookingValidation.validateProductLastRepair(productLastRepair);
//			Assertions.fail(BookingErrors.INVALID_METHOD);
//		} catch (InvalidBookingDetailException e) {
//			Assertions.assertEquals(BookingErrors.INVALID_TIME, e.getMessage());
//		}
//	}
	
//	@Test
//	 public void TestValidCategoryOfItem() {
//		String[] arr = {"home furniture","radio","camera","voice recorder","vintage switch","gramophone","walkman","amplifier","calculator","television","computer","television","computer","tailoring machine","bettermass light","fan","other"};
//	        List<String> validCategoryOfItem = Arrays.asList(arr);
//	        Assertions.assertTrue(BookingValidation.categoryOfItemValidator(validCategoryOfItem));
//	    }
//	@Test 
//	public void TestInvalidCategoryOfItem() {
//		try {
//			BookingValidation.categoryOfItemValidator(null);
//			Assertions.fail(BookingErrors.INVALID_METHOD);
//		}
//		catch(InvalidBookingDetailException e){
//			Assertions.assertEquals(BookingErrors.INVALID_OBJECT, e.getMessage());
//		}
//	}

}
>>>>>>> 16945bd60c50791654cfe1cb6a7b8b3e99b29cc2
