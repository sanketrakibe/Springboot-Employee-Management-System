package com.qsp.soringbootemployee.exception;

public class NotPresentInGivenRange extends RuntimeException{
	
	String message;

	public NotPresentInGivenRange(String message) {
		super();
		this.message = message;
	}
	
	@Override
	public String getMessage() {
		return message;
	}
}
