/* (C)2023*/
package org.toolkit.spring.boot.mapping.web.autoconfigure;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "spring.mapping")
@Getter
@Setter
@ToString
public class MappingWebConfigurationProperties {
    private int nestingObjectDeep = 3;

    private String mappingAdvice;
}
