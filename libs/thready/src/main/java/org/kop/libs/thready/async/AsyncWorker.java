package org.kop.libs.thready.async;

import lombok.Builder;
import lombok.extern.slf4j.Slf4j;
import org.jetbrains.annotations.NotNull;

import java.util.Arrays;
import java.util.Objects;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.function.Supplier;

@Slf4j
@Builder
public class AsyncWorker {
    private ThreadPoolExecutor executor;

    public void warm(){
        executor.prestartAllCoreThreads();
    }

    public CompletableFuture<Void> run(@NotNull Runnable action, @NotNull ThreadPoolExecutor executor) {
        return CompletableFuture.runAsync(action, executor).handle(this::handle);
    }

    /**
     * @param actions Runnable method
     * @return CompletableFuture
     */
    public CompletableFuture<Void> parallelRunWait(Runnable... actions) {
        return CompletableFuture.allOf(
                Arrays.stream(actions)
                        .map(this::run)
                        .toArray(CompletableFuture[]::new)
        );
    }

    public CompletableFuture<Object> parallelRunDoNotWait(Runnable... actions) {
        return CompletableFuture.anyOf(
                Arrays.stream(actions)
                        .map(this::run)
                        .toArray(CompletableFuture[]::new)
        );
    }

    public <T> CompletableFuture<T> supply(Supplier<T> supplier, ThreadPoolExecutor executor) {
        return CompletableFuture.supplyAsync(supplier, executor);
    }

    public <T> CompletableFuture<T> supply(Supplier<T> supplier) {
        return supply(supplier, executor);
    }

    @SafeVarargs
    public final void parallelRunWaitForFinish(CompletableFuture<Void>... actions) {
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
