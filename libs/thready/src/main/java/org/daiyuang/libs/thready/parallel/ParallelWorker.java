package org.daiyuang.libs.thready.parallel;

import com.google.common.base.Stopwatch;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@Slf4j
public class ParallelWorker {
    private static final ExecutorService cacheExecutor = Executors.newCachedThreadPool();

    @SneakyThrows
    public static void main(String[] args) {
        var s = Stopwatch.createStarted();
        CompletableFuture.allOf(
                CompletableFuture.runAsync(ParallelWorker::task, cacheExecutor),
                CompletableFuture.runAsync(ParallelWorker::task, cacheExecutor),
                CompletableFuture.runAsync(ParallelWorker::task, cacheExecutor)
        ).get();
        s.stop();
        log.info(String.valueOf(s.elapsed().getSeconds()));
    }

    @SneakyThrows
    private static void task() {
        log.info("123");
        TimeUnit.SECONDS.sleep(2);
    }
}
