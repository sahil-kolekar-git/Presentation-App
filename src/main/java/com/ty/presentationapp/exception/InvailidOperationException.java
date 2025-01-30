package com.ty.presentationapp.exception;

public class InvailidOperationException extends RuntimeException {

	private String message;

	public InvailidOperationException() {
	}

	public InvailidOperationException(String msg) {
		this.message = msg;
	}

	@Override
	public String getMessage() {
		return message;
	}
}
