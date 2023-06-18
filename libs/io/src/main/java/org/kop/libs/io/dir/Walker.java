package org.kop.libs.io.dir;

import jdk.jfr.Experimental;
import lombok.Builder;
import lombok.SneakyThrows;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;
import org.jetbrains.annotations.NotNull;

import java.io.File;
import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.FileVisitor;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.Objects;
import java.util.function.BiFunction;
import java.util.function.Consumer;

@Experimental
@Slf4j
@Builder
@ToString
public class Walker {

    @SneakyThrows
    public void walk(String path,
                     BiFunction<Path, BasicFileAttributes, FileVisitResult> consumer,
                     BiFunction<Path, IOException, FileVisitResult> onFailed) {
        if (Objects.isNull(path)) throw new NullPointerException("File is null, check your file object?");
        var directory = Path.of(path);
        if (!Files.isDirectory(directory))
            throw new RuntimeException("Path is not a directory, if not a directory how can I walk through");

        Files.walkFileTree(directory, new FileVisitor<>() {
            @Override
            public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) {
                return consumer.apply(dir, attrs);
            }

            @Override
            public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) {
                return consumer.apply(file, attrs);
            }

            @Override
            public FileVisitResult visitFileFailed(Path file, IOException exc) {
                return onFailed.apply(file, exc);
            }

            @Override
            public FileVisitResult postVisitDirectory(Path dir, IOException exc) {
                return onFailed.apply(dir, exc);
            }
        });
    }

    public void walk(@NotNull File path,
                     BiFunction<Path, BasicFileAttributes, FileVisitResult> consumer,
                     BiFunction<Path, IOException, FileVisitResult> onFailed) {
        walk(path.toPath().toString(), consumer, onFailed);
    }

    public void walk(@NotNull Path path, BiFunction<Path, BasicFileAttributes, FileVisitResult> consumer) {
        walk(path.toString(), consumer, (path1, e) -> {
            if (Objects.nonNull(e)) return FileVisitResult.TERMINATE;
            return FileVisitResult.CONTINUE;
        });
    }

    //    todo make concurrent with thread
    public void concurrentWalk(String path, Consumer<Path> consumer) {
//        walk(path);

    }

    public static void main(String[] args) {
        System.err.println(123);
    }
}
