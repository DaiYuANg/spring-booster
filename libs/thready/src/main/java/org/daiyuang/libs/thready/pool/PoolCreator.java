package org.daiyuang.libs.thready.pool;

import com.google.common.util.concurrent.ThreadFactoryBuilder;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.jetbrains.annotations.NotNull;

import java.util.Arrays;
import java.util.Objects;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

@Slf4j
public class PoolCreator implements ICreator {
    public static int CPU_COUNT = Runtime.getRuntime().availableProcessors();

    public static final TimeUnit UNIT = TimeUnit.SECONDS;
    private static final String LOG_TEMPLATE = "which thread:{} id:{},exception:{}";
    private ThreadPoolExecutor executor;

    private static String generatorNameFromClass(@NotNull Class<?> clazz) {
        var name = Arrays.asList(clazz.getName().split("\\."));
        return name.get(name.size() - 1);
    }

//    @Contract(pure = true)
//    public static Thread.@NotNull UncaughtExceptionHandler exceptionHandler() {
////        return (t, e) -> log.info(LOG_TEMPLATE, t.getName(), t.getId(), e.getMessage());
//    }

    @Override
    public ThreadPoolExecutor creator() {
        if (Objects.nonNull(executor)) return executor;
        return executor = new ThreadPoolExecutor(
                CPU_COUNT + 1,
                CPU_COUNT * 4,
                50,
                UNIT,
                new ArrayBlockingQueue<>(60),
                new ThreadFactoryBuilder()
                        .setNameFormat(generatorNameFromClass(this.getClass()) + "-%d")
//                        .setUncaughtExceptionHandler(exceptionHandler())
                        .build(),
                new ThreadPoolExecutor.CallerRunsPolicy());
    }

    @AllArgsConstructor
    public enum PoolProperty {
//        QUEUE_CAPACITY(100),
//        KEEP_ALIVE_TIME(60);
//
//        @Getter
//        final int value;
    }
}
