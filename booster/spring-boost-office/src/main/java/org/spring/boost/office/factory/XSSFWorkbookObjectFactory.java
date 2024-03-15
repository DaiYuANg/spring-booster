/* (C)2024*/
package org.spring.boost.office.factory;

import org.apache.commons.pool2.PooledObject;
import org.apache.commons.pool2.impl.DefaultPooledObject;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class XSSFWorkbookObjectFactory extends WorkbookObjectFactory<XSSFWorkbook> {

    @Override
    public PooledObject<XSSFWorkbook> makeObject() {
        return new DefaultPooledObject<>(new XSSFWorkbook());
    }
}
