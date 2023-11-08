package org.toolkit.cli.di;

import com.google.inject.AbstractModule;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ConfigModule extends AbstractModule {

	@Override
	protected void configure() {
		//        bind(SmallRyeConfig.class).toProvider(SmallRyeConfigProvider.class);
	}
}
