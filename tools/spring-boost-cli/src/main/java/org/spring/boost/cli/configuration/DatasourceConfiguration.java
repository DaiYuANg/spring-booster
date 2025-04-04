/* (C)2023*/
package org.spring.boost.cli.configuration;

import jakarta.annotation.Resource;

import javax.sql.DataSource;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration(proxyBeanMethods = false)
@EnableConfigurationProperties(DatasourceConfigurationProperties.class)
@Slf4j
public class DatasourceConfiguration {

  @Resource
  private DatasourceConfigurationProperties datasourceConfigurationProperties;

  @Bean
  @ConditionalOnProperty(name = "spring.boost.datasource.url")
  public DataSource getDataSource() {
    log.atTrace().log("Datasource Config:{}", datasourceConfigurationProperties);
    DataSourceBuilder<?> dataSourceBuilder = DataSourceBuilder.create();
    dataSourceBuilder.driverClassName(datasourceConfigurationProperties.getDriverClassName());
    dataSourceBuilder.url(datasourceConfigurationProperties.getUrl());
    dataSourceBuilder.username(datasourceConfigurationProperties.getUsername());
    dataSourceBuilder.password(datasourceConfigurationProperties.getPassword());
    return dataSourceBuilder.build();
  }
}
