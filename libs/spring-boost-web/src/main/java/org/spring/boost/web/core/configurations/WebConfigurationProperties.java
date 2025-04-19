/* (C)2023*/
package org.spring.boost.web.core.configurations;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.http.ResponseEntity;

@ConfigurationProperties(prefix = "spring")
@Getter
@Setter
public class WebConfigurationProperties {
  /**
   * Global return value struct
   */
  private Class<?> returnResult = ResponseEntity.class;

  private Boolean enableReusableRequest = false;

  private Boolean enabledRequestLog;
}
