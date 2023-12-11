package org.toolkit.spring.boot.mapping.source.code.configuration;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Getter
@Setter
@ToString
@ConfigurationProperties(prefix = "spring.mapping.source.code")
public class MappingCodeSourceConfigurationProperties {}
