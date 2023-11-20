package org.toolkit.spring.boot.dotenv.source;

import org.jetbrains.annotations.NotNull;
import org.springframework.core.env.PropertySource;

public class DotenvPropertySource extends PropertySource<String> {
    public DotenvPropertySource(String name, String source) {
        super(name, source);
    }

    @Override
    public Object getProperty(@NotNull String name) {
        return null;
    }
}
