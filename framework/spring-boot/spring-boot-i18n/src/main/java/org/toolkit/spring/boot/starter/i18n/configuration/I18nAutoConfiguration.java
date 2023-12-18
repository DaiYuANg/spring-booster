/* (C)2023*/
package org.toolkit.spring.boot.starter.i18n.configuration;

import jakarta.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@AutoConfiguration
@Slf4j
@EnableConfigurationProperties(I18nConfigurationProperties.class)
public class I18nAutoConfiguration {

	@PostConstruct
	public void init() {
		log.atDebug().log("I18n auto config executing");
	}
}
