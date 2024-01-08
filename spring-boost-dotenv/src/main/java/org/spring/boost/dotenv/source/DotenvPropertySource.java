/* (C)2023*/
package org.spring.boost.dotenv.source;

import io.github.cdimascio.dotenv.Dotenv;
import org.jetbrains.annotations.NotNull;
import org.springframework.core.env.PropertySource;

public class DotenvPropertySource extends PropertySource<Dotenv> {

    public DotenvPropertySource(String name, Dotenv source) {
        super(name, source);
    }

    @Override
    public Object getProperty(@NotNull String name) {
        return this.source.get(name);
    }
}
