package org.toolkit.spring.boot.mapping.web.autoconfigure;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "spring.mapping")
@Getter
@Setter
public class MappingWebConfigurationProperties {
    private int nestingObjectDeep = 3;
}
