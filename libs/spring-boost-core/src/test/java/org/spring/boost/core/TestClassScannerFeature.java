/* (C)2024*/
package org.spring.boost.core;

import io.github.classgraph.ScanResult;
import lombok.extern.slf4j.Slf4j;
import org.spring.boost.core.api.FeatureInstaller;
import org.springframework.context.ConfigurableApplicationContext;

@Slf4j
public class TestClassScannerFeature implements FeatureInstaller<ScanResult> {
  @Override
  public void install(ConfigurableApplicationContext context, ScanResult t) {
    FeatureInstaller.super.install(context, t);
  }
}
