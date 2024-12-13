/* (C)2024*/
package org.spring.boost.cli.configuration;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.Resource;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.spring.boost.cli.factory.YamlPropertySourceFactory;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.shell.component.PathSearch;

import javax.sql.DataSource;
import java.nio.file.Path;
import java.nio.file.Paths;

@Configuration(proxyBeanMethods = false)
@Slf4j
@PropertySource(
  value = "file:spring.boost.yaml",
  factory = YamlPropertySourceFactory.class,
  encoding = "UTF-8",
  ignoreResourceNotFound = true)
@EnableConfigurationProperties(CLIConfigurationProperties.class)
public class CLIConfiguration {


  @SneakyThrows
  @Bean("workingDirectory")
  Path init() {
    return Path.of("").toAbsolutePath();
  }

  @Bean
  PathSearch.PathSearchConfig pathSearchConfig() {
    val config = new PathSearch.PathSearchConfig();
    config.setMaxPathsShow(10);
    config.setMaxPathsSearch(100);
    config.setSearchForward(true);
    config.setSearchCaseSensitive(true);
    config.setSearchNormalize(false);
    return config;
  }
}
