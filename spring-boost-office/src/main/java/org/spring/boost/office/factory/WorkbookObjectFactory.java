package org.spring.boost.office.factory;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.pool2.PooledObject;
import org.apache.commons.pool2.PooledObjectFactory;
import org.apache.poi.ss.usermodel.Workbook;
import org.jetbrains.annotations.NotNull;

@Slf4j
public abstract class WorkbookObjectFactory<T extends Workbook> implements PooledObjectFactory<T> {

    @Override
    public void activateObject(PooledObject<T> pooledObject) throws Exception {

    }

    @Override
    public void destroyObject(@NotNull PooledObject<T> pooledObject) throws Exception {
        pooledObject.getObject().close();
    }

    @Override
    public void passivateObject(@NotNull PooledObject<T> pooledObject) {
        for (int i = 0; i < pooledObject.getObject().getNumberOfSheets(); i++) {
            pooledObject.getObject().removeSheetAt(i);
        }
    }

    @Override
    public boolean validateObject(@NotNull PooledObject<T> pooledObject) {
        return pooledObject.getObject().getNumberOfSheets() == 0;
    }
}
