package org.toolkit.spring.boot.minio.event;

import lombok.Getter;
import lombok.ToString;
import org.toolkit.spring.boot.minio.template.MinioTemplate;
import org.toolkit.spring.boot.utils.struct.LoggingEvent;

@Getter
@ToString
public class ObjectUploadedEvent extends LoggingEvent {

	private final String object;

	private final String md5;

	private final MinioTemplate template;

	public ObjectUploadedEvent(Object source, String object, String md5, MinioTemplate template) {
		super(source);
		this.object = object;
		this.md5 = md5;
		this.template = template;
	}
}
