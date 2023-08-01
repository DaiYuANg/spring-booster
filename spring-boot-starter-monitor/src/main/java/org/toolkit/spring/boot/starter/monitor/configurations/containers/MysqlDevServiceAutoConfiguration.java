package org.toolkit.spring.boot.starter.monitor.configurations.containers;

import com.mysql.cj.jdbc.Driver;
import jakarta.annotation.Resource;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.toolkit.spring.boot.starter.monitor.configurations.MonitorAutoConfiguration;
import org.toolkit.spring.boot.starter.monitor.docker.DockerConnector;
import org.toolkit.spring.boot.starter.monitor.services.MysqlDevService;

@Configuration
@ConditionalOnClass(Driver.class)
@EnableConfigurationProperties
@AutoConfigureAfter(MonitorAutoConfiguration.class)
@AutoConfigureOrder(1)
public class MysqlDevServiceAutoConfiguration {
	@Resource
	private DockerConnector dockerConnector;

	@Bean
	public MysqlDevService mysqlDevService() {
		return new MysqlDevService();
	}
}
