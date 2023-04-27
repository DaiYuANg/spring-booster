package org.daiyuang.libs.io.dir;

import jdk.jfr.Experimental;
import lombok.SneakyThrows;
import lombok.experimental.UtilityClass;
import lombok.extern.slf4j.Slf4j;
import org.daiyuang.thready.pool.PoolCreator;

import java.io.File;
import java.util.Arrays;
import java.util.Objects;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.function.Consumer;

@Experimental
@UtilityClass
@Slf4j
public class Walker {
    @SneakyThrows
    public static void walk(File directory, Consumer<File> consumer) {
        if (Objects.isNull(directory)) throw new NullPointerException("File is null, check your file object?");
        if (!directory.isDirectory())
            throw new RuntimeException("Path is not a directory, if not a directory how can I walk through");
//       todo: do we need parallel?
        var fileList = Objects.requireNonNull(directory.listFiles());
        ThreadPoolExecutor e = new PoolCreator().creator();
        Arrays.stream(fileList).forEach(r -> e.submit(() -> justWalk(r, consumer)));
        if (e.awaitTermination(fileList.length, TimeUnit.SECONDS)) e.shutdown();
    }

    private void justWalk(File path, Consumer<File> consumer) {
        Arrays.stream(Objects.requireNonNull(path.listFiles())).forEach(r -> {
            if (r.isDirectory()) justWalk(r, consumer);
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
