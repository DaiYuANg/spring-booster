/* (C)2023*/
package org.nectar.cli.factory;

import com.google.inject.ConfigurationException;
import com.google.inject.Injector;
import lombok.extern.slf4j.Slf4j;
import org.nectar.cli.di.RootDIContainer;
import picocli.CommandLine;

@Slf4j
public class GuiceFactory implements CommandLine.IFactory {
	private final Injector injector = RootDIContainer.INSTANCE.getInjector();

	@Override
	public <K> K create(Class<K> aClass) throws Exception {
		try {
			return injector.getInstance(aClass);
		} catch (ConfigurationException ex) {
			return CommandLine.defaultFactory().create(aClass);
		}
	}
}
