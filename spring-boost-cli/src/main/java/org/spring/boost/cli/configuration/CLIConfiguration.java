/* (C)2024*/
package org.spring.boost.cli.configuration;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.Resource;
import javax.sql.DataSource;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.spring.boost.cli.factory.YamlPropertySourceFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@Slf4j
@PropertySource(
        value = "file:${PWD}/spring.boost.yaml",
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
