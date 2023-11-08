package org.toolkit.cli.di;

import com.google.inject.Guice;
import com.google.inject.Injector;
import lombok.Getter;

public enum DIContainer {
    INSTANCE;

    private final ConfigModule configModule = new ConfigModule();

    @Getter
    private final Injector injector = Guice.createInjector(configModule);
}
