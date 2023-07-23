package org.toolkit4j.libs.thready.pool;

import lombok.Builder;
import lombok.Getter;
import org.toolkit4j.libs.thready.enums.PoolProperty;

import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadPoolExecutor;

@Builder
@Getter
public class ExecutorBuilder {

    private int coreSize = Runtime.getRuntime().availableProcessors();

    private RejectedExecutionHandler handler = new ThreadPoolExecutor.CallerRunsPolicy();
}
