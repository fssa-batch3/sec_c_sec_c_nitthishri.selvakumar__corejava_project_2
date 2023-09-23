package com.fssa.restorationbooking.errors;

public class PickupErrors {
	
	// Error message when the name is null or has less than 3 characters
    public static final String INVALID_NAME = "Name cannot be null or lesser than 3 characters";

    // Error message when the booking ID is less than 1
    public static final String INVALID_ID = "ID cannot be less than 1";
    
    // Error message when the pickup email format is invalid
    public static final String INVALID_EMAIL = " email format is invalid";
	
    // Error message when the phone number format is invalid
    public static final String INVALID_PHONENUMBER = "phone number format is invalid";
    
    // Error message when the pickup detail is null
    public static final String INVALID_OBJECT = "pickup detail cannot be null";
    
    // Error message when the pickup pincode is invalid
    public static final String INVALID_PINCODE ="pickup pincode is invalid";
    
    // Error message for an invalid written method
    public static final String INVALID_METHOD = "written method is wrong";
    
    // Error message when the pickup date is invalid
    public static final String INVALID_DATE ="pickup Date detail want to be day after today";
   
    // Error message when the pickup time is invalid
    public static final String INVALID_TIME ="pickup Time detail want to be from 9am to 7pm";
   
    
 
    
}
