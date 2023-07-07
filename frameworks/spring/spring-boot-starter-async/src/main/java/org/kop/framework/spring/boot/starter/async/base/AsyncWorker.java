package org.kop.framework.spring.boot.starter.async.base;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import jakarta.annotation.Resource;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;
import org.kop.framework.spring.boot.starter.async.config.AsyncWorkerProperties;
import org.springframework.stereotype.Component;

@Component
@Slf4j
@ToString
public class AsyncWorker extends org.kop.libs.thready.async.AsyncWorker {

    @Resource
    private AsyncWorkerProperties asyncWorkerProperties;

    @PostConstruct
    public void init() {
        if (asyncWorkerProperties.isPreheat()) executor.prestartAllCoreThreads();
    }

    @PreDestroy
    public void onShutdown() {
        log.info("shutdown thread pool");
        executor.shutdown();
    }
}