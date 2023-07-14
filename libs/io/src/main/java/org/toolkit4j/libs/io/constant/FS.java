package org.toolkit4j.libs.io.constant;

import java.io.File;
import java.net.URI;
import java.nio.file.Path;
import org.toolkit4j.libs.io.base.Dir;

public interface FS {
	File touch(String path);

	File touch(Path path);

	File touch(URI uri);

	Dir mkdir(String path);

	Dir mkdir(String path, boolean r);

	Dir mkdir(Path path);

	Dir mkdir(URI uri);

	File find(String filename);
}
