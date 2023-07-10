package org.kop.framework.spring.boot.starter.async.config;

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
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.web.servlet.DispatcherServlet;

import java.util.concurrent.RejectedExecutionHandler;

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

//    @Bean
//    @Primary
//    public ThreadPoolExecutor taskExecutor() {
//        return new ThreadPoolExecutor(
//                asyncWorkerProperties.getCoreWorker(),
//                asyncWorkerProperties.getQueueCapacity(),
//                asyncWorkerProperties.getAliveTime(),
//                asyncWorkerProperties.getAliveTimeUnit(),
//                new ArrayBlockingQueue<>(asyncWorkerProperties.getQueueCapacity()),
//                new ThreadFactoryBuilder()
//                        .setNameFormat(asyncWorkerProperties.getPoolNamePrefix() + "-%d")
//                        .build(),
//                rejectedExecutionHandler()
//        );
//    }

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
    @Order(0)
    @ConditionalOnMissingBean
    public AsyncWorker asyncWorker() {
        val asyncWorker = new AsyncWorker();
        log.info("configure async worker successful");
        return asyncWorker;
    }
}
