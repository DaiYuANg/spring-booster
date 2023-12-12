/* (C)2023*/
package org.toolkit.minio;

import io.minio.*;
import io.minio.errors.ErrorResponseException;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.InputStream;
import java.nio.file.Path;
import java.util.Optional;
import lombok.*;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;
import org.apache.tika.Tika;
import org.jetbrains.annotations.NotNull;
import org.toolkit.minio.exceptions.ObjectNotExistsException;

@Getter
@Builder
public class MinioTemplate {

	@Builder.Default
	private String defaultContentType = "application/octet-stream";

	@NonNull private final MinioClient client;

	@NonNull private final String defaultBucket;

	@NonNull @Builder.Default
	private final Tika tika = new Tika();

	@SneakyThrows
	public void upload(File file, String targetName, String bucketName, String contentType) {
		upload(FileUtils.readFileToByteArray(file), targetName, bucketName, contentType);
	}

	@SneakyThrows
	public void upload(File file, String targetName) {
		val contentType = tika.detect(file);
		upload(file, targetName, defaultBucket, contentType);
	}

	//	@SneakyThrows
	//	public void upload(@NotNull MultipartFile multipartFile, String targetName, String bucketName, String
	// contentType) {
	//		upload(multipartFile.getResource().getFile(), targetName, bucketName, contentType);
	//	}
	//
	//	public void upload(MultipartFile multipartFile, String targetName, String contentType) {
	//		upload(multipartFile, targetName, defaultBucket, contentType);
	//	}

	public void upload(File file, String targetName, String contentType) {
		upload(file, targetName, defaultBucket, contentType);
	}

	@SneakyThrows
	public void upload(@NotNull Path path, String targetName, String bucketName, String contentType) {
		upload(path.toFile(), targetName, bucketName, contentType);
	}

	@SneakyThrows
	public void upload(byte[] fileBytes, String targetName, String bucketName, String contentType) {
		if (objectExists(targetName, bucketName)) return;
		createBucket(bucketName);
		@Cleanup val inputStream = new ByteArrayInputStream(fileBytes);
		PutObjectArgs putObjectArgs = PutObjectArgs.builder().bucket(bucketName).object(targetName).stream(
						inputStream, inputStream.available(), -1)
				.contentType(contentTypeWithpublic(contentType))
				.build();
		client.putObject(putObjectArgs);
	}

	public void upload(byte[] fileBytes, String targetName, String contentType) {
		upload(fileBytes, defaultBucket, targetName, contentType);
	}

	private String contentTypeWithpublic(String contentType) {
		return Optional.ofNullable(contentType).orElse(defaultContentType);
	}

	@SneakyThrows
	public InputStream getObject(String object) {
		return getObject(defaultBucket, object);
	}

	@SneakyThrows
	public InputStream getObject(String bucket, String object) {
		if (objectExists(object)) {
			throw new ObjectNotExistsException(object);
		}
		client.composeObject(ComposeObjectArgs.builder().build());
		return client.getObject(
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
		client.downloadObject(DownloadObjectArgs.builder()
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
		val arg = StatObjectArgs.builder().bucket(bucket).object(object).build();
		return client.statObject(arg);
	}

	public StatObjectResponse stat(String object) {
		return stat(defaultBucket, object);
	}

	@SneakyThrows
	public boolean objectExists(String bucket, String object) {
		try {
			client.statObject(
					StatObjectArgs.builder().bucket(bucket).object(object).build());
			return true;
		} catch (ErrorResponseException e) {
			return false;
		}
	}

	public boolean objectExists(String object) {
		return objectExists(defaultBucket, object);
	}

	@SneakyThrows
	public void createBucket(String bucket) {
		val existsArg = BucketExistsArgs.builder().bucket(bucket).build();
		if (client.bucketExists(existsArg)) {
			return;
		}
		client.makeBucket(MakeBucketArgs.builder().bucket(bucket).build());
	}
}
