/* (C)2023*/
package org.toolkit.spring.boot.mapping.core.configuration;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "spring.mapping.core")
@Getter
@Setter
public class MappedConfigurationProperties {}
