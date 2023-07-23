package org.toolkit4J.frameworks.spring.boot.starter.office.configurations;

import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;

import java.io.IOException;

@AutoConfiguration
@Slf4j
@ConditionalOnClass({Workbook.class})
public class OfficeAutoConfiguration {
    public void test() {
        try (val s = new XSSFWorkbook()) {
            Sheet sheet = s.createSheet();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
