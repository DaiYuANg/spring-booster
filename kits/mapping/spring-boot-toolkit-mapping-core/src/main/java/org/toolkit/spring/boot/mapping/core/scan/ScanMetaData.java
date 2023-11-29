package org.toolkit.spring.boot.mapping.core.scan;

import io.github.classgraph.ScanResult;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Component;
import org.toolkit.spring.boot.mapping.core.annotations.MappedObject;
import org.toolkit.spring.boot.scanner.base.ScannerResultProcessor;
import org.toolkit.spring.boot.utils.bean.BeanUtil;

import java.util.stream.Collectors;

@Component
@Slf4j
public class ScanMetaData implements ScannerResultProcessor {

    @Resource
    private BeanUtil beanUtil;

    @Override
    public void process(@NotNull ScanResult result) {
        log.atInfo().log("mapping scan meta data");
        val index = result.getClassesWithAnnotation(MappedObject.class).stream()
                .collect(Collectors.toConcurrentMap(classInfo -> classInfo.getPackageName() + "." + classInfo.getName(), c -> c));
        System.err.println(index);
//        beanUtil.putAsSingleton("index", index);
    }
}
