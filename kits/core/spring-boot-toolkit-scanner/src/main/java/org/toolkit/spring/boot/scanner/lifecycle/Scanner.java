package org.toolkit.spring.boot.scanner.lifecycle;

import io.github.classgraph.ClassGraph;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.toolkit.spring.boot.scanner.base.ScannerResultProcessor;
import org.toolkit.spring.boot.utils.bean.BeanUtil;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executors;

@Slf4j
@RequiredArgsConstructor
public class Scanner {
    private final ClassGraph classGraph;

    private final BeanUtil beanUtil;

    @PostConstruct
    public void scan() {
        val processors = beanUtil.getBeansOfType(ScannerResultProcessor.class);
        log.atInfo().log("Scanners:{}", processors);
        try (val executor = Executors.newVirtualThreadPerTaskExecutor()) {
            try (val result = classGraph.scan(Runtime.getRuntime().availableProcessors())) {
                val scanners = processors.stream()
                        .map(processor-> CompletableFuture.runAsync(()->processor.process(result),executor)
                        )
                        .toArray(CompletableFuture[]::new);
                CompletableFuture.allOf(scanners);
                executor.shutdown();
            }
        }
    }
}
