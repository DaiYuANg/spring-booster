package org.toolkit.spring.boot.minio.core.exception;

public class ObjectNotExistsException extends RuntimeException {
	public String object;

	public String bucket;

	public ObjectNotExistsException(String object, String bucket) {
		this.object = object;
		this.bucket = bucket;
	}

	@Override
	public String getMessage() {
		return super.getMessage();
	}
}
