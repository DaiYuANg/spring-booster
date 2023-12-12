/* (C)2023*/
package org.toolkit.cli.di;

import com.google.inject.AbstractModule;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.github.gestalt.config.Gestalt;
import org.github.gestalt.config.builder.GestaltBuilder;
import org.github.gestalt.config.source.ClassPathConfigSourceBuilder;

@Slf4j
public class RootModule extends AbstractModule {

	@SneakyThrows
	@Override
	protected void configure() {
		bind(Executor.class).toInstance(Executors.newVirtualThreadPerTaskExecutor());
		Gestalt gestalt = new GestaltBuilder()
				.addSource(ClassPathConfigSourceBuilder.builder()
						.setResource("/default.properties")
						.build()) // Load the default property files from resources.
				//
				// .addSource(FileConfigSourceBuilder.builder().setFile(devFile).setTags(Tags.of("environment",
				// "dev")).build())
				//                .addSource(MapConfigSourceBuilder.builder().setCustomConfig(configs).build())
				.build();
	}
}
