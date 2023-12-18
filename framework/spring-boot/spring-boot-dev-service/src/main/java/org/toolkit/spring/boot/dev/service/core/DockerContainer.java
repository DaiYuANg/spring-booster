/* (C)2023*/
package org.toolkit.spring.boot.dev.service.core;

import com.github.dockerjava.api.DockerClient;
import com.github.dockerjava.core.DefaultDockerClientConfig;
import com.github.dockerjava.core.DockerClientImpl;
import com.github.dockerjava.httpclient5.ApacheDockerHttpClient;
import java.time.Duration;
import lombok.Getter;
import lombok.val;

@Getter
public enum DockerContainer {
	INSTANCE;

	private final DockerClient client;

	{
		val config = DefaultDockerClientConfig.createDefaultConfigBuilder().build();
		val httpClient = new ApacheDockerHttpClient.Builder()
				.dockerHost(config.getDockerHost())
				.sslConfig(config.getSSLConfig())
				.maxConnections(100)
				.connectionTimeout(Duration.ofSeconds(30))
				.responseTimeout(Duration.ofSeconds(45))
				.build();
		this.client = DockerClientImpl.getInstance(config, httpClient);
		client.pingCmd().exec();
	}
}
