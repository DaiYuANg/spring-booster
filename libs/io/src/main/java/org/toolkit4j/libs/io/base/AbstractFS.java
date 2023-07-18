package org.toolkit4j.libs.io.base;

import lombok.NoArgsConstructor;
import org.jetbrains.annotations.NotNull;

import java.nio.file.FileSystem;
import java.nio.file.Path;

@NoArgsConstructor
public abstract class AbstractFS extends FileSystem {
	protected String basePath = System.getProperty("java.io.tmpdir");

	public AbstractFS(String basePath) {
		this.basePath = basePath;
	}

	protected Path concatBasePath(String path) {
		return concatBasePath(Path.of(path));
	}

	protected Path concatBasePath(@NotNull Path path) {
		return Path.of(basePath, path.normalize().toString());
	}
}
