/* (C)2023*/
package org.spring.boost.authentication.configuration;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.jetbrains.annotations.NotNull;
import org.spring.boost.authentication.feature.bundle.*;
import org.spring.boost.authentication.properties.AuthenticationConfigurationProperties;
import org.spring.boost.authentication.properties.CORSConfigurationProperties;
import org.spring.boost.authentication.properties.CSRFConfigurationProperties;
import org.spring.boost.core.api.BeanRegistry;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;

@AutoConfiguration
@Slf4j
@RequiredArgsConstructor
@EnableConfigurationProperties({CORSConfigurationProperties.class, CSRFConfigurationProperties.class})
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

  @ConditionalOnClass(name = "org.springdoc.core.properties.SwaggerUiConfigProperties")
  @Bean
  SwaggerUISupportFeatureInstaller swaggerUISupportFeatureInstaller(
    BeanRegistry beanRegistry
  ) {
    return new SwaggerUISupportFeatureInstaller(beanRegistry);
  }

  @Bean
  CSRFConfigureSecurityFeatureInstaller csrfConfigureSecurityFeatureInstaller(CSRFConfigurationProperties csrfConfigurationProperties) {
    return new CSRFConfigureSecurityFeatureInstaller(csrfConfigurationProperties);
  }
}
