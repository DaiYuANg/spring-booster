package org.kop.framework.spring.events;

public class MethodExecutedEvent extends AbstractEvent<Object> {
    public MethodExecutedEvent(Object source, Object data) {
        super(source, data);
    }
}
