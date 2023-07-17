package org.toolkit4J.framework.spring.starter.event.spring.base;

public abstract class ComparableEvent<T> extends AbstractEvent<T> implements Comparable<T> {
	public ComparableEvent(Object source, T data) {
		super(source, data);
	}
}
