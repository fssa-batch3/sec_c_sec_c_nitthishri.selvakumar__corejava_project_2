package com.fssa.restorationbooking.validation;

import com.fssa.restorationbooking.enums.CategoryOfItem;
import com.fssa.restorationbooking.errors.BookingErrors;
import com.fssa.restorationbooking.errors.InvalidBookingDetailException;


public class EnumValidation {

    
    public static boolean isValidCategoryOfItem(String categoryOfItem) throws InvalidBookingDetailException {
        // Check if the provided categoryOfItem is null
        if (categoryOfItem == null) {
            throw new InvalidBookingDetailException(BookingErrors.INVALID_OBJECT);
        }
        
        // Loop through the defined CategoryOfItem values and compare with the provided categoryOfItem
        for (CategoryOfItem type : CategoryOfItem.values()) {
            if (type.getBookingCategory().equalsIgnoreCase(categoryOfItem)) {
                return true; // CategoryOfItem is valid
            }
        }
        
        // No valid match found in the Enum, throw an exception
        throw new InvalidBookingDetailException(BookingErrors.INVALID_OPTION);
    }
}
