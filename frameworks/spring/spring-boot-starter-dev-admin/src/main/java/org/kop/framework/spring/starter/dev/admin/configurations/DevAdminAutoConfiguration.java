package org.kop.framework.spring.starter.dev.admin.configurations;

import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.kop.framework.spring.starter.dev.admin.bootstrap.StartAnalyser;
import org.kop.framework.spring.starter.dev.admin.bootstrap.Startup;
import org.kop.framework.spring.starter.dev.admin.docker.DockerConnector;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.AbstractEnvironment;

@EnableConfigurationProperties(DevServiceProp.class)
@Slf4j
@Configuration
public class DevAdminAutoConfiguration {
    @Resource
    private AbstractEnvironment environment;

    @Bean
    public DockerConnector dockerConnector() {
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

    @Bean
    @ConditionalOnMissingBean
    public StartAnalyser beanAnalyser(){
        return new StartAnalyser();
    }
}
