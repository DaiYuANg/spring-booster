package org.kop.framework.spring.conf;

import org.daiyuang.libs.thready.async.AsyncWorker;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableConfigurationProperties(AsyncWorkerConfiguration.class)
public class AsyncWorkerAutoConfiguration {
    @Bean
    protected AsyncWorker asyncWorker() {
        return AsyncWorker.builder().build();
    }
}
