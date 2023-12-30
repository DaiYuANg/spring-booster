/* (C)2023*/
package org.toolkit.spring.boot.vertx.configuration.properties;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.boot.context.properties.ConfigurationProperties;

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
