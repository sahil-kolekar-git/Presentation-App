package com.ty.presentationapp.exception;

public class RatingNotFoundException extends RuntimeException {

	private String message;

	public RatingNotFoundException() {
	}

	public RatingNotFoundException(String message) {
		this.message = message;
	}

	@Override
	public String getMessage() {
		return message;
	}

}
