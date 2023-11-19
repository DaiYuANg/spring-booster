package org.toolkit.spring.boot.minio.core.event;

import jakarta.servlet.http.HttpServletRequest;
import lombok.Getter;
import lombok.ToString;
import org.toolkit.spring.boot.utils.struct.LoggingEvent;

@ToString
@Getter
public class ObjectAccessEvent extends LoggingEvent {
	private final String path;

	private final HttpServletRequest request;

	public ObjectAccessEvent(Object source, String path, HttpServletRequest request) {
		super(source);
		this.path = path;
		this.request = request;
	}
}
