/* (C)2023*/
package org.spring.boost.authentication.configuration;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.jetbrains.annotations.NotNull;
import org.spring.boost.authentication.feature.bundle.AnnotationFilterInstaller;
import org.spring.boost.authentication.feature.bundle.AnnotationPermitInstaller;
import org.spring.boost.authentication.feature.bundle.CORSConfigureInstaller;
import org.spring.boost.authentication.feature.bundle.ConfigurationPermitInstaller;
import org.spring.boost.authentication.feature.bundle.authenticated.AuthenticatedEventFilter;
import org.spring.boost.authentication.feature.bundle.authenticated.AuthenticatedEventPublisherInstaller;
import org.spring.boost.authentication.properties.AuthenticationConfigurationProperties;
import org.spring.boost.authentication.properties.CORSConfigurationProperties;
import org.spring.boost.common.api.BeanRegistry;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.annotation.Bean;

@AutoConfiguration
@Slf4j
@RequiredArgsConstructor
@EnableConfigurationProperties(CORSConfigurationProperties.class)
public class BundleFeatureAutoConfiguration {
    private final BeanRegistry beanRegistry;

    @Bean
    AnnotationFilterInstaller annotationFilterInstaller() {
        return new AnnotationFilterInstaller(beanRegistry);
    }

    @Bean
    AnnotationPermitInstaller annotationPermitInstaller() {
        return new AnnotationPermitInstaller(beanRegistry);
    }

    @Bean
    ConfigurationPermitInstaller configurationPermitInstaller(
            @NotNull AuthenticationConfigurationProperties configurationProperties
    ) {
        return new ConfigurationPermitInstaller(configurationProperties.getPermit());
    }

    @Bean
    CORSConfigureInstaller corsConfigureInstaller(
            CORSConfigurationProperties configurationProperties
    ) {
        return new CORSConfigureInstaller(configurationProperties);
    }

    @Bean
    AuthenticatedEventFilter authenticatedEventFilter(
            ApplicationEventPublisher applicationEventPublisher
    ) {
        return new AuthenticatedEventFilter(applicationEventPublisher);
    }

    @Bean
    AuthenticatedEventPublisherInstaller authenticatedEventPublisherInstaller(
            AuthenticatedEventFilter authenticatedEventFilter
    ) {
        return new AuthenticatedEventPublisherInstaller(authenticatedEventFilter);
    }
}
