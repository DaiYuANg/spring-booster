package org.kop.framework.spring.starter.dev.service.configuration;

import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.kop.framework.spring.starter.dev.service.bootstrap.Startup;
import org.kop.framework.spring.starter.dev.service.docker.DockerConnector;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.autoconfigure.AutoConfigureBefore;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.AbstractEnvironment;

@EnableConfigurationProperties(DevServiceProp.class)
@Slf4j
@Configuration
public class DevServiceAutoConfiguration {
    @Resource
    private AbstractEnvironment environment;

    @Bean
    public DockerConnector dockerConnector() {
        System.err.println(321);
       /* StreamSupport.stream(environment.getPropertySources().spliterator(), false)
                .filter(ps -> ps instanceof EnumerablePropertySource)
                .map(ps -> ((EnumerablePropertySource<?>) ps).getPropertyNames())
                .flatMap(Arrays::stream)
                .distinct().forEach(r->{
                    log.info(r);
//                    System.err.println(r);
                });*/
//                .filter(prop -> !(prop.contains("credentials") || prop.contains("password")))
//                .forEach(prop -> log.info("{}: {}", prop, environment.getProperty(prop)));
        return new DockerConnector();
    }

    @Bean
    public Startup startup() {
        return new Startup();
    }
}
