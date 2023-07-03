package org.kop.libs.thready.async;

import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.jetbrains.annotations.NotNull;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.function.Supplier;

@Slf4j
@Setter
public class AsyncWorker {
    protected ThreadPoolExecutor executor;

    public void warm() {
        executor.prestartAllCoreThreads();
    }

    public CompletableFuture<Void> run(@NotNull Runnable action, @NotNull ThreadPoolExecutor executor) {
        return CompletableFuture.runAsync(action, executor).handle(this::handle);
    }

    /**
     * @param actions Runnable method
     * @return CompletableFuture
     */
    public CompletableFuture<Void> parallelAny(Runnable... actions) {
        return CompletableFuture.allOf(
                Arrays.stream(actions)
                        .map(this::run)
                        .toArray(CompletableFuture[]::new)
        );
    }

    public CompletableFuture<Object> parallelALL(Runnable... actions) {
        return CompletableFuture.anyOf(
                Arrays.stream(actions)
                        .map(this::run)
                        .toArray(CompletableFuture[]::new)
        );
    }

    public CompletableFuture<Object> parallelALL(@NotNull List<Runnable> actions) {
        return parallelALL(actions.toArray(Runnable[]::new));
    }

    public <T> CompletableFuture<T> supply(Supplier<T> supplier, ThreadPoolExecutor executor) {
        return CompletableFuture.supplyAsync(supplier, executor);
    }

    public <T> CompletableFuture<T> supply(Supplier<T> supplier) {
        return supply(supplier, executor);
    }

    @SafeVarargs
    public final void parallelALL(CompletableFuture<Void>... actions) {
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
