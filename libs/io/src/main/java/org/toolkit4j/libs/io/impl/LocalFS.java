package org.toolkit4j.libs.io.impl;

import com.google.common.io.Files;
import lombok.NoArgsConstructor;
import lombok.SneakyThrows;
import lombok.val;
import org.jetbrains.annotations.NotNull;
import org.toolkit4j.libs.io.base.AbstractFS;
import org.toolkit4j.libs.io.base.Dir;
import org.toolkit4j.libs.io.constant.FS;

import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.nio.file.Path;

@NoArgsConstructor
public class LocalFS extends AbstractFS implements FS {
    public LocalFS(String basePath) {
        super(basePath);
    }

    @SneakyThrows
    @Override
    public File touch(String path) {
        val absolutePath = concatBasePath(path);
        val parentDir = absolutePath.getParent();
        if (!parentDir.toFile().exists() && !parentDir.toFile().mkdirs()) throw new IOException();
        val finalFile = absolutePath.toFile();
        if (!finalFile.exists()) Files.touch(finalFile);
        return finalFile;
    }

    @Override
    public File touch(@NotNull Path path) {
        return touch(path.toString());
    }

    @Override
    public File touch(@NotNull URI uri) {
        return touch(uri.getPath());
    }

    @Override
    public Dir mkdir(String path, boolean r) {
        val f = concatBasePath(path).toFile();
        if (f.exists() && f.isDirectory()) return new Dir(f);
        val mkdir = r ? f.mkdirs() : f.mkdir();
        if (mkdir) return new Dir(f);
        return null;
    }

    @Override
    public Dir mkdir(String path) {
        return mkdir(path, true);
    }

    @Override
    public Dir mkdir(@NotNull Path path) {
        return mkdir(path.toString());
    }

    @Override
    public Dir mkdir(@NotNull URI uri) {
        return mkdir(uri.getPath());
    }

    @Override
    public File find(String filename) {
        return null;
    }
}
