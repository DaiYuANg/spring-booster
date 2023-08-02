package org.toolkit.spring.boot.starter.event.spring;

import io.vertx.core.eventbus.EventBus;
import jakarta.annotation.PostConstruct;
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
	private EventBus eventBus;

	@PostConstruct
	public void init(){
		eventBus.publish("terst","das");
	}

	@Resource
	private ApplicationEventPublisher applicationEventPublisher;

	@Resource
	private TaskExecutor taskExecutor;

	public <E extends ApplicationEvent> void asyncPublish(E event) {
		taskExecutor.execute(() -> applicationEventPublisher.publishEvent(event));
	}
}
