package org.toolkit4j.framework.spring.starter.event.spring.base;

import org.jetbrains.annotations.NotNull;

public class CompareTimingEvent extends ComparableEvent<Object> {
    public CompareTimingEvent(Object source, Object data) {
        super(source, data);
    }

    @Override
    public int compareTo(@NotNull Object o) {
        return Math.toIntExact(this.getTimestamp());
    }
}
