package org.toolkit4j.libs.thready.pool;

import lombok.experimental.UtilityClass;
import lombok.extern.slf4j.Slf4j;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

import java.util.Arrays;

@Slf4j
@UtilityClass
public class ExecutorsFactory {
    private static final String LOG_TEMPLATE = "which thread:{} id:{},exception:{}";

    private static String generatorNameFromClass(@NotNull Class<?> clazz) {
        var name = Arrays.asList(clazz.getName().split("\\."));
        return name.get(name.size() - 1);
    }

    @Contract(pure = true)
    public static Thread.@NotNull UncaughtExceptionHandler exceptionHandler() {
        return (t, e) -> log.info(LOG_TEMPLATE, t.getName(), t.getId(), e.getMessage());
    }

//    public ThreadPoolExecutor newIntensiveExecutor(ExecutorBuilder builder) {
//        if (Objects.nonNull(executor)) return executor;
//        return executor = new ThreadPoolExecutor(
//                CPU_COUNT + 1,
//                CPU_COUNT * 2,
//                50,
//                UNIT,
//                new ArrayBlockingQueue<>(60),
//                new ThreadFactoryBuilder().build(),
//                new ThreadPoolExecutor.CallerRunsPolicy());
//    }

//    @Contract(" -> new")
//    private @NotNull ThreadFactory threadFactory() {
//        return new ThreadFactoryBuilder()
//                .setNameFormat(generatorNameFromClass() + "-%d")
//                .setUncaughtExceptionHandler(exceptionHandler())
//                .build();
//    }
}
