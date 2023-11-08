package org.toolkit.spring.boot.starter.minio.shared.template;

import io.minio.StatObjectResponse;
import lombok.SneakyThrows;

public interface IMinioTemplate {
	@SneakyThrows
	StatObjectResponse stat(String bucket, String object);

	StatObjectResponse stat(String object);

	String getSelfKey();
}
