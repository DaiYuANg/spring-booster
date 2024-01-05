package org.spring.boost.authentication.feature.bundle.authenticated;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.jetbrains.annotations.NotNull;
import org.spring.boost.authentication.feature.FeatureInstaller;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;

/**
 * Register authenticatedEventFilter
 */
@RequiredArgsConstructor
@Slf4j
public class AuthenticatedEventPublisherInstaller implements FeatureInstaller {

    private final AuthenticatedEventFilter authenticatedEventFilter;

    @Override
    public void install(@NotNull HttpSecurity http) {
        http.addFilter(authenticatedEventFilter);
    }
}
