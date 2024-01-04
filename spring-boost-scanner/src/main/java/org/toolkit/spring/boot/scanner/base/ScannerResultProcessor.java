/* (C)2023*/
package org.toolkit.spring.boot.scanner.base;

import io.github.classgraph.ScanResult;
import org.springframework.context.ConfigurableApplicationContext;

public interface ScannerResultProcessor {
    void process(ScanResult result, ConfigurableApplicationContext context);
}
