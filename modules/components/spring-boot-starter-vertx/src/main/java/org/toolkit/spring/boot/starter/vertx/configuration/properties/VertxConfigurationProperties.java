package org.toolkit.spring.boot.starter.vertx.configuration.properties;

import io.vertx.core.VertxOptions;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.toolkit.spring.boot.starter.vertx.base.BaseConfigurationProperties;

@ConfigurationProperties(prefix = "toolkit.vertx")
@Setter
@Getter
@ToString
public class VertxConfigurationProperties extends BaseConfigurationProperties {
    private Integer workerPoolSize;

    private Integer quorumSize;

    private Integer eventLoopPoolSize;

    private Integer internalBlockingPoolSize;
}
