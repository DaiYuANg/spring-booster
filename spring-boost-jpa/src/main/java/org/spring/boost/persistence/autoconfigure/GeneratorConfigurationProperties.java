/* (C)2023*/
package org.spring.boost.persistence.autoconfigure;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.boot.context.properties.ConfigurationProperties;

@ToString
@Setter
@Getter
@ConfigurationProperties(prefix = "persistence.generator")
public class GeneratorConfigurationProperties {}
