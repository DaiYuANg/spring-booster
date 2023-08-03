package org.toolkit.spring.boot.starter.office;

import lombok.extern.slf4j.Slf4j;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;

@AutoConfiguration
@Slf4j
@ConditionalOnClass({Workbook.class})
public class OfficeAutoConfiguration {
	public void test() {
		//		try (val s = new XSSFWorkbook()) {
		//			Sheet sheet = s.createSheet();
		//		} catch (IOException e) {
		//			throw new RuntimeException(e);
		//		}
	}
}
