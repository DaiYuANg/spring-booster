/* (C)2024*/
package org.spring.boost.cli.service;

import org.springframework.context.annotation.Bean;
import org.testcontainers.containers.MySQLContainer;

@org.springframework.boot.test.context.TestConfiguration(proxyBeanMethods = false)
public class TestConfiguration {
    @Bean
    MySQLContainer<?> mySQLContainer() {
        return new MySQLContainer<>("mysql:latest");
    }
}
