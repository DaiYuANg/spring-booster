/* (C)2023*/
package org.nectar.cli.di;

import com.google.inject.Guice;
import com.google.inject.Injector;

public enum ConfigDIContainer {
	INSTANCE;

	private final ConfigModule configModule = new ConfigModule();
	private final Injector injector = Guice.createInjector(configModule);
}
