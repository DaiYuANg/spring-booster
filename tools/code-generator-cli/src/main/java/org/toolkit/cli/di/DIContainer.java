package org.toolkit.cli.di;

import com.google.inject.Guice;
import com.google.inject.Injector;
import lombok.Getter;

@Getter
public enum DIContainer {
	INSTANCE;

	private final RootModule rootModule = new RootModule();

	private final Injector injector = Guice.createInjector(rootModule);
}
