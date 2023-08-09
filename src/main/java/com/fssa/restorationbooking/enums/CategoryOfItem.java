<<<<<<< HEAD

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

=======

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

    // Example usage of the enum in the main method
    public static void main(String[] args) {
        CategoryOfItem x1 = CategoryOfItem.RADIO;
        System.out.println(x1); // Output: RADIO
    }
>>>>>>> 16945bd60c50791654cfe1cb6a7b8b3e99b29cc2
}