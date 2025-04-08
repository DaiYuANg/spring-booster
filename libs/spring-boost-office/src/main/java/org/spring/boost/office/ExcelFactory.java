/* (C)2024*/
package org.spring.boost.office;

import java.util.Collection;
import java.util.stream.StreamSupport;

import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.val;
import org.apache.commons.pool2.impl.GenericObjectPool;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

@RequiredArgsConstructor
public class ExcelFactory {

  private final GenericObjectPool<HSSFWorkbook> hssfWorkbookGenericObjectPool;

  private final GenericObjectPool<XSSFWorkbook> xssfWorkbookGenericObjectPool;

  private final GenericObjectPool<SXSSFWorkbook> sxssfWorkbookGenericObjectPool;

  @SneakyThrows
  public void write(String title, Collection<Object> entityData, Class<?> entityClass) {
    val s = hssfWorkbookGenericObjectPool.borrowObject().createSheet();
    StreamSupport.stream(s.spliterator(), false).forEach(s::removeRow);
  }
}
