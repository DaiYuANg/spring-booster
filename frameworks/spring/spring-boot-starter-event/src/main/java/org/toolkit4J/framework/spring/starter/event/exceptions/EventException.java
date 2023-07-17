package org.toolkit4J.framework.spring.starter.event.exceptions;

import com.google.common.eventbus.EventBus;
import lombok.Builder;
import lombok.ToString;

import java.lang.reflect.Method;

@Builder
@ToString
public class EventException extends RuntimeException {
    private EventBus eventBus;

    private Method subMethod;

    private Object event;

    private Object Subscriber;

    private Throwable throwable;
}
