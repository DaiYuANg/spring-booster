package org.spring.boost.admin.autoconfigure;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "spring.boost.admin")
@Getter
@Setter
public class SpringBoostAdminProperties {

  private Integer port = 10000;
  private Boolean autoOpen = false;
}
