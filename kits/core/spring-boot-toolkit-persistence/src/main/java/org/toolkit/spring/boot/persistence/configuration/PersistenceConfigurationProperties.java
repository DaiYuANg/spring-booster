package org.toolkit.spring.boot.persistence.configuration;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "persistence")
@Setter
@Getter
@ToString
public class PersistenceConfigurationProperties {}
