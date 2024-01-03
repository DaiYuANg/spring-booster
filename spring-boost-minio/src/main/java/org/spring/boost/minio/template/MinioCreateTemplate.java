/* (C)2024*/
package org.spring.boost.minio.template;

import io.minio.ObjectWriteResponse;
import io.minio.PutObjectArgs;
import io.minio.messages.Tags;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Map;
import java.util.Objects;
import lombok.NonNull;
import lombok.SneakyThrows;
import lombok.ToString;
import lombok.experimental.SuperBuilder;
import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.jetbrains.annotations.NotNull;
import org.springframework.util.DigestUtils;
import org.springframework.web.multipart.MultipartFile;

@SuperBuilder
@ToString
@Slf4j
public class MinioCreateTemplate extends MinioTemplate {

	@SneakyThrows
	public ObjectWriteResponse createObject(
			@NotNull InputStream inputStream,
			@NonNull String bucket,
			@NonNull String contentType,
			@NonNull String name,
			Map<String, String> tags) {
		if (checkDuplicate && inputStream.markSupported()) {
			inputStream.mark(-1);
			val md5 = DigestUtils.md5DigestAsHex(inputStream);
			tags.put("md5", md5);

			inputStream.reset();
		}
		val argBuilder = PutObjectArgs.builder().stream(inputStream, inputStream.available(), -1)
				.contentType(contentType)
				.bucket(bucket)
				.object(name);
		if (Objects.nonNull(tags)) {
			argBuilder.tags(tags);
		}
		val arg = argBuilder.build();
		hooks.forEach(hook -> hook.beforeCreate(arg, bucket, name, contentType, tags));
		try {
			val result = client.putObject(arg);
			hooks.forEach(hook -> hook.afterCreateSuccess(result));
			return result;
		} catch (Exception e) {
			hooks.forEach(hook -> hook.afterCreateFailure(bucket, name, contentType, tags, e));
			throw e;
		}
	}

	public ObjectWriteResponse createObject(
			InputStream stream, String contentType, String name, Map<String, String> tags) {
		return createObject(stream, bucket, contentType, name, tags);
	}

	@SneakyThrows
	public ObjectWriteResponse createObject(InputStream stream, String name, Map<String, String> tags) {
		val contentType = tika.detect(stream);
		stream.reset();
		return createObject(stream, bucket, contentType, name, tags);
	}

	public ObjectWriteResponse createObject(
			byte[] data, String bucket, String contentType, String name, Map<String, String> tags) {
		val inputStream = new ByteArrayInputStream(data);
		return createObject(inputStream, bucket, contentType, name, tags);
	}

	public ObjectWriteResponse createObject(
			byte[] data, String bucket, String contentType, String name, @NotNull Tags tags) {
		return createObject(data, bucket, contentType, name, tags.get());
	}

	public ObjectWriteResponse createObject(byte[] data, String bucket, String name, @NotNull Tags tags) {
		val contentType = tika.detect(data);
		return createObject(data, bucket, contentType, name, tags);
	}

	public ObjectWriteResponse createObject(byte[] data, String name, @NotNull Tags tags) {
		val contentType = tika.detect(data);
		return createObject(data, bucket, contentType, name, tags);
	}

	public ObjectWriteResponse createObject(byte[] data, String name) {
		return createObject(data, name, new Tags());
	}

	@SneakyThrows
	public ObjectWriteResponse createObject(
			@NotNull MultipartFile file, String bucket, String contentType, String name, Map<String, String> tags) {
		return createObject(file.getInputStream(), bucket, contentType, name, tags);
	}

	@SneakyThrows
	public ObjectWriteResponse createObject(
			@NotNull MultipartFile file, String contentType, String name, Map<String, String> tags) {
		return createObject(file.getInputStream(), bucket, contentType, name, tags);
	}

	@SneakyThrows
	public ObjectWriteResponse createObject(@NotNull MultipartFile file, String name, Map<String, String> tags) {
		val inputStream = file.getInputStream();
		val contentType = tika.detect(inputStream);
		inputStream.reset();
		return createObject(file.getInputStream(), bucket, contentType, name, tags);
	}

	@SneakyThrows
	public ObjectWriteResponse createObject(@NotNull MultipartFile file, String name) {
		val inputStream = file.getInputStream();
		val contentType = tika.detect(inputStream);
		inputStream.reset();
		return createObject(file.getInputStream(), bucket, contentType, name, null);
	}

	@SneakyThrows
	public ObjectWriteResponse createObject(
			@NotNull File file, String contentType, String name, Map<String, String> tags) {
		val fis = new FileInputStream(file);
		return createObject(fis, bucket, contentType, name, tags);
	}

	@SneakyThrows
	public ObjectWriteResponse createObject(@NotNull File file, String name, Map<String, String> tags) {
		val fis = new FileInputStream(file);
		val contentType = tika.detect(fis);
		fis.reset();
		return createObject(fis, bucket, contentType, name, tags);
	}

	@SneakyThrows
	public ObjectWriteResponse createObject(@NotNull File file, String name) {
		val fis = new FileInputStream(file);
		val contentType = tika.detect(fis);
		fis.reset();
		return createObject(fis, bucket, contentType, name, null);
	}
}
