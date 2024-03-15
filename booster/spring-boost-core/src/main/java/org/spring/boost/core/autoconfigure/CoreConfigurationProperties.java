/* (C)2024*/
package org.spring.boost.core.autoconfigure;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.NestedConfigurationProperty;

@ConfigurationProperties(prefix = "spring.boost")
@Getter
@Setter
@ToString
public class CoreConfigurationProperties {

    @NestedConfigurationProperty
    private ClassScannerConfig classScanner = new ClassScannerConfig();
}
