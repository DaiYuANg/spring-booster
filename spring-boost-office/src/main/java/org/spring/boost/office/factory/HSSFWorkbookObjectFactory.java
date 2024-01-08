/* (C)2024*/
package org.spring.boost.office.factory;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.pool2.PooledObject;
import org.apache.commons.pool2.impl.DefaultPooledObject;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

@Slf4j
public class HSSFWorkbookObjectFactory extends WorkbookObjectFactory<HSSFWorkbook> {

    @Override
    public PooledObject<HSSFWorkbook> makeObject() {
        return new DefaultPooledObject<>(new HSSFWorkbook());
    }
}
