package org.kop.framework.spring.starter.kernel.events;

public class MethodExecutedEvent extends AbstractEvent<Object> {
    public MethodExecutedEvent(Object source, Object data) {
        super(source, data);
    }
}
