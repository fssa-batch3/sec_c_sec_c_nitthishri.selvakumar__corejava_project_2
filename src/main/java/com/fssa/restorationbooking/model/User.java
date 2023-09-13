package com.fssa.restorationbooking.model;


public class User {

	private int userId;
	private String firstName;
	private String lastName;
	private String email;
	private String password;
	private boolean isActive;

	// No argument constructor
	public User() {
		// Empty constructor used for creating an instance without setting attributes
	}

	public User(String firstName, String lastName, long phoneNumber, String email, String password,
			String confirmPassword) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.password = password;
		
	}

	
	public User(int customerId, String firstName, String lastName, long phoneNumber, String email, String password,
			String confirmPassword, boolean isActive) {
		this.userId = customerId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.password = password;
		this.isActive = isActive;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}


	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}



	public int getCustomerId() {
		return userId;
	}

	public void setCustomerId(int customerId) {
		this.userId = customerId;
	}

	public boolean isActive() {
		return isActive;
	}

	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}

	@Override
	public String toString() {
		return "User [userId=" + userId + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email
				+ ", password=" + password + ", isActive=" + isActive + "]";
	}

	

}