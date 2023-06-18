package org.kop.apps.yodb.server.config;

import lombok.Data;
import org.eclipse.microprofile.config.spi.ConfigSource;

import java.util.Set;

@Data
public class ConfigStruct implements ConfigSource {

    @Override
    public Set<String> getPropertyNames() {
        return null;
    }

    @Override
    public String getValue(String propertyName) {
        return null;
    }

    @Override
    public String getName() {
        return null;
    }
}
