package org.toolkit.cli.module;

import com.google.inject.Guice;
import com.google.inject.Injector;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
public enum DIContainer {
    INSTANCE;

    private final RootModule rootModule = new RootModule();

    private final ConfigModule configModule = new ConfigModule();

    @Getter
    final Injector injector = Guice.createInjector(rootModule, configModule);
}
