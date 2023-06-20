package org.kop.framework.spring.starter.dev.service.config.containers;

import com.mysql.cj.jdbc.Driver;
import jakarta.annotation.Resource;
import org.kop.framework.spring.starter.dev.service.config.DevServiceAutoConfiguration;
import org.kop.framework.spring.starter.dev.service.docker.DockerConnector;
import org.kop.framework.spring.starter.dev.service.services.MysqlDevService;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.boot.autoconfigure.AutoConfigureBefore;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConditionalOnClass(Driver.class)
@EnableConfigurationProperties
@AutoConfigureAfter(DevServiceAutoConfiguration.class)
@AutoConfigureOrder(1)
public class MysqlDevServiceAutoConfiguration {
    @Resource
    private DockerConnector dockerConnector;

    @Bean
    public MysqlDevService mysqlDevService() {
        return new MysqlDevService();
    }
}
