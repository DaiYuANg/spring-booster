/* (C)2024*/
package org.spring.boost.office.excel;

import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.concurrent.atomic.AtomicInteger;

import lombok.*;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.compress.archivers.zip.Zip64Mode;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;
import org.jetbrains.annotations.NotNull;
import org.spring.boost.office.annotation.ExcelRow;
import org.springframework.util.ReflectionUtils;

@Builder
@Slf4j
@ToString
@Getter
public class Workbook<T> {
  private final String title;

  @Builder.Default
  private final SXSSFWorkbook workbook = new SXSSFWorkbook(-1);

  private final Class<T> entityClass;

  private final Collection<T> entityData;

  @Builder.Default
  private final ReflectionUtils.FieldFilter fieldFilter = r -> r.isAnnotationPresent(ExcelRow.class);

  @SneakyThrows
  public OutputStream generateExcel() {
    val output = new BufferedOutputStream(new ByteArrayOutputStream());
    @Cleanup val workbook = new SXSSFWorkbook(-1);
    val sheet = workbook.createSheet("Sheet1");
    workbook.setCompressTempFiles(true);
    workbook.setZip64Mode(Zip64Mode.AsNeeded);
    val headers = new ArrayList<String>();
    ReflectionUtils.doWithFields(
      entityClass,
      field -> {
        val row = field.getAnnotation(ExcelRow.class);
        headers.add(row.title());
      },
      fieldFilter);
    val headerExcelRow = sheet.createRow(0);
    headers.forEach(headerText -> createCell(headerExcelRow, headers.indexOf(headerText), headerText));
    entityData.forEach(dataEntity -> {
      val dataRow = sheet.createRow(sheet.getPhysicalNumberOfRows());
      val cellIndex = new AtomicInteger(); // 假设单元格索引从0开始
      val dataCell = dataRow.createCell(cellIndex.getAndIncrement());
      ReflectionUtils.doWithFields(
        dataEntity.getClass(),
        field -> {
          field.setAccessible(true);
          val a = field.get(dataEntity).toString();
          dataCell.setCellValue(a);
        },
        fieldFilter);
    });
    workbook.write(output);
    return output;
  }

  private void createCell(@NotNull Row row, int cellIndex, String value) {
    Cell cell = row.createCell(cellIndex);
    cell.setCellValue(value);
  }
}
