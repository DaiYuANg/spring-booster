package org.kop.framework.spring.starter.dev.service.config.containers;

import com.mysql.cj.jdbc.Driver;
import jakarta.annotation.Resource;
import org.kop.framework.spring.starter.dev.service.docker.DockerConnector;
import org.kop.framework.spring.starter.dev.service.services.MysqlDevService;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;

@Configuration
@ConditionalOnClass(Driver.class)
@EnableConfigurationProperties
public class MysqlDevServiceAutoConfiguration {
    @Resource
    private DockerConnector dockerConnector;

    private static final String defaultMysqlImage = "mysql:latest";

    @Bean
    public MysqlDevService mysqlDevService() {
        dockerConnector.pull(defaultMysqlImage);
        return new MysqlDevService();
    }
}
