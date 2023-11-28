package org.toolkit.spring.boot.scanner.lifecycle;

import com.google.common.util.concurrent.ThreadFactoryBuilder;
import io.github.classgraph.ClassGraph;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.schedulers.Schedulers;
import jakarta.annotation.PostConstruct;

import java.util.concurrent.Executors;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.toolkit.spring.boot.scanner.base.ScannerResultProcessor;
import org.toolkit.spring.boot.utils.bean.BeanUtil;

@Slf4j
@RequiredArgsConstructor
public class Scanner {
    private final ClassGraph classGraph;

    private final BeanUtil beanUtil;

    @PostConstruct
    public void scan() {
        val processors = beanUtil.getBeansOfType(ScannerResultProcessor.class);
        log.atInfo().log("Scanners:{}", processors);
        val executor = Executors.newFixedThreadPool(
                processors.size(),
                new ThreadFactoryBuilder().setNameFormat("Scanner-%s").build());
        try (val result = classGraph.scan(Runtime.getRuntime().availableProcessors())) {
            Observable.fromIterable(processors)
                    .flatMap(processor -> Observable.fromRunnable(() -> processor.process(result))
                            .subscribeOn(Schedulers.from(executor)))
                    .blockingSubscribe(); // Wait for all tasks to complete
            executor.shutdown();
        }
    }
}
