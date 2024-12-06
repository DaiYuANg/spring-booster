/* (C)2023*/
package org.spring.boost.cli.configuration;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Setter
@Getter
@ToString
@ConfigurationProperties
public class DatasourceConfigurationProperties {
  private String url;

  private String username;

  private String password;

  private String driverClassName;
}
