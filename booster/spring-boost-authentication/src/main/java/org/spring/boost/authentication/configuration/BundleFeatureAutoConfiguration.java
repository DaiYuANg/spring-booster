/* (C)2023*/
package org.spring.boost.authentication.configuration;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.jetbrains.annotations.NotNull;
import org.spring.boost.authentication.feature.bundle.AnnotationFilterSecurityFeatureInstaller;
import org.spring.boost.authentication.feature.bundle.AnnotationPermitSecurityFeatureInstaller;
import org.spring.boost.authentication.feature.bundle.CORSConfigureSecurityFeatureInstaller;
import org.spring.boost.authentication.feature.bundle.ConfigurationPermitSecurityFeatureInstaller;
import org.spring.boost.authentication.properties.AuthenticationConfigurationProperties;
import org.spring.boost.authentication.properties.CORSConfigurationProperties;
import org.spring.boost.core.api.BeanRegistry;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.context.properties.ConfigurationProperties;
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
}
