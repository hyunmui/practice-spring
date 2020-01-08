package com.flexibledev.java.exception;

public class ImageUploadException extends RuntimeException {
	
	/**
	 * serialVersionId
	 * TODO: What code for?
	 */
	private static final long serialVersionUID = -401965078191008899L;

	public ImageUploadException(String message) {
		super(message);
	}
	
	public ImageUploadException(String message, Throwable cause) {
		super(message, cause);
	}
	
}
