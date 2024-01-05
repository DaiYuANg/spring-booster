package org.spring.boost.authentication.feature.bundle;

import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.val;
import org.spring.boost.authentication.feature.FeatureInstaller;
import org.spring.boost.authentication.properties.CORSConfigurationProperties;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

@RequiredArgsConstructor
public class CORSConfigureInstaller implements FeatureInstaller {

    private final CORSConfigurationProperties configurationProperties;

    @SneakyThrows
    @Override
    public void install(HttpSecurity http) {
        if (!configurationProperties.isEnable()) {
            http.cors(AbstractHttpConfigurer::disable);
            return;
        }
        val configuration = new CorsConfiguration();
        configuration.setAllowedOrigins(configurationProperties.getAllowedOrigins());
        configuration.setAllowedMethods(configurationProperties.getAllowedMethods());
        val source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", configuration);
    }
}
