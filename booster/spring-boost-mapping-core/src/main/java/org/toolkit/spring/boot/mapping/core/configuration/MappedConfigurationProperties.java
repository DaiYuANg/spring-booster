/* (C)2023*/
package org.toolkit.spring.boot.mapping.core.configuration;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "spring.mapping.core")
@Getter
@Setter
@ToString
public class MappedConfigurationProperties {}
