package org.daiyuang.framework.spring.async;

import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableConfigurationProperties(AsyncWorkerConfiguration.class)
public class AsyncWorkerAutoConfiguration {
    @Bean
    AsyncWorker asyncWorker() {
        return AsyncWorker.builder().build();
    }
}
