
package com.fssa.restorationbooking.model;

public interface BookingErrors {

    // Error message when the booking detail is null
    public static final String INVALID_OBJECT = "booking detail cannot be null";

    // Error message when the name is null or has less than 3 characters
    public static final String INVALID_NAME = "Name cannot be null or lesser than 3 characters";

    // Error message when the booking ID is less than 1
    public static final String INVALID_ID = "booking ID cannot be less than 1";

    // Error message when the booking imageURL format is invalid
    public static final String INVALID_IMAGEURL = "booking imageURL format is invalid";

    // Error message when the booking email format is invalid
    public static final String INVALID_EMAIL = "booking email format is invalid";

    // Error message when the booking time is the current time or after the current date
    public static final String INVALID_TIME = "Time cannot be current time and after the current date";

    // Error message when the product age is less than 10 years
    public static final String INVALID_PRODUCTAGE = "Product should be more than 10 years old";

    // Error message when the phone number format is invalid
    public static final String INVALID_PHONENUMBER = "phone number format is invalid";

    // Error message for an invalid written method
    public static final String INVALID_METHOD = "written method is wrong";

    // Error message for an invalid last repair date
    public static final String INVALID_LASTREPAIR = "last repair date is invalid";

    // Error message for an invalid option selection
    public static final String INVALID_OPTION = "the option that you selected is invalid";
}