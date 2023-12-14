/* (C)2023*/
package org.nectar.refined.container;

public interface Containerizeable {
	default Exception exception() {
		return new RuntimeException();
	}

	default boolean isValid() {
		return true;
	}
}
