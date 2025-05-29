/* (C)2024*/
package org.spring.boost.minio.autoconfigure.properties;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.NestedConfigurationProperty;

@ConfigurationProperties(MinioConfigurationProperties.prefix)
@Getter
@Setter
@ToString
public class MinioConfigurationProperties {

  public static final String prefix = "spring.boost.minio";

//  private Map<String, MinioClientConfig> clients = new HashMap<>();

  @NestedConfigurationProperty
  private MinioClientConfig primary;

  private boolean checkDuplicate = false;
}
