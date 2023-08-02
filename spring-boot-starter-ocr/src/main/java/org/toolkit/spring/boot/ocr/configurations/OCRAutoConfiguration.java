package org.toolkit.spring.boot.ocr.configurations;

import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@AutoConfiguration
@EnableConfigurationProperties(OCRConfigurationProperties.class)
public class OCRAutoConfiguration {

}
