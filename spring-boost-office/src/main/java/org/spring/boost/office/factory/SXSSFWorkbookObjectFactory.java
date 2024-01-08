package org.spring.boost.office.factory;

import org.apache.commons.pool2.PooledObject;
import org.apache.commons.pool2.impl.DefaultPooledObject;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;

public class SXSSFWorkbookObjectFactory extends WorkbookObjectFactory<SXSSFWorkbook> {
    @Override
    public PooledObject<SXSSFWorkbook> makeObject() {
        return new DefaultPooledObject<>(new SXSSFWorkbook());
    }
}
