package org.toolkit4j.framework.spring.starter.event.spring.base;

import org.springframework.context.ApplicationEvent;

public class NormalEvent extends ApplicationEvent {
    public NormalEvent(Object source) {
        super(source);
    }
}