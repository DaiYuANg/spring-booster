package org.toolkit.spring.boot.dotenv.factory;

import lombok.extern.slf4j.Slf4j;
import org.jetbrains.annotations.NotNull;
import org.springframework.core.env.PropertySource;
import org.springframework.core.io.support.EncodedResource;
import org.springframework.core.io.support.PropertySourceFactory;

@Slf4j
public class DotenvPropertySourceFactory implements PropertySourceFactory {
	@Override
	public @NotNull PropertySource<?> createPropertySource(String name, @NotNull EncodedResource resource) {
		return null;
	}
}
