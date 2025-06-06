/* (C)2024*/
package org.spring.boost.core.autoconfigure;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.jetbrains.annotations.NotNull;
import org.spring.boost.core.constant.ConfigConstant;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.bind.Binder;

import java.util.Set;

@ConfigurationProperties(prefix = ConfigConstant.PREFIX)
@Getter
@Setter
@ToString(callSuper = true)
public class CoreConfigurationProperties {

  private boolean enablePrinter = true;

  public static CoreConfigurationProperties get(@NotNull Binder binder) {
    return binder.bind(ConfigConstant.PREFIX, CoreConfigurationProperties.class)
      .orElseGet(CoreConfigurationProperties::new);
  }
}
