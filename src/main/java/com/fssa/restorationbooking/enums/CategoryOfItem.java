
package com.fssa.restorationbooking.enums;

public enum CategoryOfItem {

    // Enum constants with their corresponding booking categories
    HOME_FURNITURE("home furniture"),
    RADIO("radio"),
    CAMERA("camera"),
    VOICE_RECORDER("voice recorder"),
    VINTAGE_SWITCH("vintage switch"),
    GRAMOPHONE("gramophone"),
    WALKMAN("walkman"), 
    AMPLIFIER("amplifier"),
    CALCULATOR("calculator"),
    TELEVISION("television"),
    COMPUTER("computer"),
    TAILORING_MACHINE("tailoring machine"),
    BETTERMASS_LIGHT("bettermass light"),
    FAN("fan"),
    OTHER("other");

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

}