/* (C)2024*/
package org.spring.boost.authentication.feature.bundle;

import lombok.RequiredArgsConstructor;
import org.spring.boost.authentication.SecurityFeatureInstaller;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;

@RequiredArgsConstructor
public class CSRFConfigureSecurityFeatureInstaller implements SecurityFeatureInstaller {
  @Override
  public void install(HttpSecurity http) {
  }
}
