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
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.web.servlet.DispatcherServlet;

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
    public ServletRegistrationBean<DispatcherServlet> apiServlet(@NotNull DispatcherServlet dispatcherServlet) {
        dispatcherServlet.setThreadContextInheritable(true);
        return new ServletRegistrationBean<>(dispatcherServlet);
    }

    @Bean
    @ConditionalOnBean
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
    @DependsOn({"executor"})
    @Order(0)
    @ConditionalOnMissingBean
    public AsyncWorker asyncWorker() {
        val asyncWorker = new AsyncWorker();
        asyncWorker.setExecutor((ThreadPoolExecutor) this.executor());
        if (asyncWorkerProperties.isPreheat()) asyncWorker.warm();
        log.info("configure async worker successful");
        return asyncWorker;
    }
}
