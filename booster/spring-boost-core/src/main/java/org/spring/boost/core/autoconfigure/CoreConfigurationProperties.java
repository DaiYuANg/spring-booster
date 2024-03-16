/* (C)2024*/
package org.spring.boost.core.autoconfigure;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.spring.boost.core.constant.ConfigConstant;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.NestedConfigurationProperty;

@ConfigurationProperties(prefix = ConfigConstant.PREFIX)
@Getter
@Setter
@ToString
public class CoreConfigurationProperties extends EnabledConfigurationProperties {

  @NestedConfigurationProperty
  private ClassScannerConfig classScanner = new ClassScannerConfig();
}
