package com.ty.presentationapp.exception;

public class PresentationNotFoundException extends RuntimeException {

	private String message;

	public PresentationNotFoundException() {
	}

	public PresentationNotFoundException(String message) {
		this.message = message;
	}

	@Override
	public String getMessage() {
		return message;
	}

}
