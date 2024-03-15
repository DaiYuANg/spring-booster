/* (C)2024*/
package org.spring.boost.cli.factory;

import java.io.IOException;
import java.util.Objects;
import lombok.val;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.config.YamlPropertiesFactoryBean;
import org.springframework.core.env.PropertiesPropertySource;
import org.springframework.core.env.PropertySource;
import org.springframework.core.io.support.EncodedResource;
import org.springframework.core.io.support.PropertySourceFactory;

public class YamlPropertySourceFactory implements PropertySourceFactory {
    @Override
    public @NotNull PropertySource<?> createPropertySource(String name, @NotNull EncodedResource resource)
            throws IOException {
        val factory = new YamlPropertiesFactoryBean();
        factory.setResources(resource.getResource());
        val properties = factory.getObject();
        val propertyName = Objects.requireNonNull(resource.getResource().getFilename(), "Properties Name is null");
        val propertiesSource = Objects.requireNonNull(properties, "Properties is null");
        return new PropertiesPropertySource(propertyName, propertiesSource);
    }
}
