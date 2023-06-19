package org.kop.framework.spring.starter.kernel.config;

import jakarta.annotation.Resource;
import lombok.val;
import org.kop.libs.thready.async.AsyncWorker;
import org.kop.libs.thready.pool.PoolCreator;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.concurrent.ThreadPoolExecutor;

@Configuration
@ConditionalOnClass(AsyncWorker.class)
@EnableConfigurationProperties(AsyncWorkerProperties.class)
@Component
public class AsyncWorkerAutoConfiguration {
    @Resource
    private AsyncWorkerProperties asyncWorkerProperties;

    @Bean
    protected AsyncWorker asyncWorker() {
        val asyncWorker = AsyncWorker.builder()
                .executor(new PoolCreator().creator())
                .build();
        asyncWorker.warm();
        return asyncWorker;
    }
}
