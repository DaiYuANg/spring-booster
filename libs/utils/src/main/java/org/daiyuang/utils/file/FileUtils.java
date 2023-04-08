package org.daiyuang.utils.file;

import jdk.jfr.Experimental;
import lombok.experimental.UtilityClass;
import lombok.extern.slf4j.Slf4j;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Experimental
@UtilityClass
@Slf4j
public final class FileUtils {

    public static List<File> walk(File directory) {
        if (!directory.isDirectory()) throw new RuntimeException("path is not a directory");
        var result = new ArrayList<File>();
        var listFile = directory.listFiles();
        if (listFile != null && listFile.length == 0) return result;
        if (listFile != null) {
            Arrays.stream(listFile).parallel().forEach(r -> {
                log.info(r.getAbsolutePath());
                result.add(r);
                if (r.isDirectory()) {
                    walk(r);
                }
            });
        }
        return result;
    }

    public static void walk(String path) {
        walk(new File(path));
    }
}
