package org.spring.boost.authentication.feature;

import org.spring.boost.core.api.FeatureInstaller;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AuthorizeHttpRequestsConfigurer;

public interface AuthorizeHttpRequestFeatureInstaller
  extends
  FeatureInstaller<AuthorizeHttpRequestsConfigurer<HttpSecurity>.AuthorizationManagerRequestMatcherRegistry> {
}
