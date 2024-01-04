/* (C)2023*/
package org.toolkit.spring.boot.mapping.core.scan;

import io.github.classgraph.ScanResult;
import java.util.stream.Collectors;
import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.jetbrains.annotations.NotNull;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.stereotype.Component;
import org.toolkit.spring.boot.mapping.base.annotation.MappedObject;
import org.toolkit.spring.boot.scanner.base.ScannerResultProcessor;

@Component
@Slf4j
public class ScanObjectMetaData implements ScannerResultProcessor {

    @Override
    public void process(@NotNull ScanResult result, ConfigurableApplicationContext context) {
        log.atInfo().log("mapping scan meta data");
        val index = result.getClassesWithAnnotation(MappedObject.class).stream()
                .collect(Collectors.toMap(classInfo -> classInfo.getPackageName() + "." + classInfo.getName(), c -> c));
        //		log.atDebug().log("At index:{}", index);
    }
}
