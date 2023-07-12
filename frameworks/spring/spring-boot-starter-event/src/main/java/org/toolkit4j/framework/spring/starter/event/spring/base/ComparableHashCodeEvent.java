package org.toolkit4j.framework.spring.starter.event.spring.base;

import org.jetbrains.annotations.NotNull;

public class ComparableHashCodeEvent extends ComparableEvent<Object> {
    public ComparableHashCodeEvent(Object source, Object data) {
        super(source, data);
    }

    @Override
    public int compareTo(@NotNull Object o) {
        return o.hashCode();
    }
}
