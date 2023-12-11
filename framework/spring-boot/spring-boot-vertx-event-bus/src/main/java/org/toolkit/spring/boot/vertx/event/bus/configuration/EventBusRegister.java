package org.toolkit.spring.boot.vertx.event.bus.configuration;

import io.vertx.core.eventbus.EventBus;
import io.vertx.core.eventbus.MessageConsumer;
import jakarta.annotation.PostConstruct;
import jakarta.annotation.Resource;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.stream.Collectors;
import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.context.ApplicationContext;
import org.toolkit.spring.boot.vertx.event.bus.annotation.EventConsumer;
import org.toolkit.spring.boot.vertx.event.bus.base.EventBusHandler;

@AutoConfiguration
@Slf4j
public class EventBusRegister {

	@Resource
	private ApplicationContext context;

	@Resource
	private EventBus eventBus;

	private final ConcurrentMap<String, MessageConsumer<?>> messageConsumers = new ConcurrentHashMap<>();

	@PostConstruct
	public void init() {
		val consumers = context.getBeansWithAnnotation(EventConsumer.class);
		val registerHandlers = consumers.values().stream()
				.map(consumer -> {
					val ann = consumer.getClass().getAnnotation(EventConsumer.class);
					return Map.entry(ann.value(), (EventBusHandler<?>) consumer);
				})
				.collect(Collectors.toConcurrentMap(Map.Entry::getKey, Map.Entry::getValue));
		registerHandlers.forEach((key, value) -> {
			val consumer = eventBus.consumer(key, value);
			messageConsumers.put(key, consumer);
		});
	}
}
