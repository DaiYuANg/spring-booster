package org.spring.boost.authentication.feature;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;

public interface FeatureInstaller {

    void install(HttpSecurity http);
}
