/* (C)2023*/
package org.toolkit.spring.boot.office.configurations;

import lombok.extern.slf4j.Slf4j;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@AutoConfiguration
@Slf4j
@ConditionalOnClass({Workbook.class})
@EnableConfigurationProperties(OfficeConfigurationProperties.class)
public class OfficeAutoConfiguration {
	public void test() {}
}
