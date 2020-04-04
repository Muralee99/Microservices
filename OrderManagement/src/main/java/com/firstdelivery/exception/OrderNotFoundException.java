package com.firstdelivery.exception;

public class OrderNotFoundException extends RuntimeException{

	private static final long serialVersionUID = 2176467627845093463L;
	
	public OrderNotFoundException() {
		super();
	}
	
	public OrderNotFoundException(String message, int errorCode) {
	
	}
	
}
