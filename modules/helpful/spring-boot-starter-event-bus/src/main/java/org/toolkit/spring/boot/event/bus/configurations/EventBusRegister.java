package org.toolkit.spring.boot.event.bus.configurations;

import io.vertx.core.Handler;
import io.vertx.core.eventbus.EventBus;
import io.vertx.core.eventbus.Message;
import jakarta.annotation.PostConstruct;
import jakarta.annotation.Resource;
import java.util.Objects;
import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.springframework.context.ApplicationContext;
import org.toolkit.spring.boot.event.bus.annotations.Subscriber;

@Slf4j
public class EventBusRegister {

	@Resource
	private ApplicationContext context;

	@Resource
	private EventBus eventBus;

	@PostConstruct
	@SuppressWarnings("unchecked")
	public void init() {
		context.getBeansWithAnnotation(Subscriber.class).values().stream()
				.filter(obj -> obj instanceof Handler)
				.map(o -> (Handler<Message<Object>>) o)
				.forEach(messageHandler -> {
					System.err.println(messageHandler);
					val annotation = messageHandler.getClass().getAnnotation(Subscriber.class);
					if (Objects.isNull(annotation)) return;
					registerHandler(annotation.address(), messageHandler);
				});
		;
	}

	private void registerHandler(String address, Handler<Message<Object>> handler) {
		eventBus.consumer(address, handler);
	}
}
