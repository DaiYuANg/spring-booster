package org.toolkit.spring.boot.starter.vertx.base;

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
