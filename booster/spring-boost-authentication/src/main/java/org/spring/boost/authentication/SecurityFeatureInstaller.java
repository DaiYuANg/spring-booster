/* (C)2024*/
package org.spring.boost.authentication;

import org.spring.boost.core.api.FeatureInstaller;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;

public interface SecurityFeatureInstaller extends FeatureInstaller<HttpSecurity> {

    void install(HttpSecurity http);
}
