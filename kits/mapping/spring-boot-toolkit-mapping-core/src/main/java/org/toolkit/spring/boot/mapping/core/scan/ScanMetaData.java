package org.toolkit.spring.boot.mapping.core.scan;

import com.google.gson.Gson;
import io.github.classgraph.ClassInfo;
import io.github.classgraph.ScanResult;
import jakarta.annotation.Resource;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.apache.commons.io.IOUtils;
import org.apache.commons.io.output.ByteArrayOutputStream;
import org.apache.commons.io.output.CloseShieldOutputStream;
import org.apache.commons.io.output.TeeOutputStream;
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Component;
import org.toolkit.spring.boot.mapping.core.annotations.MappedObject;
import org.toolkit.spring.boot.scanner.base.ScannerResultProcessor;
import org.toolkit.spring.boot.utils.bean.BeanUtil;

import java.io.File;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

@Component
@Slf4j
public class ScanMetaData implements ScannerResultProcessor {

    @Resource
    private BeanUtil beanUtil;
    @SneakyThrows
    private void serialToFile(@NotNull ClassInfo classInfo) {
        System.err.println(classInfo.getFieldInfo());

//        val tempFile = File.createTempFile(classInfo.getPackageName() + "." + classInfo.getName(), ".ser");
//        // 将对象序列化到字节数组
//        ByteArrayOutputStream byteOutputStream = new ByteArrayOutputStream();
//        val objectOutputStream = new ObjectOutputStream(new CloseShieldOutputStream(
//                new TeeOutputStream(byteOutputStream, new FileOutputStream(tempFile))));
//        objectOutputStream.writeObject(classInfo);
//        IOUtils.write(byteOutputStream.toByteArray(), new FileOutputStream(tempFile));
//        log.atDebug().log("write to file:{}",tempFile.getAbsolutePath());
    }

    @Override
    public void process(@NotNull ScanResult result) {
        log.atInfo().log("mapping scan meta data");
        result.getClassesWithAnnotation(MappedObject.class).parallelStream().forEach(this::serialToFile);
    }
}
