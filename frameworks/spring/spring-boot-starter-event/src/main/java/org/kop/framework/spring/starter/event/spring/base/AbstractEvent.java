package org.kop.framework.spring.starter.event.spring.base;

import lombok.Getter;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationEvent;

@Getter
@ToString
@Slf4j
public abstract class AbstractEvent<T> extends ApplicationEvent {
    private static final String logTemplate = "event:{}, active at:{}, from :{}";
    private final T transferData;

    public AbstractEvent(Object source, T data) {
        super(source);
        this.transferData = data;
        log.debug(logTemplate, this.getClass().getName(), getTimestamp(), source);
    }
}
