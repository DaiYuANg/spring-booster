package org.toolkit.spring.boot.starter.monitor.configurations;

import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.AbstractEnvironment;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.toolkit.spring.boot.starter.monitor.bootstrap.StartAnalyser;
import org.toolkit.spring.boot.starter.monitor.bootstrap.Startup;
import org.toolkit.spring.boot.starter.monitor.docker.DockerConnector;

@EnableConfigurationProperties(MonitorProperties.class)
@Slf4j
@Configuration
public class MonitorAutoConfiguration implements WebMvcConfigurer {
	@Resource
	private AbstractEnvironment environment;

	@Resource
	private DataSourceProperties dataSourceProperties;

	@Bean
	public DockerConnector dockerConnector() {
		/*
		 * StreamSupport.stream(environment.getPropertySources().spliterator(), false)
		 * .filter(ps -> ps instanceof EnumerablePropertySource) .map(ps ->
		 * ((EnumerablePropertySource<?>) ps).getPropertyNames())
		 * .flatMap(Arrays::stream) .distinct().forEach(r->{ log.info(r); //
		 * System.err.println(r); });
		 */
		// .filter(prop -> !(prop.contains("credentials") || prop.contains("password")))
		// .forEach(prop -> log.info("{}: {}", prop, environment.getProperty(prop)));
		return new DockerConnector();
	}

	@Bean
	public Startup startup() {
		return new Startup();
	}

	@Bean
	@ConditionalOnMissingBean
	public StartAnalyser beanAnalyser() {
		return new StartAnalyser();
	}
}
