package org.toolkit.cli.module;

import com.google.inject.AbstractModule;
import io.smallrye.config.SmallRyeConfig;
import io.smallrye.config.SmallRyeConfigBuilder;
import jakarta.inject.Singleton;
import lombok.extern.slf4j.Slf4j;
import org.toolkit.cli.provider.SmallRyeConfigProvider;

@Slf4j
public class ConfigModule extends AbstractModule {
    @Override
    protected void configure() {
        bind(SmallRyeConfig.class).toProvider(SmallRyeConfigProvider.class).in(Singleton.class);
    }
}
