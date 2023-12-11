package org.toolkit.minio.exceptions;

import java.io.Serial;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class ObjectNotExistsException extends RuntimeException {
	@Serial
	private static final long serialVersionUID = 1L;

	private final String object;
}
