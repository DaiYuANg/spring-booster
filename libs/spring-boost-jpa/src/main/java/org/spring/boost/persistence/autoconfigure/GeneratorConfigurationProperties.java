/* (C)2023*/
package org.spring.boost.persistence.autoconfigure;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.jetbrains.annotations.NotNull;
import org.spring.boost.core.constant.ConfigConstant;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.bind.Binder;

@ToString
@Setter
@Getter
@ConfigurationProperties(prefix =  ConfigConstant.PREFIX +"jpa.generator")
public class GeneratorConfigurationProperties {
  private Long offset = 1L;

  private Integer nodeId = 1;

  public static GeneratorConfigurationProperties get(@NotNull Binder binder) {
    return binder.bind(ConfigConstant.PREFIX, GeneratorConfigurationProperties.class)
      .orElseGet(GeneratorConfigurationProperties::new);
  }
}
