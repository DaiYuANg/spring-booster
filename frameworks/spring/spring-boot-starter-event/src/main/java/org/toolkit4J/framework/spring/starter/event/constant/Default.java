package org.toolkit4J.framework.spring.starter.event.constant;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public enum Default {
    DEFAULT_EVENTBUS("default");

    @Getter
    private final String value;
}
