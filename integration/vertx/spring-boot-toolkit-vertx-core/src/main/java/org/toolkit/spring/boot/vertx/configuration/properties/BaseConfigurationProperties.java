package org.toolkit.spring.boot.vertx.configuration.properties;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public abstract class BaseConfigurationProperties {

	private boolean enable;

	private int idleTimeout;
}
