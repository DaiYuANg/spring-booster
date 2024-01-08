/* (C)2023*/
package org.spring.boost.office.configurations;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@AutoConfiguration
@Slf4j
@EnableConfigurationProperties(OfficeConfigurationProperties.class)
@RequiredArgsConstructor
public class OfficeAutoConfiguration {

    private final OfficeConfigurationProperties officeConfigurationProperties;
}
