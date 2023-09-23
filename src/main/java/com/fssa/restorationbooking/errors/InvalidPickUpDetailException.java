package com.fssa.restorationbooking.errors;
public class InvalidPickUpDetailException extends Exception {
    private static final long serialVersionUID = -8105491977357554060L;

    // Constructors
    public InvalidPickUpDetailException(String msg) {
        super(msg);
    }

    public InvalidPickUpDetailException(Throwable te) {
        super(te);
    }

    public InvalidPickUpDetailException(String msg, Throwable te) {
        super(msg, te);
    }
}

