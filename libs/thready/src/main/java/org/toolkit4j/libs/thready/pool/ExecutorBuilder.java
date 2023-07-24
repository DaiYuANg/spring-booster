package org.toolkit4j.libs.thready.pool;

import lombok.Builder;
import lombok.Getter;

import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadPoolExecutor;

@Builder
@Getter
public class ExecutorBuilder {

    @Builder.Default
    private int coreSize = Runtime.getRuntime().availableProcessors();

    @Builder.Default
    private RejectedExecutionHandler handler = new ThreadPoolExecutor.CallerRunsPolicy();
}
