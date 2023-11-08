package org.toolkit.spring.boot.vertx.lifecycle;

import io.vertx.core.eventbus.EventBus;
import io.vertx.core.eventbus.MessageConsumer;
import jakarta.annotation.PostConstruct;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;
import org.toolkit.spring.boot.vertx.annotations.EventConsumer;
import org.toolkit.spring.boot.starter.vertx.base.EventBusHandler;

import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.concurrent.ConcurrentMap;
import java.util.stream.Collectors;

@Component
@Slf4j
public class EventHandlerRegister {

    @Resource
    private EventBus eventBus;

    @Resource
    private ApplicationContext context;

    private ConcurrentMap<String, MessageConsumer<?>> messageConsumers;

    @PostConstruct
    public void init() {
        val consumers = context.getBeansWithAnnotation(EventConsumer.class);
        val registerHandlers = consumers.values()
                .stream()
                .map(consumer -> {
                    val ann = consumer.getClass().getAnnotation(EventConsumer.class);
                    return Map.entry(ann.address(), (EventBusHandler<?>) consumer);
                })
                .collect(Collectors.toConcurrentMap(Map.Entry::getKey, Map.Entry::getValue));
        registerHandlers.forEach((key, value) -> {
            val consumer = eventBus.consumer(key, value);
            messageConsumers.put(key, consumer);
        });
    }

    public void removeHandler(String address) {
        Optional.ofNullable(messageConsumers.get(address))
                .ifPresent(MessageConsumer::unregister);
    }

    public Set<String> getAllEventBusAddress() {
        return messageConsumers.keySet();
    }
}
