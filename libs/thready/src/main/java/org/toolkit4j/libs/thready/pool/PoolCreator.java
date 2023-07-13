package org.toolkit4j.libs.thready.pool;

import com.google.common.util.concurrent.ThreadFactoryBuilder;
import lombok.extern.slf4j.Slf4j;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import org.toolkit4j.libs.thready.enums.PoolProperty;

import java.util.Arrays;
import java.util.Objects;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

@Slf4j
public class PoolCreator implements ICreator {
    public static final TimeUnit UNIT = TimeUnit.SECONDS;
    private static final String LOG_TEMPLATE = "which thread:{} id:{},exception:{}";
    private ThreadPoolExecutor executor;

    private static String generatorNameFromClass(@NotNull Class<?> clazz) {
        var name = Arrays.asList(clazz.getName().split("\\."));
        return name.get(name.size() - 1);
    }

    @Contract(pure = true)
    public static Thread.@NotNull UncaughtExceptionHandler exceptionHandler() {
        return (t, e) -> log.info(LOG_TEMPLATE, t.getName(), t.getId(), e.getMessage());
    }

    @Override
    public ThreadPoolExecutor creator() {
        if (Objects.nonNull(executor)) return executor;
        return executor = new ThreadPoolExecutor(
                PoolProperty.CPU_COUNT.getValue() + 1,
                PoolProperty.CPU_COUNT.getValue() * 4,
                50,
                UNIT,
                new ArrayBlockingQueue<>(60),
                threadFactory(),
                new ThreadPoolExecutor.CallerRunsPolicy());
    }

    @Contract(" -> new")
    private @NotNull ThreadFactory threadFactory() {
        return new ThreadFactoryBuilder()
                .setNameFormat(generatorNameFromClass(this.getClass()) + "-%d")
                .setUncaughtExceptionHandler(exceptionHandler())
                .build();
    }
}
