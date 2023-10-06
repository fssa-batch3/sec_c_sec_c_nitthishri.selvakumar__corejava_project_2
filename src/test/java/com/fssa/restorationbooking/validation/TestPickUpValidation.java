package com.fssa.restorationbooking.validation;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import java.time.LocalDate;
import java.time.LocalTime;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.fssa.restorationbooking.errors.BookingErrors;
import com.fssa.restorationbooking.errors.InvalidPickUpDetailException;
import com.fssa.restorationbooking.errors.PickupErrors;

public class TestPickUpValidation {

	

	@Test
	void testValidEmailValidator() {
		try {
			Assertions.assertTrue(PickupValidation.pickupEmailValidator("nitthishri@gmail.com"));
		} catch (InvalidPickUpDetailException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 	}
 
	// test case for the Invalid emailID

	@Test
	void testInvalidEmailValidator() {

		try {

			PickupValidation.pickupEmailValidator(null);
			Assertions.fail(BookingErrors.INVALID_METHOD);
		} catch (InvalidPickUpDetailException e) {
			Assertions.assertEquals(PickupErrors.INVALID_OBJECT, e.getMessage());
		}

		try {

			PickupValidation.pickupEmailValidator("nitthi234gmail.com");
			Assertions.fail(BookingErrors.INVALID_OBJECT);
		} catch (InvalidPickUpDetailException e) {
			Assertions.assertEquals(PickupErrors.INVALID_EMAIL, e.getMessage());
		}
	}

	@Test
	void testInvalidatePickUpDetails() {
		try {
			PickupValidation.validatePickUpDetails(null);
			Assertions.fail(PickupErrors.INVALID_METHOD);
		} catch (InvalidPickUpDetailException e) {
			Assertions.assertEquals(PickupErrors.INVALID_OBJECT, e.getMessage());
		}
	}

	void testInvalidatePickUpDetails1() {
		try {
			PickupValidation.validatePickUpDetails1(null);
			Assertions.fail(PickupErrors.INVALID_METHOD);
		} catch (InvalidPickUpDetailException e) {
			Assertions.assertEquals(PickupErrors.INVALID_OBJECT, e.getMessage());
		}
	}

	@Test
	void testValidPickupNameValidation() {
		try {
			boolean result = PickupValidation.pickupNameValidation("John Doe");
			Assertions.assertTrue(result);
		} catch (InvalidPickUpDetailException e) {
			Assertions.fail(PickupErrors.INVALID_NAME);
		}
	}

	// Test cases for invalid pickup names
	@Test
	void testInvalidPickupNameValidation() {
		try {
			// Null pickup name
			PickupValidation.pickupNameValidation(null);
			Assertions.fail(PickupErrors.INVALID_METHOD);
		} catch (InvalidPickUpDetailException e) {
			Assertions.assertEquals(PickupErrors.INVALID_OBJECT, e.getMessage());
		}

		try {
			// Name with digits
			PickupValidation.pickupNameValidation("John123");
			Assertions.fail(PickupErrors.INVALID_METHOD);
		} catch (InvalidPickUpDetailException e) {
			Assertions.assertEquals(PickupErrors.INVALID_NAME, e.getMessage());
		}

		try {
			// Name shorter than 3 characters
			PickupValidation.pickupNameValidation("Jo");
			Assertions.fail(PickupErrors.INVALID_METHOD);
		} catch (InvalidPickUpDetailException e) {
			Assertions.assertEquals(PickupErrors.INVALID_NAME, e.getMessage());
		}

		try {
			// Name longer than 35 characters
			PickupValidation.pickupNameValidation("ThisIsAReallyLongNameThatExceedsTheMaximumLengthAllowed");
			Assertions.fail(PickupErrors.INVALID_METHOD);
		} catch (InvalidPickUpDetailException e) {
			Assertions.assertEquals(PickupErrors.INVALID_NAME, e.getMessage());
		}
	}
	
	
	
	 @Test
	    void testValidPhoneNumber() {
	        try {
	            assertTrue(PickupValidation.pickupPhoneNumberValidation(9876543210L));
	        } catch (InvalidPickUpDetailException e) {
	        	Assertions.assertEquals(PickupErrors.INVALID_PHONENUMBER, e.getMessage());
	        }
	 }
	

	        void testInvalidPickupPhoneNumber() {
	        try {
	            // Phone number with invalid format
	            PickupValidation.pickupPhoneNumberValidation(123456789); // Assuming this is an invalid format
	            Assertions.fail(PickupErrors.INVALID_METHOD);
	        } catch (InvalidPickUpDetailException e) {
	            Assertions.assertEquals(PickupErrors.INVALID_PHONENUMBER, e.getMessage());
	        }
	        
	        // Add more test cases as needed for other invalid scenarios
	    }
	    
	    

	    

	   	@Test
	   	void testValidUserAddress() throws InvalidPickUpDetailException {

	   		Assertions.assertTrue(
	   				PickupValidation.pickupAddressValidation("48/A,Tiruneelakandar street,pattamadai"));
	   	}

	   	/**
	   	 * test for invalid user address when it is null.
	   	 */
	   	void testInvalidUserAddress() {
	        // Test for null address
	        try {
	            PickupValidation.pickupAddressValidation(null);
	            Assertions.fail("Expected InvalidPickUpDetailException");
	        } catch (InvalidPickUpDetailException e) {
	            Assertions.assertEquals(PickupErrors.INVALID_ADDRESS, e.getMessage());
	        }

	        // Test for an address with less than 15 characters
	        try {
	            PickupValidation.pickupAddressValidation("street");
	            Assertions.fail("Expected InvalidPickUpDetailException");
	        } catch (InvalidPickUpDetailException e) {
	            Assertions.assertEquals(PickupErrors.INVALID_ADDRESS, e.getMessage());
	        }

	        // Test for an address with more than 100 characters
	        try {
	            PickupValidation.pickupAddressValidation("This is a very long address with more than 100 characters. It should fail validation.");
	            Assertions.fail("Expected InvalidPickUpDetailException");
	        } catch (InvalidPickUpDetailException e) {
	            Assertions.assertEquals(PickupErrors.INVALID_ADDRESS, e.getMessage());
	        }
	    }

	    @Test
	    void testValidPickupLandMark() {
	        try {
	        	Assertions.assertTrue(PickupValidation.pickupLandMarkValidation("Landmark"));
	        } catch (InvalidPickUpDetailException e) {
	        	Assertions.fail(PickupErrors.INVALID_OBJECT);
	        }
	    }

	    @Test
	    void testInvalidPickupLandMark() {
	        try {
	            PickupValidation.pickupLandMarkValidation(null);
	            Assertions.fail(PickupErrors.INVALID_METHOD);
	        } catch (InvalidPickUpDetailException e) {
	        	Assertions.assertEquals(PickupErrors.INVALID_OBJECT, e.getMessage());
	        }
	 
	        try {
	            PickupValidation.pickupLandMarkValidation("");
	            Assertions.fail(PickupErrors.INVALID_METHOD);
	        } catch (InvalidPickUpDetailException e) {
	        	Assertions.assertEquals(PickupErrors.INVALID_OBJECT, e.getMessage());
	        }
	    }
	    
	    @Test
	    public void testValidPincode() {
	        // Valid 6-digit pincode
	        int validPincode = 123456;
	        try {
	        	Assertions.assertTrue(PickupValidation.pickupPincodeValidation(validPincode));
	        } catch (InvalidPickUpDetailException e) {
	            fail("Unexpected InvalidPickUpDetailException");
	        }
	    }

	    @Test
	    public void testInvalidPincode() {
	        // Empty pincode
	        int emptyPincode = 0; // Assuming 0 represents an empty pincode
	        try {
	            Assertions.assertFalse(PickupValidation.pickupPincodeValidation(emptyPincode));
	        } catch (InvalidPickUpDetailException e) {
	            assertEquals(PickupErrors.INVALID_PINCODE, e.getMessage());
	        }
	    
	        // Pincode longer than 6 digits
	        int longPincode = 1234567;
	        try {
	        	Assertions.assertFalse(PickupValidation.pickupPincodeValidation(longPincode));
	        } catch (InvalidPickUpDetailException e) {
	        	Assertions.assertEquals(PickupErrors.INVALID_PINCODE, e.getMessage());
	        }
	    
	       
}
	    @Test
	    void testValidPickupDate() {
	        try {
	            LocalDate today = LocalDate.now();
	            LocalDate validPickupDate = today.plusDays(3); // A date 3 days from today
	            PickupValidation.pickupDateValidation(validPickupDate);
	        } catch (InvalidPickUpDetailException e) {
	            Assertions.fail(PickupErrors.INVALID_DATE);
	        }
	    }

	    @Test
	    void testNullPickupDate() {
	        try {
	            PickupValidation.pickupDateValidation(null);
	            Assertions.fail(PickupErrors.INVALID_METHOD);
	        } catch (InvalidPickUpDetailException e) {
	            assertEquals(PickupErrors.INVALID_OBJECT, e.getMessage());
	        }
	    }

	    @Test
	    void testInvalidPickupDateInPast() {
	        try {
	            LocalDate today = LocalDate.now();
	            LocalDate invalidPickupDate = today.minusDays(1); // A date before today
	            PickupValidation.pickupDateValidation(invalidPickupDate);
	            Assertions.fail(PickupErrors.INVALID_DATE);
	        } catch (InvalidPickUpDetailException e) {
	            assertEquals(PickupErrors.INVALID_DATE, e.getMessage());
	        }
	    }

	    @Test
	    void testInvalidPickupDateMoreThan10DaysFromToday() {
	        try {
	            LocalDate today = LocalDate.now();
	            LocalDate invalidPickupDate = today.plusDays(11); // A date more than 10 days from today
	            PickupValidation.pickupDateValidation(invalidPickupDate);
	            Assertions.fail(PickupErrors.INVALID_DATE);
	        } catch (InvalidPickUpDetailException e) {
	            assertEquals(PickupErrors.INVALID_DATE, e.getMessage());
	        }
	    }

	    @Test
	    void testValidPickupTime() {
	        try {
	            LocalTime validTime = LocalTime.of(12, 0); // A valid time (12:00 PM)
	            PickupValidation.pickupTimeValidation(validTime);
	        } catch (InvalidPickUpDetailException e) {
	            Assertions.fail(PickupErrors.INVALID_TIME);
	        }
	    }

	    @Test
	    void testNullPickupTime() {
	        try {
	            PickupValidation.pickupTimeValidation(null);
	            Assertions.fail(PickupErrors.INVALID_METHOD);
	        } catch (InvalidPickUpDetailException e) {
	            Assertions.assertEquals(PickupErrors.INVALID_OBJECT, e.getMessage());
	        }
	    }

	    @Test
	    void testInvalidPickupTime() {
	        try {
	            LocalTime invalidTime = LocalTime.of(8, 0); // A time before the valid range (8:00 AM)
	            PickupValidation.pickupTimeValidation(invalidTime);
	            Assertions.fail(PickupErrors.INVALID_METHOD);
	        } catch (InvalidPickUpDetailException e) {
	            Assertions.assertEquals(PickupErrors.INVALID_TIME, e.getMessage());
	        }
	    }
	        
}
