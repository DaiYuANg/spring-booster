package org.toolkit.cli.service;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.github.gestalt.config.Gestalt;
import org.github.gestalt.config.builder.GestaltBuilder;
import org.github.gestalt.config.json.JsonLoader;
import org.github.gestalt.config.loader.EnvironmentVarsLoader;
import org.github.gestalt.config.loader.PropertyLoader;
import org.github.gestalt.config.source.EnvironmentConfigSource;
import org.github.gestalt.config.source.FileConfigSource;
import org.github.gestalt.config.toml.TomlLoader;
import org.github.gestalt.config.yaml.YamlLoader;

import java.io.File;

@Slf4j
public class ConfigService implements IConfigService {

    private String configPath = "./tk-cli.toml";

    public ConfigService() {
        log.atDebug().log("using default config");
        readConfig();
    }

    @SneakyThrows
    public ConfigService(String configFilePath) {
        this.configPath = configFilePath;
        readConfig();
    }

    @SneakyThrows
    private void readConfig() {
        Gestalt gestalt = new GestaltBuilder()
                .addSource(new FileConfigSource(new File(configPath)))
                .addSource(new EnvironmentConfigSource())
                .addConfigLoader(new TomlLoader())
                .addConfigLoader(new EnvironmentVarsLoader())
                .addConfigLoader(new JsonLoader())
                .addConfigLoader(new YamlLoader())
                .addConfigLoader(new PropertyLoader())
                .build();
        gestalt.loadConfigs();
    }
}
