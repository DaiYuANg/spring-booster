package org.toolkit.spring.boot.starter.event.spring.base;

import org.jetbrains.annotations.NotNull;

public class CompareTimingEvent<T> extends ComparableEvent<T> {
	public CompareTimingEvent(Object source, T data) {
		super(source, data);
	}

	@Override
	public int compareTo(@NotNull T o) {
		return Math.toIntExact(this.getTimestamp());
	}
}
