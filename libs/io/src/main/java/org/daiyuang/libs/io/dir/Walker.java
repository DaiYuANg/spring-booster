package org.daiyuang.libs.io.dir;

import jdk.jfr.Experimental;
import lombok.SneakyThrows;
import lombok.experimental.UtilityClass;
import lombok.extern.slf4j.Slf4j;
import org.daiyuang.thready.async.AsyncWork;

import java.io.File;
import java.util.Arrays;
import java.util.Objects;
import java.util.function.Consumer;

@Experimental
@UtilityClass
@Slf4j
public class Walker {
    AsyncWork asyncWork = new AsyncWork();

    public static void main(String[] args) {
        walk("/Users/daiyuang/Projects/Aquarius", file -> {
            log.info(file.getAbsolutePath());
        });
    }

    @SneakyThrows
    public static void walk(File directory, Consumer<File> consumer) {
        if (Objects.isNull(directory)) throw new NullPointerException("File is null, check your file object?");
        if (!directory.isDirectory())
            throw new RuntimeException("Path is not a directory, if not a directory how can I walk through");
        var fileList = Objects.requireNonNull(directory.listFiles());
        Arrays.stream(fileList).forEach(r -> {
            if (Objects.nonNull(r.listFiles()) && Objects.requireNonNull(r.listFiles()).length > 0)
                asyncWork.run(() -> justWalk(r, consumer));
        });
    }

    private void justWalk(File path, Consumer<File> consumer) {
        Arrays.stream(Objects.requireNonNull(path.listFiles())).forEach(r -> {
            if (r.isDirectory()) asyncWork.run(() -> justWalk(r, consumer));
            if (r.canRead()) consumer.accept(r);
        });
    }

    public static void walk(String path, Consumer<File> consumer) {
        walk(new File(path), consumer);
    }

    //    todo make concurrent with thread
    public static void concurrentWalk(String path, Consumer<File> consumer) {
//        walk(path);
    }
}
