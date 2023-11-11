package org.toolkit.cli.configuration;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.Resource;
import java.util.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.*;
import org.toolkit.cli.factory.YamlPropertySourceFactory;

@Configuration
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