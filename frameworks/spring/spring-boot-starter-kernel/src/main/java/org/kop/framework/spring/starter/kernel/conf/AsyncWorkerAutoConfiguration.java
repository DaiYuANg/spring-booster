package org.kop.framework.spring.starter.kernel.conf;

import jakarta.annotation.Resource;
import org.kop.libs.thready.async.AsyncWorker;
import org.kop.libs.thready.pool.PoolCreator;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;

import java.util.concurrent.ThreadPoolExecutor;

@Configuration
@EnableConfigurationProperties(AsyncWorkerConfiguration.class)
public class AsyncWorkerAutoConfiguration {
    @Resource
    private AsyncWorkerConfiguration asyncWorkerConfiguration;

    @Bean
    protected AsyncWorker asyncWorker() {
//        return AsyncWorker.builder()
//                .executor(threadPoolExecutor())
//                .build();
        return null;
    }

    @Bean
    @Order(0)
    protected ThreadPoolExecutor threadPoolExecutor() {
        return new PoolCreator().creator();
    }
}
