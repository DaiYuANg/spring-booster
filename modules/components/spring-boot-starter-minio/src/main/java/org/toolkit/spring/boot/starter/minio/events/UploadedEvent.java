package org.toolkit.spring.boot.starter.minio.events;

import lombok.Getter;
import lombok.ToString;
import org.springframework.context.ApplicationEvent;

@Getter
@ToString
public class UploadedEvent extends ApplicationEvent {

	private final String resourceId;
	public UploadedEvent(Object source,String resourceId) {
		super(source);
		this.resourceId = resourceId;
	}
}
