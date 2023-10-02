package org.toolkit.spring.boot.starter.minio.functional;

import java.io.File;
import java.io.InputStream;
import java.nio.file.Path;
import lombok.SneakyThrows;
import org.jetbrains.annotations.NotNull;
import org.springframework.web.multipart.MultipartFile;

public interface IMinioTemplate {
	String upload(@NotNull MultipartFile multipartFile, String bucket);

	String upload(@NotNull Path path, String bucket);

	String upload(String path, String bucket);

	String upload(File file, String bucket);

	void autoCreateBucket(String bucket);

	InputStream getObject(String object);

	File download(String object, String targetPath, String bucket);
}
