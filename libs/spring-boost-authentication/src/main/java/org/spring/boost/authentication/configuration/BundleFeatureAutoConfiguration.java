/* (C)2023*/
package org.spring.boost.authentication.configuration;

import com.fasterxml.jackson.databind.ObjectMapper;
import de.codecentric.boot.admin.server.config.AdminServerProperties;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.jetbrains.annotations.NotNull;
import org.spring.boost.authentication.feature.bundle.*;
import org.spring.boost.authentication.properties.AuthenticationConfigurationProperties;
import org.spring.boost.authentication.properties.CORSConfigurationProperties;
import org.spring.boost.core.api.BeanRegistry;
import org.springdoc.core.properties.SwaggerUiConfigProperties;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;

@AutoConfiguration
@Slf4j
@RequiredArgsConstructor
@EnableConfigurationProperties(CORSConfigurationProperties.class)
public class BundleFeatureAutoConfiguration {
  private final BeanRegistry beanRegistry;

  @Bean
  AnnotationFilterSecurityFeatureInstaller annotationFilterInstaller() {
    return new AnnotationFilterSecurityFeatureInstaller(beanRegistry);
  }

  @Bean
  AnnotationPermitSecurityFeatureInstaller annotationPermitInstaller() {
    return new AnnotationPermitSecurityFeatureInstaller(beanRegistry);
  }

  @Bean
  ConfigurationPermitSecurityFeatureInstaller configurationPermitInstaller(
    @NotNull AuthenticationConfigurationProperties configurationProperties) {
    return new ConfigurationPermitSecurityFeatureInstaller(configurationProperties.getPermit());
  }

  @Bean
  CORSConfigureSecurityFeatureInstaller corsConfigureInstaller(CORSConfigurationProperties configurationProperties) {
    return new CORSConfigureSecurityFeatureInstaller(configurationProperties);
  }

  @ConditionalOnBean(AdminServerProperties.class)
  @Bean
  SpringBootAdminSupportFeatureInstaller springBootAdminSupportFeatureInstaller(AdminServerProperties adminServerProperties) {
    log.atInfo().log("Detect Spring boot admin exists, add Spring boot admin security support");
    return new SpringBootAdminSupportFeatureInstaller(adminServerProperties);
  }

  @ConditionalOnClass(SwaggerUiConfigProperties.class)
  @Bean
  SwaggerUISupportFeatureInstaller swaggerUISupportFeatureInstaller(
    SwaggerUiConfigProperties swaggerUiConfigProperties, ObjectMapper objectMapper) {
    return new SwaggerUISupportFeatureInstaller(swaggerUiConfigProperties, objectMapper);
  }
}
