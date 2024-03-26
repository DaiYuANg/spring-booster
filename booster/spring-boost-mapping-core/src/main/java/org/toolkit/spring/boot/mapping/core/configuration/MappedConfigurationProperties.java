/* (C)2023*/
package org.toolkit.spring.boot.mapping.core.configuration;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.spring.boost.core.autoconfigure.EnabledConfigurationProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "spring.mapping.core")
@Getter
@Setter
@ToString(callSuper = true)
public class MappedConfigurationProperties extends EnabledConfigurationProperties {
  private int nestingObjectDeep = 3;

  private String mappingAdvice;
}
