package org.toolkit4j.libs.thready.async;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.function.Supplier;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.jetbrains.annotations.NotNull;

@Slf4j
@ToString
public class AsyncWorker {
	protected ThreadPoolExecutor executor;

	public void warm() {
		executor.prestartAllCoreThreads();
	}

	public CompletableFuture<Void> run(@NotNull Runnable action, @NotNull ThreadPoolExecutor executor) {
		return CompletableFuture.runAsync(action, executor).handle(this::handle);
	}

	/**
	 * @param actions
	 *            Runnable method
	 * @return CompletableFuture
	 */
	public CompletableFuture<Void> parallelAny(Runnable @NotNull ... actions) {
		if (actions.length == 0) return new CompletableFuture<>();
		return CompletableFuture.allOf(Arrays.stream(actions).map(this::run).toArray(CompletableFuture[]::new))
				.handle(this::handle);
	}

	public CompletableFuture<Object> parallelALL(Runnable @NotNull ... actions) {
		if (actions.length == 0) return new CompletableFuture<>();
		return CompletableFuture.anyOf(Arrays.stream(actions).map(this::run).toArray(CompletableFuture[]::new))
				.handle(this::handle);
	}

	public CompletableFuture<Object> parallelALL(@NotNull List<Runnable> actions) {
		return parallelALL(actions.toArray(Runnable[]::new)).handle(this::handle);
	}

	public <T> CompletableFuture<T> supply(@NotNull Supplier<T> supplier, @NotNull ThreadPoolExecutor executor) {
		return CompletableFuture.supplyAsync(supplier, executor).handle(this::handle);
	}

	public <T> CompletableFuture<T> supply(@NotNull Supplier<T> supplier) {
		return supply(supplier, executor);
	}

	@SafeVarargs
	public final CompletableFuture<Void> parallelALL(CompletableFuture<Void> @NotNull ... actions) {
		if (actions.length == 0) return new CompletableFuture<>();
		return CompletableFuture.allOf(actions).handle(this::handle);
	}

	public Void handle(Void u, Throwable t) {
		if (Objects.isNull(t)) return u;
		t.printStackTrace();
		throw new RuntimeException(t);
	}

	public <T> T handle(T u, Throwable t) {
		if (Objects.isNull(t)) return u;
		t.printStackTrace();
		throw new RuntimeException(t);
	}

	public CompletableFuture<Void> run(@NotNull Runnable action) {
		return run(action, executor);
	}

	public void setExecutor(ThreadPoolExecutor executor) {
		if (Objects.isNull(this.executor)) this.executor = executor;
		if (this.executor.equals(executor)) return;
		val oldExe = this.executor;
		this.executor = executor;
		this.executor.submit(oldExe::shutdown);
	}
}
