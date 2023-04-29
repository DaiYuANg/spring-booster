package org.daiyuang.libs.io.dir;

import jdk.jfr.Experimental;
import lombok.Builder;
import lombok.SneakyThrows;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;
import org.daiyuang.thready.async.AsyncWork;

import java.io.File;
import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.FileVisitor;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.Arrays;
import java.util.Objects;
import java.util.function.Consumer;

@Experimental
@Slf4j
@Builder
@ToString
public class Walker {
    private AsyncWork asyncWork;

    @SneakyThrows
    public void walk(File directory, Consumer<File> consumer) {
        if (Objects.isNull(directory)) throw new NullPointerException("File is null, check your file object?");
        if (!directory.isDirectory())
            throw new RuntimeException("Path is not a directory, if not a directory how can I walk through");
        var fileList = Objects.requireNonNull(directory.listFiles());
        Files.walkFileTree(directory.toPath(), new FileVisitor<Path>() {
            @Override
            public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException {
                return null;
            }

            @Override
            public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
                return null;
            }

            @Override
            public FileVisitResult visitFileFailed(Path file, IOException exc) throws IOException {
                return null;
            }

            @Override
            public FileVisitResult postVisitDirectory(Path dir, IOException exc) throws IOException {
                return null;
            }
        });
//        Arrays.stream(fileList).parallel().forEach(r -> {
//            if (Objects.nonNull(r.listFiles()) && Objects.requireNonNull(r.listFiles()).length > 0)
//                asyncWork.run(() -> justWalk(r, consumer));
//        });
    }

    private void justWalk(File path, Consumer<File> consumer) {
        Arrays.stream(Objects.requireNonNull(path.listFiles())).forEach(r -> {
            if (r.isDirectory()) asyncWork.run(() -> justWalk(r, consumer));
            if (r.canRead()) consumer.accept(r);
        });
    }

    public void walk(String path, Consumer<File> consumer) {
        walk(new File(path), consumer);
    }

    //    todo make concurrent with thread
    public void concurrentWalk(String path, Consumer<File> consumer) {
//        walk(path);
    }
}
