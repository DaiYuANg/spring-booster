/* (C)2023*/
package org.toolkit.spring.boot.minio.event;

import lombok.Getter;
import lombok.ToString;
import org.toolkit.spring.boot.utils.struct.LoggingEvent;

@ToString
@Getter
public class ObjectAccessEvent extends LoggingEvent {
	private final String path;

	public ObjectAccessEvent(Object source, String path) {
		super(source);
		this.path = path;
	}
}
