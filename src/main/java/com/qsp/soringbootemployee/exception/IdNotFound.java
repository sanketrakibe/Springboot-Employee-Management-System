package com.qsp.soringbootemployee.exception;

public class IdNotFound extends RuntimeException {
	
	String message;

	public IdNotFound(String message) {
		super();
		this.message = message;
	}
	
	@Override
	public String getMessage() {
		return message;
	}

}
