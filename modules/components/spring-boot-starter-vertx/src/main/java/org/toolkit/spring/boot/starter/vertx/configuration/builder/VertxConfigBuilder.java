package org.toolkit.spring.boot.starter.vertx.configuration.builder;

import io.vertx.core.VertxOptions;
import io.vertx.core.dns.AddressResolverOptions;
import io.vertx.core.eventbus.EventBusOptions;
import io.vertx.core.file.FileSystemOptions;
import io.vertx.core.metrics.MetricsOptions;
import io.vertx.core.tracing.TracingOptions;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.toolkit.spring.boot.starter.vertx.configuration.properties.VertxConfigurationProperties;

import java.util.Optional;

@AutoConfiguration
@Slf4j
public class VertxConfigBuilder {

    @Resource
    private VertxConfigurationProperties vertxConfigurationProperties;

    @Resource
    private Optional<EventBusOptions> eventBusOptions;

    @Resource
    private Optional<FileSystemOptions> fileSystemOptions;

    @Resource
    private Optional<MetricsOptions> metricsOptions;

    @Resource
    private Optional<TracingOptions> tracingOptions;

    @Resource
    private Optional<AddressResolverOptions> addressResolverOptions;

    @Bean
    public VertxOptions vertxOptions() {
        val option = new VertxOptions();
        Optional.ofNullable(vertxConfigurationProperties.getWorkerPoolSize()).ifPresent(option::setWorkerPoolSize);
        Optional.ofNullable(vertxConfigurationProperties.getEventLoopPoolSize()).ifPresent(option::setEventLoopPoolSize);
        Optional.ofNullable(vertxConfigurationProperties.getQuorumSize()).ifPresent(option::setQuorumSize);
        Optional.ofNullable(vertxConfigurationProperties.getInternalBlockingPoolSize()).ifPresent(option::setInternalBlockingPoolSize);
        eventBusOptions.ifPresent(option::setEventBusOptions);
        fileSystemOptions.ifPresent(option::setFileSystemOptions);
        metricsOptions.ifPresent(option::setMetricsOptions);
        tracingOptions.ifPresent(option::setTracingOptions);
        addressResolverOptions.ifPresent(option::setAddressResolverOptions);
        return option;
    }


}
