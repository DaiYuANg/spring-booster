package org.kop.framework.spring.conf;

import org.daiyuang.libs.thready.async.AsyncWorker;
import org.daiyuang.libs.thready.pool.PoolCreator;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;

import java.util.concurrent.ThreadPoolExecutor;

@Configuration
@EnableConfigurationProperties(AsyncWorkerConfiguration.class)
public class AsyncWorkerAutoConfiguration {
    @Bean
    protected AsyncWorker asyncWorker() {
        return AsyncWorker.builder().executor(threadPoolExecutor()).build();
    }

    @Bean
    @Order(0)
    protected ThreadPoolExecutor threadPoolExecutor() {
        return new PoolCreator().creator();
    }
}
