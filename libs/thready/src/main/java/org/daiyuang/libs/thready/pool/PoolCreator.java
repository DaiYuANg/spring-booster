package org.daiyuang.libs.thready.pool;

import com.google.common.util.concurrent.ThreadFactoryBuilder;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;
import java.util.Objects;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

@Slf4j
public class PoolCreator implements ICreator {

    public static final TimeUnit UNIT = TimeUnit.SECONDS;
    private static final String LOG_TEMPLATE = "which thread:{} id:{},exception:{}";
    private ThreadPoolExecutor executor;

    private static String generatorNameFromClass(Class<?> clazz) {
        var name = Arrays.asList(clazz.getName().split("\\."));
        return name.get(name.size() - 1);
    }

    public static Thread.UncaughtExceptionHandler exceptionHandler() {
        return (t, e) -> log.info(LOG_TEMPLATE, t.getName(), t.getId(), e.getMessage());
    }

    @Override
    public ThreadPoolExecutor creator() {
        if (Objects.nonNull(executor)) return executor;
        return executor = new ThreadPoolExecutor(
                PoolProperty.CPU_COUNTS.value + 1,
                PoolProperty.CPU_COUNTS.value * 4,
                PoolProperty.KEEP_ALIVE_TIME.value,
                UNIT,
                new ArrayBlockingQueue<>(PoolProperty.QUEUE_CAPACITY.value),
                new ThreadFactoryBuilder()
                        .setNameFormat(generatorNameFromClass(this.getClass()) + "-%d")
                        .setUncaughtExceptionHandler(exceptionHandler())
                        .build(),
                new ThreadPoolExecutor.CallerRunsPolicy());
    }

    @AllArgsConstructor
    public enum PoolProperty {
        CPU_COUNTS(Runtime.getRuntime().availableProcessors()),

        QUEUE_CAPACITY(100),
        KEEP_ALIVE_TIME(60);

        @Getter
        final int value;
    }
}
