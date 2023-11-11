package org.toolkit.cli.factory;

import java.util.Objects;
import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.config.YamlPropertiesFactoryBean;
import org.springframework.core.env.PropertiesPropertySource;
import org.springframework.core.env.PropertySource;
import org.springframework.core.io.support.EncodedResource;
import org.springframework.core.io.support.PropertySourceFactory;

@Slf4j
public class YamlPropertySourceFactory implements PropertySourceFactory {
	@Override
	public @NotNull PropertySource<?> createPropertySource(String name, @NotNull EncodedResource encodedResource) {
		val factory = new YamlPropertiesFactoryBean();
		factory.setResources(encodedResource.getResource());
		val properties = factory.getObject();
		val propertyName =
				Objects.requireNonNull(encodedResource.getResource().getFilename(), "Properties Name is null");
		val propertiesSource = Objects.requireNonNull(properties, "Properties is null");
		return new PropertiesPropertySource(propertyName, propertiesSource);
	}
}
