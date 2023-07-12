package org.kop.framework.spring.boot.starter.async.base;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import jakarta.annotation.Resource;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;
import org.kop.framework.spring.boot.starter.async.config.AsyncWorkerProperties;
import org.springframework.stereotype.Component;

import java.util.Objects;
import java.util.concurrent.ThreadPoolExecutor;

@Component
@Slf4j
@ToString
public class AsyncWorker extends org.kop.libs.thready.async.AsyncWorker {

    @Resource
    private ThreadPoolExecutor executor;

    @Resource
    private AsyncWorkerProperties asyncWorkerProperties;

    @PostConstruct
    public void init() {
        setExecutor(executor);
        if (asyncWorkerProperties.isPreheat() && Objects.nonNull(executor)) executor.prestartAllCoreThreads();
    }

    @PreDestroy
    public void onShutdown() {
        log.info("shutdown thread pool");
        executor.shutdown();
    }
}
