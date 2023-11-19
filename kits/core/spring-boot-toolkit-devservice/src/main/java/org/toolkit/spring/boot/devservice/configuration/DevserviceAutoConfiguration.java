package org.toolkit.spring.boot.devservice.configuration;

import com.github.dockerjava.api.DockerClient;
import com.github.dockerjava.core.DefaultDockerClientConfig;
import com.github.dockerjava.core.DockerClientConfig;
import com.github.dockerjava.core.DockerClientImpl;
import com.github.dockerjava.httpclient5.ApacheDockerHttpClient;
import com.github.dockerjava.transport.DockerHttpClient;
import java.time.Duration;
import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.core.annotation.Order;

@AutoConfiguration
@Slf4j
@EnableConfigurationProperties(DevserviceConfigurationProperties.class)
@ComponentScan("org.toolkit.spring.boot.devservice.**.*")
@Order(0)
public class DevserviceAutoConfiguration {

	@Bean
	public DockerClient dockerClient() {
		DockerClientConfig config =
				DefaultDockerClientConfig.createDefaultConfigBuilder().build();
		DockerHttpClient httpClient = new ApacheDockerHttpClient.Builder()
				.dockerHost(config.getDockerHost())
				.sslConfig(config.getSSLConfig())
				.maxConnections(100)
				.connectionTimeout(Duration.ofSeconds(30))
				.responseTimeout(Duration.ofSeconds(45))
				.build();
		val client = DockerClientImpl.getInstance(config, httpClient);
		client.pingCmd().exec();
		return client;
	}
}
