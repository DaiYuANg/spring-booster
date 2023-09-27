package org.toolkit.spring.boot.starter.minio.events;

import lombok.Getter;
import lombok.ToString;
import org.springframework.context.ApplicationEvent;

@Getter
@ToString
public class FileUploadedEvent extends ApplicationEvent {
	public FileUploadedEvent(Object source) {
		super(source);
	}
}
