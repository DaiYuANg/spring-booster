/* (C)2024*/
package org.spring.boost.core;

import io.github.classgraph.ScanResult;
import lombok.extern.slf4j.Slf4j;
import org.jetbrains.annotations.NotNull;
import org.spring.boost.core.api.ClassPathScannerFeatureInstaller;

@Slf4j
public class TestClassScannerFeature implements ClassPathScannerFeatureInstaller {
    @Override
    public void install(@NotNull ScanResult scanResult) {}
}
