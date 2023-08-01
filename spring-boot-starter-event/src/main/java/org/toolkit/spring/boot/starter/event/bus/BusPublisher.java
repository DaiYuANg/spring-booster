package org.toolkit.spring.boot.starter.event.bus;

import com.github.benmanes.caffeine.cache.Cache;
import com.google.common.eventbus.AsyncEventBus;
import com.google.common.eventbus.EventBus;
import jakarta.annotation.PostConstruct;
import jakarta.annotation.Resource;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.stream.Collectors;
import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.jetbrains.annotations.NotNull;
import org.springframework.context.ApplicationContext;
import org.springframework.core.task.TaskExecutor;
import org.springframework.stereotype.Component;
import org.toolkit.spring.boot.starter.event.configurations.EventConfigurationProperties;
import org.toolkit.spring.boot.starter.event.constant.Default;

@Component
@Slf4j
public class BusPublisher {
	@Resource
	private Cache<Long, Object> cache;

	private final ConcurrentMap<String, EventBus> eventBuses = new ConcurrentHashMap<>();

	@Resource
	private ApplicationContext context;

	@Resource
	private TaskExecutor taskExecutor;

	@Resource
	private EventConfigurationProperties eventConfigurationProperties;

	@PostConstruct
	public void init() {
		log.info("Event bus initializing");
		val subscribers = context.getBeansWithAnnotation(EventBusSubscriber.class).values().stream()
				.toList();
		registerEventBuses(subscribers);
		registerSubscribers(subscribers);
		log.info("Event bus initialized");
		log.info("Event Buses identifiers:{}", eventBuses.values());
	}

	private void registerEventBuses(@NotNull List<Object> subscribers) {
		eventBuses.putAll(subscribers.stream()
				.map(subscriber -> {
					val ann = subscriber.getClass().getAnnotation(EventBusSubscriber.class);
					return eventConfigurationProperties.isAsyncEventBus()
							? new AsyncEventBus(ann.bus(), taskExecutor)
							: new EventBus(ann.bus());
				})
				.collect(Collectors.toConcurrentMap(EventBus::identifier, eventBus -> eventBus)));
	}

	private void registerSubscribers(@NotNull List<Object> subscribers) {
		subscribers.forEach(subscriber -> {
			val ann = subscriber.getClass().getAnnotation(EventBusSubscriber.class);
			eventBuses.get(ann.bus()).register(subscriber);
		});
	}

	public void publish(Object event) {
		eventBuses.get(Default.DEFAULT_EVENTBUS.getValue()).post(event);
	}

	public void publish(String bus, Object event) {
		eventBuses.get(bus).post(event);
	}
}
