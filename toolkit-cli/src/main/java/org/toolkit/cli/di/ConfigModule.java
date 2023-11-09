package org.toolkit.cli.di;

import com.google.inject.AbstractModule;
import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.github.gestalt.config.Gestalt;
import org.github.gestalt.config.builder.GestaltBuilder;
import org.github.gestalt.config.source.ClassPathConfigSource;
import org.github.gestalt.config.source.FileConfigSource;
import org.github.gestalt.config.source.MapConfigSource;

import java.io.File;

@Slf4j
public class ConfigModule extends AbstractModule {

	@Override
	protected void configure() {

		//        bind(SmallRyeConfig.class).toProvider(SmallRyeConfigProvider.class);
	}
}
