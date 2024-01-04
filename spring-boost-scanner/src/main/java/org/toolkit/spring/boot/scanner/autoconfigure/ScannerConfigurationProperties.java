/* (C)2023*/
package org.toolkit.spring.boot.scanner.autoconfigure;

import java.util.HashSet;
import java.util.Set;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.jetbrains.annotations.NotNull;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.bind.Binder;

@ConfigurationProperties(prefix = ScannerConfigurationProperties.CONFIGURATION_NAME)
@Getter
@Setter
@ToString
public class ScannerConfigurationProperties {

    public static final String CONFIGURATION_NAME = "spring.scanner";

    private Boolean debug = false;

    private Set<String> classPath = new HashSet<>();

    public static ScannerConfigurationProperties get(@NotNull Binder binder) {
        return binder.bind(CONFIGURATION_NAME, ScannerConfigurationProperties.class)
                .orElseGet(ScannerConfigurationProperties::new);
    }
}
