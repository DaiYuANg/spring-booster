package org.kop.libs.io.files

import lombok.SneakyThrows
import java.io.File
import java.io.IOException
import java.nio.file.FileVisitResult
import java.nio.file.FileVisitor
import java.nio.file.Files
import java.nio.file.Path
import java.nio.file.attribute.BasicFileAttributes
import java.util.*
import java.util.function.BiFunction
import java.util.function.Consumer


@SneakyThrows
fun walk(
    path: String?,
    consumer: BiFunction<Path?, BasicFileAttributes?, FileVisitResult>,
    onFailed: BiFunction<Path?, IOException?, FileVisitResult>
) {
    if (Objects.isNull(path)) throw NullPointerException("File is null, check your file object?")
    val directory = Path.of(path)
    if (!Files.isDirectory(directory)) throw RuntimeException("Path is not a directory, if not a directory how can I walk through")
    Files.walkFileTree(directory, object : FileVisitor<Path?> {
        override fun preVisitDirectory(dir: Path?, attrs: BasicFileAttributes): FileVisitResult {
            return consumer.apply(dir, attrs)
        }

        override fun visitFile(file: Path?, attrs: BasicFileAttributes): FileVisitResult {
            return consumer.apply(file, attrs)
        }

        override fun visitFileFailed(file: Path?, exc: IOException): FileVisitResult {
            return onFailed.apply(file, exc)
        }

        override fun postVisitDirectory(dir: Path?, exc: IOException): FileVisitResult {
            return onFailed.apply(dir, exc)
        }
    })
}

fun walk(
    path: File,
    consumer: BiFunction<Path?, BasicFileAttributes?, FileVisitResult>,
    onFailed: BiFunction<Path?, IOException?, FileVisitResult>
) {
    walk(path.toPath().toString(), consumer, onFailed)
}

fun walk(path: Path, consumer: BiFunction<Path?, BasicFileAttributes?, FileVisitResult>) {
    walk(path.toString(), consumer) { _: Path?, e: IOException? ->
        if (Objects.nonNull(e)) return@walk FileVisitResult.TERMINATE
        FileVisitResult.CONTINUE
    }
}

//    todo make concurrent with thread
fun concurrentWalk(path: String?, consumer: Consumer<Path?>?) {
//        walk(path);
}
