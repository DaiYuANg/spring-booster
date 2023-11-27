package org.toolkit.spring.boot.scanner.autoconfigure;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "spring.scanner")
@Getter
@Setter
public class ScannerConfigurationProperties {
	private Boolean debug = false;
}
