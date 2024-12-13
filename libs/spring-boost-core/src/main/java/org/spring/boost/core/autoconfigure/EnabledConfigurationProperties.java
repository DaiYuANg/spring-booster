/* (C)2023*/
package org.spring.boost.core.autoconfigure;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class EnabledConfigurationProperties {
  private boolean enabled = true;
}
