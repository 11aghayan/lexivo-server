package com.lexivo.lexivo.util;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public abstract class ResponseUtil {
	public static <T> ResponseEntity<T> responseServerError(Exception e) {
		logError(e.getMessage());
		return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	}

	public static <T> ResponseEntity<T> responseOk() {
		return new ResponseEntity<>(HttpStatus.OK);
	}

	public static <T> ResponseEntity<T> responseCreated() {
		return new ResponseEntity<>(HttpStatus.CREATED);
	}

	public static ResponseEntity<String> responseDuplicateUsername() {
		String message = "Username already exists";
		logError(message);
		return new ResponseEntity<>(message, HttpStatus.BAD_REQUEST);
	}

	public static ResponseEntity<String> responseDictionaryNotFound(String id) {
		String message = "Dictionary with ID '" + id + "' not found";
		logError(message);
		return new ResponseEntity<>(message, HttpStatus.NOT_FOUND);
	}

	public static ResponseEntity<String> responseUserNotFound(String message) {
		logError(message);
		return new ResponseEntity<>(message, HttpStatus.BAD_REQUEST);
	}

	private static void logError(String msg) {
		System.err.println(msg);
	}
}
