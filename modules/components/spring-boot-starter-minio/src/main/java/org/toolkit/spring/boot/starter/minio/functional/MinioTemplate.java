package org.toolkit.spring.boot.starter.minio.functional;

import io.minio.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.nio.file.Path;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.jetbrains.annotations.NotNull;
import org.springframework.web.multipart.MultipartFile;

@Slf4j
public class MinioTemplate implements IMinioTemplate {

	private final MinioClient minioClient;

	public MinioTemplate(@NotNull MinioClient minioClient) {
		this.minioClient = minioClient;
	}

	@SneakyThrows
	@Override
	public String upload(@NotNull MultipartFile multipartFile, String bucket) {
		return upload(multipartFile.getResource().getFile(), bucket);
	}

	@SneakyThrows
	@Override
	public String upload(@NotNull Path path, String bucket) {
		val file = path.toFile();
		if (!file.exists()) throw new FileNotFoundException();
		return upload(file, bucket);
	}

	@SneakyThrows
	@Override
	public String upload(String path, String bucket) {
		return upload(Path.of(path), bucket);
	}

	@SneakyThrows
	@Override
	public String upload(File file, String bucket) {
		autoCreateBucket(bucket);
		try (val stream = new FileInputStream(file)) {
			val up = PutObjectArgs.builder().stream(stream, stream.available(), -1)
					.build();
			val r = minioClient.putObject(up);
			return r.bucket();
		}
	}

	@SneakyThrows
	@Override
	public void autoCreateBucket(String bucket) {
		if (minioClient.bucketExists(BucketExistsArgs.builder().bucket(bucket).build())) return;
		minioClient.makeBucket(MakeBucketArgs.builder().bucket(bucket).build());
	}

	@SneakyThrows
	@Override
	public InputStream getObject(String object) {
		return minioClient.getObject(GetObjectArgs.builder().object(object).build());
	}

	@SneakyThrows
	@Override
	public File download(String object, String targetPath, String bucket) {
		minioClient.downloadObject(
				DownloadObjectArgs.builder().bucket(bucket).filename(targetPath).build());
		return new File(targetPath);
	}
}
