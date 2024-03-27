/* (C)2024*/
package org.spring.boost.cli.configuration;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.Resource;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.spring.boost.cli.factory.YamlPropertySourceFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import javax.sql.DataSource;

@Configuration(proxyBeanMethods = false)
@Slf4j
@PropertySource(
        value = "file:./spring.boost.yaml",
        factory = YamlPropertySourceFactory.class,
        encoding = "UTF-8",
        ignoreResourceNotFound = true)
public class CLIConfiguration {

    @Resource
    private DataSource dataSource;

    @SneakyThrows
    @PostConstruct
    public void init() {
        System.err.println(dataSource.getConnection());
    }
}
