package org.spring.boost.office;

import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.apache.commons.pool2.impl.GenericObjectPool;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.util.Collection;

@RequiredArgsConstructor
public class ExcelFactory {

    private final GenericObjectPool<HSSFWorkbook> hssfWorkbookGenericObjectPool;

    private final GenericObjectPool<XSSFWorkbook> xssfWorkbookGenericObjectPool;

    private final GenericObjectPool<SXSSFWorkbook> sxssfWorkbookGenericObjectPool;

    @SneakyThrows
    public void write(String title, Collection<Object> entityData, Class<?> entityClass) {
    }
}
