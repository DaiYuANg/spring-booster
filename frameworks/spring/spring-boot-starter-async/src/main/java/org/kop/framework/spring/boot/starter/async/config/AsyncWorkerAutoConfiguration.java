package org.kop.framework.spring.boot.starter.async.config;

import com.google.common.util.concurrent.ThreadFactoryBuilder;
import jakarta.annotation.PostConstruct;
import jakarta.annotation.Resource;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.jetbrains.annotations.NotNull;
import org.kop.framework.spring.boot.starter.async.base.AsyncWorker;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.scheduling.annotation.EnableAsync;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.Executor;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadPoolExecutor;

@Configuration
@ConditionalOnClass(AsyncWorker.class)
@AutoConfigureOrder(Ordered.LOWEST_PRECEDENCE)
@EnableConfigurationProperties(AsyncWorkerProperties.class)
@Slf4j
@EnableAsync
public class AsyncWorkerAutoConfiguration {
    @Resource
    private AsyncWorkerProperties asyncWorkerProperties;

    @PostConstruct
    public void init() {
        log.info("async worker auto configuration");
    }

    @SneakyThrows
    public @NotNull RejectedExecutionHandler rejectedExecutionHandler() {
        return asyncWorkerProperties
                .getRejectedExecution()
                .getDeclaredConstructor()
                .newInstance();
    }

    @Bean
    @ConditionalOnMissingBean
    public Executor executor() {
        return new ThreadPoolExecutor(
                asyncWorkerProperties.getCoreWorker(),
                asyncWorkerProperties.getQueueCapacity(),
                asyncWorkerProperties.getAliveTime(),
                asyncWorkerProperties.getAliveTimeUnit(),
                new ArrayBlockingQueue<>(asyncWorkerProperties.getQueueCapacity()),
                new ThreadFactoryBuilder()
                        .setNameFormat(asyncWorkerProperties.getPoolNamePrefix() + "-%d")
                        .build(),
                rejectedExecutionHandler()
        );
    }

    @Bean
    @ConditionalOnMissingBean
    public AsyncWorker asyncWorker() {
        val asyncWorker = new AsyncWorker();
        asyncWorker.setExecutor((ThreadPoolExecutor) executor());
        if (asyncWorkerProperties.isPreheat()) asyncWorker.warm();
        log.info("configure async worker successful");
        return asyncWorker;
    }
}
