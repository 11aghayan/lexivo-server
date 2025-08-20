package com.lexivo.lexivo.exception;

public class DictionaryNotFoundException extends Exception {
	public DictionaryNotFoundException(String dictId) {
      super("Dictionary not found. ID: " + dictId);
	}
}
