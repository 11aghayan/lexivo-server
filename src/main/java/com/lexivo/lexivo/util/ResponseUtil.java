package com.lexivo.lexivo.util;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public abstract class ResponseUtil {
	public static <T> ResponseEntity<T> responseServerError() {
		return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	}

	public static <T> ResponseEntity<T> responseOk() {
		return new ResponseEntity<>(HttpStatus.OK);
	}

	public static <T> ResponseEntity<T> responseCreated() {
		return new ResponseEntity<>(HttpStatus.CREATED);
	}
}
