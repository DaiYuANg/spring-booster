package org.toolkit.spring.boot.scanner.base;

import io.github.classgraph.ScanResult;

public interface ScannerResultProcessor {
	void process(ScanResult result);
}
