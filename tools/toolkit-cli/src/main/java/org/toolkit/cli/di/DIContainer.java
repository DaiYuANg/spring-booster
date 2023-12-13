/* (C)2023*/
package org.toolkit.cli.di;

import com.google.inject.Guice;
import com.google.inject.Injector;
import lombok.Getter;
import lombok.SneakyThrows;
import lombok.val;
import org.github.gestalt.config.builder.GestaltBuilder;
import org.github.gestalt.config.exceptions.GestaltException;
import org.github.gestalt.config.guice.GestaltModule;
import org.github.gestalt.config.source.ConfigSourcePackage;
import org.github.gestalt.config.source.FileConfigSourceBuilder;
import org.toolkit.cli.config.DefaultToolkitCliConfigFile;
import org.toolkit.cli.config.ToolkitCliConfig;

import java.util.List;

@Getter
public enum DIContainer {


    INSTANCE;

    private final RootModule rootModule;

    private final GestaltModule gestaltModule;

    private final Injector injector;

    private final List<ConfigSourcePackage> configs;

    @SneakyThrows
    DIContainer() {
        val defaultConfig = FileConfigSourceBuilder.builder()
                .setFile(new DefaultToolkitCliConfigFile().getConfigFile())
                .build();
        val gestalt = new GestaltBuilder().addSource(defaultConfig).build();
        gestalt.loadConfigs();
        System.err.println(gestalt.getConfig("test", String.class));
        rootModule = new RootModule();
        gestaltModule = new GestaltModule(gestalt);
        injector = Guice.createInjector(rootModule, gestaltModule);
        configs = List.of(
                FileConfigSourceBuilder.builder()
                        .setFile(new DefaultToolkitCliConfigFile().getConfigFile())
                        .build()
        );
    }
}
