package org.toolkit.cli.provider;

import io.smallrye.config.SmallRyeConfig;
import io.smallrye.config.SmallRyeConfigBuilder;
import jakarta.inject.Provider;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class SmallRyeConfigProvider implements Provider<SmallRyeConfig> {
    @Override
    public SmallRyeConfig get() {

        return new SmallRyeConfigBuilder()
                .addDefaultInterceptors()
                .addDefaultSources()
                .build();
    }
}
