/* (C)2023*/
package org.toolkit.visualvm.web;

import com.google.inject.Guice;
import com.google.inject.Injector;
import lombok.Getter;

public enum DIContainer {
	INSTANCE;

	private final RootModule rootModule = new RootModule();

	@Getter
	private final Injector injector = Guice.createInjector(rootModule);
}
