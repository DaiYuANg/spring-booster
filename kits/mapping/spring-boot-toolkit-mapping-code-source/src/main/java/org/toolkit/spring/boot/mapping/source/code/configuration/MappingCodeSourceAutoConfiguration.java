package org.toolkit.spring.boot.mapping.source.code.configuration;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.toolkit.spring.boot.mapping.source.code.scanner.StaticFieldScanner;
import org.toolkit.spring.boot.scanner.autoconfigure.ScannerAutoConfiguration;

@AutoConfiguration
@Slf4j
@EnableConfigurationProperties(MappingCodeSourceConfigurationProperties.class)
@AutoConfigureAfter(ScannerAutoConfiguration.class)
public class MappingCodeSourceAutoConfiguration {
	@Bean
	public StaticFieldScanner staticFieldScanner() {
		return new StaticFieldScanner();
	}
}
