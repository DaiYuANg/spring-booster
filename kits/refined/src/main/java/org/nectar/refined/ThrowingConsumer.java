/* (C)2023*/
package org.nectar.refined;

@FunctionalInterface
public interface ThrowingConsumer<T, E extends Exception> {
	void accept(T t) throws E;
}
