package org.toolkit.spring.boot.vertx.clustering.configuration;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.toolkit.spring.boot.vertx.configuration.properties.BaseConfigurationProperties;

@ConfigurationProperties(prefix = "toolkit.vertx.cluster")
@Setter
@Getter
@ToString
public class ClusteringConfigurationProperties extends BaseConfigurationProperties {}
