package org.toolkit.cli.configuration;

import jakarta.annotation.Resource;
import java.sql.Connection;
import javax.sql.DataSource;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
@Slf4j
public class ConnectionConfiguration {

	@Resource
	private DataSource dataSource;

	@SneakyThrows
	@Bean
	@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
	public Connection connection() {
		return dataSource.getConnection();
	}
}
