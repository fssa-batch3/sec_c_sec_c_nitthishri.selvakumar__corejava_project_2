package com.fssa.restorationbooking.model;

import java.time.LocalDate;
import java.time.LocalTime;

public class PickupRequest {

	public int BookId;
	private String PickupName;
	private long PickupPhoneNumber;
	private String PickupAddress;
	private String PickupLandMark;
	private int PickupPincode;
	private LocalDate PickupDate;
	private LocalTime PickupTime;
	private String Email;
	private int PickupId;

	public PickupRequest(String PickupName, long PickupPhoneNumber, String PickupAddress, String PickupLandMark,
			int PickupPincode, LocalDate PickupDate, LocalTime PickupTime, String Email,int BookId) {

		this.PickupName = PickupName;
		this.PickupPhoneNumber = PickupPhoneNumber;
		this.PickupAddress = PickupAddress;
		this.PickupLandMark = PickupLandMark;
		this.PickupPincode = PickupPincode;
		this.PickupDate = PickupDate;
		this.PickupTime = PickupTime;
		this.Email = Email;
		this.BookId = BookId;

	} 


	public PickupRequest(String PickupName, long PickupPhoneNumber, String PickupAddress, String PickupLandMark,
			int PickupPincode, LocalDate PickupDate, LocalTime PickupTime,int BookId) {

		this.PickupName = PickupName;
		this.PickupPhoneNumber = PickupPhoneNumber;
		this.PickupAddress = PickupAddress;
		this.PickupLandMark = PickupLandMark;
		this.PickupPincode = PickupPincode;
		this.PickupDate = PickupDate;
		this.PickupTime = PickupTime;
		this.BookId = BookId;
	

	}


	public PickupRequest() {
		// TODO Auto-generated constructor stub
		super();
	}

	public String getEmail() {
		return Email;
	}

	public void setEmail(String email) {
		Email = email;
	}

	public int getBookId() {
		return BookId;
	}

	public String getPickupName() {
		return PickupName; 
	}

	public long getPickupPhoneNumber() {
		return PickupPhoneNumber;
	}

	public String getPickupAddress() {
		return PickupAddress;
	}

	public String getPickupLandMark() {
		return PickupLandMark;
	}

	public int getPickupPincode() {
		return PickupPincode;
	}

	public LocalDate getPickupDate() {
		return PickupDate;
	}

	public LocalTime getPickupTime() {
		return PickupTime;
	}

	public int getPickupId() {
		return PickupId;
	}

	public void setBookId(int bookId) {
		BookId = bookId;
	}

	public void setPickupName(String pickupName) {
		PickupName = pickupName;
	}

	public void setPickupPhoneNumber(long pickupPhoneNumber) {
		PickupPhoneNumber = pickupPhoneNumber;
	}

	public void setPickupAddress(String pickupAddress) {
		PickupAddress = pickupAddress;
	}

	public void setPickupLandMark(String pickupLandMark) {
		PickupLandMark = pickupLandMark;
	}

	public void setPickupPincode(int pickupPincode) {
		PickupPincode = pickupPincode;
	}

	public void setPickupDate(LocalDate pickupDate) {
		PickupDate = pickupDate;
	}

	public void setPickupTime(LocalTime pickupTime) {
		PickupTime = pickupTime;
	}

	public void setPickupId(int pickupId) {
		PickupId = pickupId;
	}

}
