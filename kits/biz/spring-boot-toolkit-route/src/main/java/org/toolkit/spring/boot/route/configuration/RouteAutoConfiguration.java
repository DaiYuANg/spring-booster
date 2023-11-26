package org.toolkit.spring.boot.route.configuration;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.boot.autoconfigure.AutoConfigureBefore;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.boot.autoconfigure.web.servlet.DispatcherServletAutoConfiguration;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@AutoConfiguration
@Slf4j
@EnableConfigurationProperties(RouteConfigurationProperties.class)
@EnableJpaRepositories("org.toolkit.spring.boot.route.repository")
@EntityScan("org.toolkit.spring.boot.route.entity")
@ComponentScan("org.toolkit.spring.boot.route.**.*")
@AutoConfigureBefore({SecurityAutoConfiguration.class})
public class RouteAutoConfiguration {
}
