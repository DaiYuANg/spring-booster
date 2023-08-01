package org.toolkit.spring.boot.authentication.exceptions;

public class UserNotFoundException extends RuntimeException {
	public UserNotFoundException(String identity) {
		super(identity);
	}
}
