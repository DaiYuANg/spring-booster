package org.daiyuang.libs.io.dir;

import jdk.jfr.Experimental;
import lombok.experimental.UtilityClass;
import lombok.extern.slf4j.Slf4j;
import org.daiyuang.thready.async.AsyncWork;

import java.io.File;
import java.util.Arrays;
import java.util.function.Consumer;

@Experimental
@UtilityClass
@Slf4j
public class Walker {
    private final AsyncWork asyncWork = new AsyncWork();

    public static void main(String[] args) {
        walk(".", file -> {
            log.info(file.getAbsolutePath());
        });
    }

    public static void walk(File directory, Consumer<File> consumer) {
        if (!directory.isDirectory()) throw new RuntimeException("path is not a directory");
        var listFile = directory.listFiles();
        if (listFile != null && listFile.length == 0) return;
        if (listFile == null) return;
        //            if (log.isInfoEnabled()) log.info(r.getAbsolutePath());
        Arrays.stream(listFile).forEach(r -> {
            if (r.isDirectory()) asyncWork.run(() -> walk(r, consumer));
            consumer.accept(r);
        });
    }

    public static void walk(String path, Consumer<File> consumer) {
        walk(new File(path), consumer);
    }
}
