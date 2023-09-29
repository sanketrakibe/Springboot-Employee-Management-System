package com.qsp.soringbootemployee.exception;

public class NoData extends RuntimeException {
	
	String message;

	public NoData(String message) {
		super();
		this.message = message;
	}
	
	@Override
	public String getMessage() {
		
		return message;
	}
}
