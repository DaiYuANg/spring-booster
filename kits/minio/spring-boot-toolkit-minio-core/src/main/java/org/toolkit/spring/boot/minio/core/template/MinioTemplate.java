package org.toolkit.spring.boot.minio.core.template;

import io.minio.*;
import io.minio.errors.ErrorResponseException;
import java.io.*;
import java.nio.file.Path;
import java.util.Optional;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;
import org.jetbrains.annotations.NotNull;
import org.springframework.web.multipart.MultipartFile;
import org.toolkit.spring.boot.minio.core.exception.ObjectNotExistsException;

@Slf4j
public record MinioTemplate(MinioClient minioClient, String defaultBucket) {

	private static final String defaultContentType = "application/octet-stream";

	public MinioTemplate(@NotNull MinioClient minioClient, String defaultBucket) {
		this.minioClient = minioClient;
		this.defaultBucket = defaultBucket;
		autoCreateBucket(defaultBucket);
	}

	@SneakyThrows
	public void upload(File file, String targetName, String bucketName, String contentType) {
		upload(FileUtils.readFileToByteArray(file), targetName, bucketName, contentType);
	}

	@SneakyThrows
	public void upload(@NotNull MultipartFile multipartFile, String targetName, String bucketName, String contentType) {
		upload(multipartFile.getResource().getFile(), targetName, bucketName, contentType);
	}

	public void upload(MultipartFile multipartFile, String targetName, String contentType) {
		upload(multipartFile, targetName, defaultBucket, contentType);
	}

	public void upload(File file, String targetName, String contentType) {
		upload(file, targetName, defaultBucket, contentType);
	}

	@SneakyThrows
	public void upload(@NotNull Path path, String targetName, String bucketName, String contentType) {
		upload(path.toFile(), targetName, bucketName, contentType);
	}

	@SneakyThrows
	public void upload(byte[] fileBytes, String bucketName, String targetName, String contentType) {
		autoCreateBucket(bucketName);
		try (ByteArrayInputStream inputStream = new ByteArrayInputStream(fileBytes)) {
			PutObjectArgs putObjectArgs = PutObjectArgs.builder().bucket(bucketName).object(targetName).stream(
							inputStream, inputStream.available(), -1)
					.contentType(contentTypeWithDefault(contentType))
					.build();
			minioClient.putObject(putObjectArgs);
		}
	}

	public void upload(byte[] fileBytes, String targetName, String contentType) {
		upload(fileBytes, defaultBucket, targetName, contentType);
	}

	private String contentTypeWithDefault(String contentType) {
		return Optional.ofNullable(contentType).orElse(defaultContentType);
	}

	@SneakyThrows
	public void autoCreateBucket(String bucket) {
		if (minioClient.bucketExists(BucketExistsArgs.builder().bucket(bucket).build())) return;
		minioClient.makeBucket(MakeBucketArgs.builder().bucket(bucket).build());
	}

	@SneakyThrows
	public InputStream getObject(String object) {
		return getObject(defaultBucket, object);
	}

	@SneakyThrows
	public InputStream getObject(String bucket, String object) {
		objectExists(object);
		minioClient.composeObject(ComposeObjectArgs.builder().build());
		return minioClient.getObject(
				GetObjectArgs.builder().bucket(bucket).object(object).build());
	}

	@SneakyThrows
	public byte[] getObjectBytes(String bucket, String object) {
		return IOUtils.toByteArray(getObject(bucket, object));
	}

	public byte[] getObjectBytes(String object) {
		return getObjectBytes(defaultBucket, object);
	}

	@SneakyThrows
	public void downloadAsFile(String object, String bucketName, String filename) {
		minioClient.downloadObject(DownloadObjectArgs.builder()
				.object(object)
				.bucket(bucketName)
				.filename(filename)
				.build());
	}

	public void downloadAsFile(String object, String filename) {
		downloadAsFile(object, defaultBucket, filename);
	}

	@SneakyThrows
	public StatObjectResponse stat(String bucket, String object) {
		return minioClient.statObject(StatObjectArgs.builder().build());
	}

	public StatObjectResponse stat(String object) {
		return stat(defaultBucket, object);
	}

	@SneakyThrows
	public void objectExists(String bucket, String object) {
		try {
			minioClient.statObject(
					StatObjectArgs.builder().bucket(bucket).object(object).build());
		} catch (ErrorResponseException e) {
			log.atDebug().log("object not exists");
			throw new ObjectNotExistsException(bucket, object);
		}
	}

	public void objectExists(String object) {
		objectExists(defaultBucket, object);
	}
}
