package org.kop.framework.spring.boot.starter.dict.scanner;

import org.jetbrains.annotations.NotNull;
import org.kop.framework.spring.boot.starter.dict.funcational.DictFunctional;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentMap;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public interface DictScanner {
    Map<String, Stream<Class<?>>> scannedClasspath = new HashMap<>();

    default ConcurrentMap<String, DictFunctional> doScan() {
        return processClasspath()
                .map(this::scanPackages)
                .flatMap(this::collectDict)
                .collect(Collectors.toConcurrentMap(DictFunctional::getCode, dictFunctional -> dictFunctional));
    }

    ;

    Stream<String> processClasspath();

    Stream<Class<?>> scanPackages(String packages);

    Stream<DictFunctional> collectDict(@NotNull Stream<Class<?>> scanned);

    DictFunctional parseDictAnnotation(@NotNull Class<?> c);
}
