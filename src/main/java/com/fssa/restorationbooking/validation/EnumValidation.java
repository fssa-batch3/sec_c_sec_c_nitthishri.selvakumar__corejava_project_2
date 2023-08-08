package com.fssa.restorationbooking.validation;

import com.fssa.restorationbooking.enums.CategoryOfItem;
import com.fssa.restorationbooking.model.BookingErrors;

public class EnumValidation {

    public static boolean isValidCategoryOfItem(String categoryOfItem) throws InvalidBookingDetailException {
        if (categoryOfItem == null) {
            throw new InvalidBookingDetailException(BookingErrors.INVALID_OBJECT);
        }
        
        for (CategoryOfItem type : CategoryOfItem.values()) {
            if (type.getBookingCategory().equalsIgnoreCase(categoryOfItem)) {
                return true;
            }
        }
        
        throw new InvalidBookingDetailException(BookingErrors.INVALID_OPTION);
    }
}