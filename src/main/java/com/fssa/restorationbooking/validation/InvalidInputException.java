package com.fssa.restorationbooking.validation;

public class InvalidInputException  extends  Exception{
    
	private static final long serialVersionUID = -9102962645369217192L;

	public InvalidInputException(String msg) {
        super(msg);
    }
}