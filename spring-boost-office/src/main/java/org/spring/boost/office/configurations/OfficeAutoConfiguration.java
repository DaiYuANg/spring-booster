/* (C)2023*/
package org.spring.boost.office.configurations;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.pool2.impl.GenericObjectPool;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.spring.boost.office.ExcelFactory;
import org.spring.boost.office.factory.HSSFWorkbookObjectFactory;
import org.spring.boost.office.factory.SXSSFWorkbookObjectFactory;
import org.spring.boost.office.factory.XSSFWorkbookObjectFactory;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;

@AutoConfiguration
@Slf4j
@EnableConfigurationProperties(OfficeConfigurationProperties.class)
@RequiredArgsConstructor
public class OfficeAutoConfiguration {

    private final OfficeConfigurationProperties officeConfigurationProperties;

    @Bean
    HSSFWorkbookObjectFactory hssfWorkbookFactory() {
        return new HSSFWorkbookObjectFactory();
    }

    @Bean
    SXSSFWorkbookObjectFactory sxssfWorkbookFactory() {
        return new SXSSFWorkbookObjectFactory();
    }

    @Bean
    XSSFWorkbookObjectFactory xssfWorkbookFactory() {
        return new XSSFWorkbookObjectFactory();
    }

    @Bean
    GenericObjectPool<HSSFWorkbook> hssfWorkbookGenericObjectPool(
            HSSFWorkbookObjectFactory workbookFactory
    ) {
        return new GenericObjectPool<>(workbookFactory);
    }

    @Bean
    GenericObjectPool<SXSSFWorkbook> sxssfWorkbookGenericObjectPool(
            SXSSFWorkbookObjectFactory sxssfWorkbookObjectFactory
    ) {
        return new GenericObjectPool<>(sxssfWorkbookObjectFactory);
    }

    @Bean
    GenericObjectPool<XSSFWorkbook> xssfWorkbookFactoryGenericObjectPool(
            XSSFWorkbookObjectFactory xssfWorkbookObjectFactory
    ) {
        return new GenericObjectPool<>(xssfWorkbookObjectFactory);
    }
}
