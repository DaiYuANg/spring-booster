/* (C)2023*/
package org.nectar.cli.di;

import com.google.inject.AbstractModule;
import com.google.inject.multibindings.Multibinder;
import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.github.gestalt.config.source.ConfigSourcePackage;

@Slf4j
public class ConfigModule extends AbstractModule {

	@Override
	protected void configure() {
		val mb = Multibinder.newSetBinder(binder(), ConfigSourcePackage.class);
	}
}
