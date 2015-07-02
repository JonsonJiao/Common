package com.test.grads;

public class GradsException extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = 6895636866012116687L;

	public GradsException(Exception inner, String message) {
		super(message);
	}

	public GradsException(Exception inner) {
		super(inner.getMessage());
	}

	public GradsException(String message) {
		super(message);
	}
}
