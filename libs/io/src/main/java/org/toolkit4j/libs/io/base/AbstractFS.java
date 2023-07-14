package org.toolkit4j.libs.io.base;

import java.nio.file.Path;
import lombok.NoArgsConstructor;
import org.jetbrains.annotations.NotNull;

@NoArgsConstructor
public abstract class AbstractFS {
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
