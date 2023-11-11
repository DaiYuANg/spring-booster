package org.toolkit.cli.configuration;

import jakarta.annotation.Resource;
import javax.sql.DataSource;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableConfigurationProperties(DatasourceConfigurationProperties.class)
public class DatasourceConfiguration {

	@Resource
	private DatasourceConfigurationProperties datasourceConfigurationProperties;

	@Bean
	@ConditionalOnProperty(name = "toolkit.datasource.url")
	public DataSource getDataSource() {
		DataSourceBuilder<?> dataSourceBuilder = DataSourceBuilder.create();
		dataSourceBuilder.driverClassName(datasourceConfigurationProperties.getDriverClassName());
		dataSourceBuilder.url(datasourceConfigurationProperties.getUrl());
		dataSourceBuilder.username(datasourceConfigurationProperties.getUsername());
		dataSourceBuilder.password(datasourceConfigurationProperties.getPassword());
		return dataSourceBuilder.build();
	}
}