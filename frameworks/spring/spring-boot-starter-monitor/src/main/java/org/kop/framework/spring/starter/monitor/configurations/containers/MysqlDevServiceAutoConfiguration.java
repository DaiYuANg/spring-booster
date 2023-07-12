package org.kop.framework.spring.starter.monitor.configurations.containers;

import com.mysql.cj.jdbc.Driver;
import jakarta.annotation.Resource;
import org.kop.framework.spring.starter.monitor.configurations.DevAdminAutoConfiguration;
import org.kop.framework.spring.starter.monitor.docker.DockerConnector;
import org.kop.framework.spring.starter.monitor.services.MysqlDevService;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConditionalOnClass(Driver.class)
@EnableConfigurationProperties
@AutoConfigureAfter(DevAdminAutoConfiguration.class)
@AutoConfigureOrder(1)
public class MysqlDevServiceAutoConfiguration {
    @Resource
    private DockerConnector dockerConnector;

    @Bean
    public MysqlDevService mysqlDevService() {
        return new MysqlDevService();
    }
}
