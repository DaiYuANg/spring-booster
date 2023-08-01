package org.toolkit.spring.boot.starter.dict.scanner;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;
import org.jetbrains.annotations.NotNull;
import org.toolkit.spring.boot.starter.dict.funcational.DictFunctional;

public interface DictScanner {
	Map<String, Stream<Class<?>>> scannedClasspath = new HashMap<>();

	default Map<String, DictFunctional> doScan() {
		// return scanPackages()
		// .flatMap(this::collectDict)
		return new HashMap<>();
		// .collect(toUnmodifiableMap(DictFunctional::getCode, this::toMap));
	}

	// Stream<String> processClasspath();

	Stream<Class<?>> scanPackages();

	Stream<DictFunctional> collectDict(@NotNull Stream<Class<?>> scanned);

	DictFunctional parseDictAnnotation(@NotNull Class<?> c);

	private DictFunctional toMap(DictFunctional dictFunctional) {
		return dictFunctional;
	}
}
