package com.qsp.soringbootemployee.exception;

public class EmailNotPresent extends RuntimeException {
	
	String message;

	public EmailNotPresent(String message) {
		super();
		this.message = message;
	}
	
	@Override
	public String getMessage() {
		return message;
	}
}
