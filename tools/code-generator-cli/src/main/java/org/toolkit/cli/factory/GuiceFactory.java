package org.toolkit.cli.factory;

import com.google.inject.ConfigurationException;
import org.toolkit.cli.di.DIContainer;
import picocli.CommandLine;

public class GuiceFactory implements CommandLine.IFactory {
	@Override
	public <K> K create(Class<K> aClass) throws Exception {
		try {
			return DIContainer.INSTANCE.getInjector().getInstance(aClass);
		} catch (ConfigurationException ex) { // no implementation found in Guice configuration
			return CommandLine.defaultFactory().create(aClass); // fallback if missing
		}
	}
}
