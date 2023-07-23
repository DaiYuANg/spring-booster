package org.toolkit4J.lis.office.excel.processor;

import lombok.val;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.IOException;
import java.io.OutputStream;

public class ExcelProcessor {
    public void createExcel(OutputStream outputStream) throws IOException {
        try (val workbook = new XSSFWorkbook()) {
//            workbook.
            val sheet = workbook.createSheet();
            val row = sheet.createRow(1);
            val cell = row.createCell(1);
            cell.setCellValue("test");
        }
    }
}
