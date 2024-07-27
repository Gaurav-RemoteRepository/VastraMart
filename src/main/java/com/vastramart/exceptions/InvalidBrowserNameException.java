package com.vastramart.exceptions;

import java.io.Serializable; //to avoid warning - The serializable class InvalidBrowserNameException does not declare a static final serialVersionUID field of type long

public class InvalidBrowserNameException extends RuntimeException implements Serializable{
	private static final long serialVersionUID = 1L;
	
	
	private String browserName;

	public InvalidBrowserNameException(String browserName) {
		this.browserName = browserName;
	}

	@Override
	public String getMessage() {

		return browserName;
	}

}
