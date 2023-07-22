package org.toolkit4j.standard.restful.exceptions;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class RestfulException extends RuntimeException {
	public RestfulException(String message) {
		super(message);
	}
}
