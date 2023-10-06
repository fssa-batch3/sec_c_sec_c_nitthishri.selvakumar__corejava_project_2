package com.fssa.restorationbooking.validation;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.fssa.restorationbooking.errors.BookingErrors;
import com.fssa.restorationbooking.errors.InvalidBookingDetailException;
import com.fssa.restorationbooking.errors.InvalidPickUpDetailException;
import com.fssa.restorationbooking.errors.PickupErrors;
import com.fssa.restorationbooking.model.PickupRequest;

public class PickupValidation {

	
	public static boolean validatePickUpDetails(PickupRequest pickUpDetails) throws InvalidPickUpDetailException {
		if (pickUpDetails == null) {
			throw new InvalidPickUpDetailException(PickupErrors.INVALID_OBJECT);
		}
		else {
			pickupNameValidation(pickUpDetails.getPickupName());
			pickupPhoneNumberValidation(pickUpDetails.getPickupPhoneNumber());
			pickupEmailValidator(pickUpDetails.getEmail());
			pickupAddressValidation(pickUpDetails.getPickupAddress());
			pickupLandMarkValidation(pickUpDetails.getPickupLandMark());
			pickupPincodeValidation(pickUpDetails.getPickupPincode());
			pickupDateValidation(pickUpDetails.getPickupDate());
			pickupTimeValidation(pickUpDetails.getPickupTime());
			
		}
		
		return true;
	}
	
	public static boolean validatePickUpDetails1(PickupRequest pickUpDetails) throws InvalidPickUpDetailException {
		if (pickUpDetails == null) {
			throw new InvalidPickUpDetailException(PickupErrors.INVALID_OBJECT);
		}
		else {
			pickupNameValidation(pickUpDetails.getPickupName());
			pickupPhoneNumberValidation(pickUpDetails.getPickupPhoneNumber());
			pickupAddressValidation(pickUpDetails.getPickupAddress());
			pickupLandMarkValidation(pickUpDetails.getPickupLandMark());
			pickupPincodeValidation(pickUpDetails.getPickupPincode());
			pickupDateValidation(pickUpDetails.getPickupDate());
			pickupTimeValidation(pickUpDetails.getPickupTime());
			
		}
		
		return true;
	}
	
	
	
	//Method for the validation of the email given during booking
		public static boolean pickupEmailValidator(String userEmail) throws InvalidPickUpDetailException {

			if (userEmail == null) {
				throw new InvalidPickUpDetailException(PickupErrors.INVALID_OBJECT);
			}

			String regex = "^[a-zA-Z0-9_!#$%&'*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$";

			Boolean isMatchEmail = Pattern.matches(regex, userEmail);

			if (!isMatchEmail) {
				throw new InvalidPickUpDetailException(PickupErrors.INVALID_EMAIL);
			}

			System.out.println("Valid Email Address");

			return true;

		}
	// Method for the validation of the pickup name given during the booking
	public static boolean pickupNameValidation(String pickupUserName) throws InvalidPickUpDetailException {

		System.out.println(pickupUserName);

		if (pickupUserName == null || "".equals(pickupUserName.trim())) {
			throw new InvalidPickUpDetailException(PickupErrors.INVALID_OBJECT);
		}

		String nameregex = "^[^0-9]*$";
//			Pattern pattern = Pattern.compile(nameregex);
//			Matcher matcher = pattern.matcher(bookingUserName);
		Boolean isMatchBookingUserName = Pattern.matches(nameregex, pickupUserName);

		if (!isMatchBookingUserName || pickupUserName.length() < 3 || pickupUserName.length() > 35) {
			throw new InvalidPickUpDetailException(PickupErrors.INVALID_NAME);

		}

		return true;

	}

	public static boolean pickupPhoneNumberValidation(long phoneNumber) throws InvalidPickUpDetailException {
	    String phoneNumberStr = String.valueOf(phoneNumber); // Convert long to String

	    if (phoneNumberStr == null || phoneNumberStr.trim().isEmpty()) {
	        throw new InvalidPickUpDetailException(PickupErrors.INVALID_OBJECT);
	    }

	    // Regex pattern for India's phone number format
	    String numberRegex = "[2-9][0-9]{9}";
	    Pattern pattern = Pattern.compile(numberRegex);
	    Matcher matcher = pattern.matcher(phoneNumberStr);
	    boolean isMatchPhoneNumber = matcher.matches();

	    if (!isMatchPhoneNumber) {
	        throw new InvalidPickUpDetailException(PickupErrors.INVALID_PHONENUMBER);
	    }

	    return true;
	}


	public static boolean pickupAddressValidation(String userAddress) throws InvalidPickUpDetailException {
		if (userAddress == null || "".equals(userAddress.trim())) {
			throw new InvalidPickUpDetailException(PickupErrors.INVALID_ADDRESS);
		}

		/**
		 * regex pattern for user address
		 */
		String descregex = "^[^ .]+( [^ .]+)*$";
		Pattern pattern = Pattern.compile(descregex);
		Matcher matcher = pattern.matcher(userAddress);
		boolean isMatch = matcher.matches();

		if (isMatch) {
			return true;
		} else {
			throw new InvalidPickUpDetailException(PickupErrors.INVALID_ADDRESS);
		}
	}
	// Method for the validation of the pickup address
	public static boolean pickupLandMarkValidation(String pickupLandMark) throws InvalidPickUpDetailException {
		if (pickupLandMark == null || pickupLandMark.trim().isEmpty()) {
			throw new InvalidPickUpDetailException(PickupErrors.INVALID_OBJECT);
		}
		return true;
	}
	
	public static boolean pickupPincodeValidation(int pincode) throws InvalidPickUpDetailException {
	    String pincodeStr = Integer.toString(pincode);

	    // Define the regular expression for a 6-digit pincode
	    String regex = "^\\d{6}$";

	    // Check if the pincodeStr is null or empty
	    if (pincodeStr == null || pincodeStr.trim().isEmpty()) {
	        throw new InvalidPickUpDetailException(PickupErrors.INVALID_PINCODE);
	    }

	    // Check if the pincodeStr matches the regex pattern
	    if (!pincodeStr.matches(regex)) {
	        throw new InvalidPickUpDetailException(PickupErrors.INVALID_PINCODE);
	    }

	    // If all checks pass, the pincode is valid
	    return true;
	}

	  public static void pickupDateValidation(LocalDate pickupDate) throws InvalidPickUpDetailException {
	        if (pickupDate == null) {
	            throw new InvalidPickUpDetailException(PickupErrors.INVALID_OBJECT);
	        }

	        LocalDate today = LocalDate.now();
	        LocalDate oneDayFromToday = today.plusDays(1);
	        LocalDate tenDaysFromToday = today.plusDays(10);

	        if (pickupDate.isBefore(oneDayFromToday) || pickupDate.isAfter(tenDaysFromToday)) {
	            throw new InvalidPickUpDetailException(PickupErrors.INVALID_DATE);
	        }
	    }
    
    public static void pickupTimeValidation(LocalTime time) throws InvalidPickUpDetailException {
        if (time == null) {
            throw new InvalidPickUpDetailException(PickupErrors.INVALID_OBJECT);
        }

        LocalTime startTime = LocalTime.of(9, 0);  // 9 am
        LocalTime endTime = LocalTime.of(19, 0);  // 7 pm

        if (time.isBefore(startTime) || time.isAfter(endTime)) {
            throw new InvalidPickUpDetailException(PickupErrors.INVALID_TIME);
        }

       
    }

	
	
}
