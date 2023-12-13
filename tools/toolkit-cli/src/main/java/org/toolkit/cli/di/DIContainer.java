/* (C)2023*/
package org.toolkit.cli.di;

import com.google.inject.Guice;
import com.google.inject.Injector;
import lombok.Getter;
import lombok.SneakyThrows;

@Getter
public enum DIContainer {
	INSTANCE;

	private final RootModule rootModule;

//	private final GestaltModule gestaltModule;

	private final Injector injector;

//	private final List<ConfigSourcePackage> configs;

	@SneakyThrows
	DIContainer() {
//		ConfigSourcePackage build = FileConfigSourceBuilder.builder()
//				.setFile(new DefaultToolkitCliConfigProviderFile().getConfigFile())
//				.build();
//		val gestalt = new GestaltBuilder().addSource(defaultConfig)
//				.addSource(EnvironmentConfigSourceBuilder.builder().setPrefix("my.app.config").build())
//				.build();
//		gestalt.loadConfigs();
		rootModule = new RootModule();
//		gestaltModule = new GestaltModule(gestalt);
		injector = Guice.createInjector(rootModule);
//		configs = List.of(FileConfigSourceBuilder.builder()
//				.setFile(new DefaultToolkitCliConfigProviderFile().getConfigFile())
//				.build());
	}
}
