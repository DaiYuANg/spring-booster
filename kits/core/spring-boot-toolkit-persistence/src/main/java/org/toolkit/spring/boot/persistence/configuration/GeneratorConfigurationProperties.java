package org.toolkit.spring.boot.persistence.configuration;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.boot.context.properties.ConfigurationProperties;

@ToString
@Setter
@Getter
@ConfigurationProperties(prefix = "persistence.generator")
public class GeneratorConfigurationProperties {}
