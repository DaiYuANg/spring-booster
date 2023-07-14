package org.toolkit4j.framework.spring.starter.event.spring.base;

public class MethodExecutedEvent extends AbstractEvent<Object> {
	public MethodExecutedEvent(Object source, Object data) {
		super(source, data);
	}
}
