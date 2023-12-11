package org.toolkit.spring.boot.vertx.clustering.configuration;

import io.vertx.core.spi.cluster.ClusterManager;
import io.vertx.spi.cluster.hazelcast.HazelcastClusterManager;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;

@AutoConfiguration
@EnableConfigurationProperties(ClusteringConfigurationProperties.class)
@Slf4j
@ConditionalOnProperty(name = "toolkit.vertx.cluster", havingValue = "true")
public class ClusteringAutoConfiguration {

	@Bean
	@ConditionalOnClass(HazelcastClusterManager.class)
	public ClusterManager clusterManager() {
		return new HazelcastClusterManager();
	}
}
