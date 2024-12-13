/* (C)2023*/
package org.spring.boost.cli.configuration;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.NestedConfigurationProperty;

@Setter
@Getter
@ToString
@ConfigurationProperties(prefix = "spring.boost")
public class CLIConfigurationProperties {
  private String packageName;

  private String jdkVersion = "21";

  @NestedConfigurationProperty
  private DatasourceConfigurationProperties datasourceConfigurationProperties;
}
