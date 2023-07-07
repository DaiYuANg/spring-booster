package org.kop.framework.spring.boot.starter.async.config;

import lombok.Data;
import lombok.ToString;
import org.kop.libs.thready.enums.PoolProperty;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

@ConfigurationProperties(prefix = "helpers.async", ignoreInvalidFields = true)
@Data
@ToString
public class AsyncWorkerProperties {
    private String poolNamePrefix = "async-worker";

    private Class<? extends RejectedExecutionHandler> rejectedExecution = ThreadPoolExecutor.CallerRunsPolicy.class;

    private int maxWorker = PoolProperty.CPU_COUNT.getValue() + 1;

    private int coreWorker = PoolProperty.CPU_COUNT.getValue();

    private int queueCapacity = PoolProperty.QUEUE_CAPACITY.getValue();

    private int aliveTime = PoolProperty.KEEP_ALIVE_TIME.getValue();

    private TimeUnit aliveTimeUnit = TimeUnit.MINUTES;

    private boolean preheat = false;
}
