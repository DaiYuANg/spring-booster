package org.toolkit.spring.boot.starter.event.exceptions;

import com.google.common.eventbus.EventBus;
import java.lang.reflect.Method;
import lombok.Builder;
import lombok.ToString;

@Builder
@ToString
public class EventException extends RuntimeException {
	private EventBus eventBus;

	private Method subMethod;

	private Object event;

	private Object Subscriber;

	private Throwable throwable;
}
