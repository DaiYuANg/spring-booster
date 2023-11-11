package org.toolkit.cli.configuration;

import org.toolkit.cli.factory.YamlPropertySourceFactory;
import jakarta.annotation.PostConstruct;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration(proxyBeanMethods = false)
@Slf4j
@EnableConfigurationProperties(ToolkitConfigurationProperties.class)
@PropertySource(
		value = "file:${PWD}/toolkit-cli.yaml",
		factory = YamlPropertySourceFactory.class,
		encoding = "UTF-8",
		ignoreResourceNotFound = true)
public class ToolkitConfiguration {
	@Resource
	private DatasourceConfigurationProperties datasourceConfigurationProperties;

	@Resource
	private ToolkitConfigurationProperties t;

	@PostConstruct
	public void init() {
		log.info("toolkit config ");
	}
}
