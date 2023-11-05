package org.toolkit.spring.boot.starter.vertx.configuration.properties;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.toolkit.spring.boot.starter.vertx.base.BaseConfigurationProperties;

@ConfigurationProperties(prefix = "toolkit.vertx.cluster")
@Setter
@Getter
@ToString
public class ClusterConfigurationProperties extends BaseConfigurationProperties {
}
