package org.daiyuang.thready.async;

import lombok.extern.slf4j.Slf4j;
import org.daiyuang.thready.pool.PoolCreator;
import org.jetbrains.annotations.NotNull;

import java.util.Arrays;
import java.util.Objects;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.function.Supplier;

@Slf4j
public class Workers {
    ThreadPoolExecutor executor = new PoolCreator().creator();

    public CompletableFuture<Void> run(@NotNull Runnable action, @NotNull ThreadPoolExecutor executor) {
        return CompletableFuture.runAsync(action, executor).handle(this::handle);
    }


    /**
     * @param actions Runnable method
     * @return CompletableFuture
     */
    public CompletableFuture<Void> parallelRunWaitForFinish(Runnable... actions) {
        return CompletableFuture.allOf(
                Arrays.stream(actions)
                        .map(this::run)
                        .toArray(CompletableFuture[]::new)
        ).toCompletableFuture();
    }

    public <T> CompletableFuture<T> supply(Supplier<T> supplier) {
        return CompletableFuture.supplyAsync(supplier, executor).toCompletableFuture();
    }

    @SafeVarargs
    public final void parallelRunWaitForFinish(Class<?> source, CompletableFuture<Void>... actions) {
        CompletableFuture.allOf(actions).handle(this::handle);
    }

    public Void handle(Void u, Throwable t) {
        if (Objects.isNull(t)) return u;
        t.printStackTrace();
        throw new RuntimeException(t);
    }

    public CompletableFuture<Void> run(Runnable action) {
        return run(action, executor);
    }
}
