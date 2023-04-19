package org.daiyuang.thready.async;

import lombok.extern.java.Log;
import lombok.extern.slf4j.Slf4j;
import org.daiyuang.thready.pool.PoolCreator;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ThreadPoolExecutor;

@Slf4j
public class Workers {
    ThreadPoolExecutor executor = new PoolCreator().creator();

    public CompletableFuture<Void> submitAsyncWork(@NotNull Class<?> source, @NotNull Runnable action, @NotNull ThreadPoolExecutor executor) {
        return CompletableFuture
                .runAsync(() -> log.info("where:{}", source), executor)
                .thenRun(action)
                .handle((unused, throwable) -> {
                    if (throwable != null) {
                        log.error("from:{}", source);
                        throw new RuntimeException(throwable);
                    }
                    return null;
                });
    }

    public CompletableFuture<Void> submitMultiWork(Class<?> source, Runnable... actions) {
        return CompletableFuture.allOf(
                Arrays.stream(actions)
                        .map(action -> submitAsyncWork(source, action))
                        .toArray(CompletableFuture[]::new)
        ).toCompletableFuture();
    }

    @SafeVarargs
    public final void submitMultiWork(Class<?> source, CompletableFuture<Void>... actions) {
        CompletableFuture.allOf(actions)
                .handle(this::handle)
                .whenComplete((unused, throwable) ->
                        log.info("from:{} work all done", source)).toCompletableFuture();
    }

    public Void handle(Void u, Throwable t) {
        if (t != null) {
            t.printStackTrace();
        }
        throw new RuntimeException(t);
    }

    public CompletableFuture<Void> submitAsyncWork(Class<?> source, Runnable action) {
        return submitAsyncWork(source, action, executor);
    }
}
