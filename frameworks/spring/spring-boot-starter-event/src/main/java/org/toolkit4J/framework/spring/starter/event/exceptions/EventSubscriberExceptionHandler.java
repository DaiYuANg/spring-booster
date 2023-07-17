package org.toolkit4J.framework.spring.starter.event.exceptions;

import com.google.common.eventbus.SubscriberExceptionContext;
import com.google.common.eventbus.SubscriberExceptionHandler;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.jetbrains.annotations.NotNull;

@Slf4j
public class EventSubscriberExceptionHandler implements SubscriberExceptionHandler {
    @SneakyThrows
    @Override
    public void handleException(@NotNull Throwable exception, @NotNull SubscriberExceptionContext context) {
        log.error(exception.fillInStackTrace().getLocalizedMessage());
        throw EventException.builder()
                .event(context.getEvent())
                .Subscriber(context.getSubscriber())
                .throwable(exception.getCause())
                .eventBus(context.getEventBus())
                .build();
    }
}
