package org.spring.boost.authentication.jwt;

import lombok.RequiredArgsConstructor;
import org.jetbrains.annotations.NotNull;
import org.spring.boost.authentication.feature.FeatureInstaller;
import org.spring.boost.authentication.jwt.filter.JwtAuthenticationFilter;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@RequiredArgsConstructor
public class JwtFeatureInstaller implements FeatureInstaller {

    private final JwtAuthenticationFilter jwtAuthenticationFilter;
    @Override
    public void install(@NotNull HttpSecurity http) {
        http.addFilterBefore(jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class);
    }
}
