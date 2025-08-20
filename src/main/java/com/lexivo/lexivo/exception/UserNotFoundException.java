package com.lexivo.lexivo.exception;

public class UserNotFoundException extends Exception {
	public UserNotFoundException(String userId) {
		super("User not found. ID: " + userId);
	}
}
