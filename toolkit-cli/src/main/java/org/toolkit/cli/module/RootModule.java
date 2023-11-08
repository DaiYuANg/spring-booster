package org.toolkit.cli.module;

import com.google.inject.AbstractModule;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class RootModule extends AbstractModule {
    @Override
    protected void configure() {
        log.atInfo().log("Root module execute");
    }
}
