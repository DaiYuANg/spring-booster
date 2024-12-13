/* (C)2024*/
package org.spring.boost.office.factory;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.apache.commons.pool2.PooledObject;
import org.apache.commons.pool2.impl.DefaultPooledObject;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;
import org.spring.boost.office.configurations.ExcelConfig;

@RequiredArgsConstructor
@Slf4j
public class SXSSFWorkbookObjectFactory extends WorkbookObjectFactory<SXSSFWorkbook> {

    private final ExcelConfig excelConfig;

    @Override
    public PooledObject<SXSSFWorkbook> makeObject() {
        val workbook = new SXSSFWorkbook(excelConfig.getSXSSFSlidingWindow());
        workbook.setCompressTempFiles(excelConfig.getSXSSFCompression());
        workbook.setZip64Mode(excelConfig.getSXSSFZipMode());
        return new DefaultPooledObject<>(workbook);
    }
}
