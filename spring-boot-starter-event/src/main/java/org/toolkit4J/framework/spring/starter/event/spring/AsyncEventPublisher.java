package org.toolkit4J.framework.spring.starter.event.spring;

import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.core.task.TaskExecutor;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class AsyncEventPublisher {

	@Resource
	private ApplicationEventPublisher applicationEventPublisher;

	@Resource
	private TaskExecutor taskExecutor;

	public <E extends ApplicationEvent> void asyncPublish(E event) {
		taskExecutor.execute(() -> applicationEventPublisher.publishEvent(event));
	}
}
