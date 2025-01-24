package com.ty.presentationapp.exception;

public class NotAdminException extends RuntimeException {

	private String message;

	public NotAdminException() {
	}

	public NotAdminException(String message) {
		super();
		this.message = message;
	}

	@Override
	public String getMessage() {
		return message;
	}
}
