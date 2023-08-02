package org.toolkit.spring.boot.starter.event.constant;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public enum Default {
	DEFAULT_EVENTBUS("default");

	@Getter
	private final String value;
}
