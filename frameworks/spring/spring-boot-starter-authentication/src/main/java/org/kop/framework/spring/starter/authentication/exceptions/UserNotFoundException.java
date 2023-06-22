package org.kop.framework.spring.starter.authentication.exceptions;

public class UserNotFoundException extends RuntimeException {
    public UserNotFoundException(String identity) {
        super(identity);
    }
}
