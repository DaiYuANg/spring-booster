package org.toolkit.spring.boot.minio.core.exception;

import lombok.Getter;

@Getter
public class ObjectNotExistsException extends RuntimeException {
	private final String object;

	public ObjectNotExistsException(String object) {
		this.object = object;
	}
}
