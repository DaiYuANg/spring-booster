/* (C)2024*/
package org.spring.boost.office.processor;

import io.github.classgraph.ScanResult;
import lombok.val;
import org.jetbrains.annotations.NotNull;
import org.spring.boost.core.api.FeatureInstaller;
import org.spring.boost.office.annotation.ExcelObject;

public class ExcelObjectProcessor implements FeatureInstaller<ScanResult> {

    @Override
    public void install(@NotNull ScanResult scanResult) {
        val excelObjects = scanResult.getClassesWithAnnotation(ExcelObject.class);
    }
}
