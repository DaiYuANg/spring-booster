/* (C)2024*/
package org.spring.boost.core.listener;

import static java.lang.Thread.ofVirtual;
import static java.util.concurrent.CompletableFuture.allOf;
import static java.util.concurrent.CompletableFuture.runAsync;
import static java.util.concurrent.Executors.newThreadPerTaskExecutor;

import io.github.classgraph.ClassGraph;
import io.github.classgraph.ScanResult;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.function.Function;
import lombok.Cleanup;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.jetbrains.annotations.NotNull;
import org.spring.boost.core.api.BeanRegistry;
import org.spring.boost.core.api.ClassPathScannerFeatureInstaller;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;

@Slf4j
@RequiredArgsConstructor
public class ContextRefreshListener implements ApplicationListener<ContextRefreshedEvent> {

    private final ClassGraph classGraph;

    private final BeanRegistry beanRegistry;

    @Override
    @SuppressWarnings({"StaticImport", "ImmutableListBuilder"})
    public void onApplicationEvent(@NotNull ContextRefreshedEvent event) {
        classGraph.acceptPackages(beanRegistry.possibleClasspath().toArray(String[]::new));
        val tFactory = ofVirtual().name("cps-", 0).factory();
        val parallel = Runtime.getRuntime().availableProcessors() + 1;
        @Cleanup val executor = newThreadPerTaskExecutor(tFactory);
        @Cleanup val result = classGraph.scan(executor, parallel);
        val scanFuture = beanRegistry.getBeanDistinct(ClassPathScannerFeatureInstaller.class).stream()
                .map(getCompletableFutureFunction(result, executor))
                .toArray(CompletableFuture[]::new);
        allOf(scanFuture).join();
        executor.shutdown();
    }

    @Override
    public boolean supportsAsyncExecution() {
        return true;
    }

    @NotNull private static Function<ClassPathScannerFeatureInstaller, CompletableFuture<Void>> getCompletableFutureFunction(
            ScanResult result, ExecutorService executor) {
        return classPathScannerFeatureInstaller ->
                runAsync(() -> classPathScannerFeatureInstaller.install(result), executor);
    }
}
