/* (C)2023*/
package org.toolkit.spring.boot.vertx.web.configuration;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.toolkit.spring.boot.vertx.configuration.properties.BaseConfigurationProperties;

@ConfigurationProperties(prefix = "toolkit.vertx.http")
@Setter
@Getter
@ToString
public class HttpConfigurationProperties extends BaseConfigurationProperties {
	private boolean enable = false;
	private Integer port = 8081;
}
