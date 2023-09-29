package com.qsp.soringbootemployee.exception;

public class PhoneNotPresent extends RuntimeException {
	
	String message;

	public PhoneNotPresent(String message) {
		super();
		this.message = message;
	}
	
	@Override
	public String getMessage() {
		return message;
	}
	
}
