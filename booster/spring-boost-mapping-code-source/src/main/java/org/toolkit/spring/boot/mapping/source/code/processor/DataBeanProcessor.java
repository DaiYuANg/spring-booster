/* (C)2023*/
package org.toolkit.spring.boot.mapping.source.code.processor;

import io.github.classgraph.ScanResult;
import lombok.extern.slf4j.Slf4j;
import org.spring.boost.core.api.ClassPathScannerFeatureInstaller;

@Slf4j
public class DataBeanProcessor implements ClassPathScannerFeatureInstaller {

    @Override
    public void install(ScanResult scanResult) {}
}
