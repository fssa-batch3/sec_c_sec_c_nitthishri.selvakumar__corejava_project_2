package com.fssa.restorationbooking.util;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import com.fssa.restorationbooking.errors.InvalidInputException;

public class PasswordHash {
	public static String hashPass(String password) throws InvalidInputException {
		 try {
				MessageDigest md = MessageDigest.getInstance("SHA-256");
				byte[] hashBytes = md.digest(password.getBytes(StandardCharsets.UTF_8));
				StringBuilder hashsb = new StringBuilder();
				for (byte b : hashBytes) {
					hashsb.append(String.format("%02x", b));
				}
				return hashsb.toString();
			} catch (NoSuchAlgorithmException e) {
				throw new InvalidInputException(e.getMessage());
			}
	       
	}
}
