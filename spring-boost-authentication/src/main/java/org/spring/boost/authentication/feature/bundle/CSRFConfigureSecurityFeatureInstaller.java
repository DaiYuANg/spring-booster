/* (C)2024*/
package org.spring.boost.authentication.feature.bundle;

import org.spring.boost.authentication.feature.SecurityFeatureInstaller;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;

public class CSRFConfigureSecurityFeatureInstaller implements SecurityFeatureInstaller {
    @Override
    public void install(HttpSecurity http) {}
}
