
package com.fssa.restorationbooking.enums;

public enum CategoryOfItem {

    // Enum constants with their corresponding booking categories
    HOME_FURNITURE("HOME_FURNITURE"),
    RADIO("RADIO"),
    CAMERA("CAMERA"),
    VOICE_RECORDER("VOICE_RECORDER"),
    VINTAGE_SWITCH("VINTAG_SWITCH"),
    GRAMOPHONE("GRAMOPHONE"),
    WALKMAN("WALKMAN"), 
    AMPLIFIER("AMPLIFIER"),
    CALCULATOR("CALCULATOR"),
    TELEVISION("TELEVISION"),
    HEADPHONE("HEADPHONE"),
    TELEPHONE("TELEPHONE"),
    COMPUTER("Computer"),
    TAILORING_MACHINE("TAILORING_MACHINE"),
    BETTERMASS_LIGHT("BETTERMASS_LIGHT"),
    FAN("FAN"),
    OTHERS("OTHERS");

	
    // Property to store the booking category as a string
    private final String bookingCategory;

    // Constructor for each enum constant with the corresponding booking category as a parameter
    private CategoryOfItem(String bookingCategory) {
        this.bookingCategory = bookingCategory;
    }

    
    // Getter method to retrieve the booking category as a string
    public String getBookingCategory() {
        return bookingCategory;
    }


//	public static CategoryOfItem valueToEnumMapping(String categoryOfItems) {
//		// TODO Auto-generated method stub
//	return categoryOfItems;
//	}

}