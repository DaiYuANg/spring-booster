package org.toolkit.spring.boot.vertx.event.bus.register;

import io.vertx.core.eventbus.EventBus;
import io.vertx.core.eventbus.MessageConsumer;
import jakarta.annotation.PostConstruct;
import jakarta.annotation.Resource;
import java.util.Optional;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class EventBusManager {

	@Resource
	private EventBus eventBus;

	@Resource
	private ApplicationContext context;

	private final ConcurrentMap<String, MessageConsumer<?>> messageConsumers = new ConcurrentHashMap<>();

	@PostConstruct
	private void init() {}

	public void removeHandler(String address) {
		Optional.ofNullable(messageConsumers.get(address)).ifPresent(MessageConsumer::unregister);
	}

	public Set<String> getAllEventBusAddress() {
		return messageConsumers.keySet();
	}
}
