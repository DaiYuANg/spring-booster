package org.toolkit.spring.boot.starter.minio.service;

import java.util.function.Supplier;
import org.jetbrains.annotations.NotNull;
import org.toolkit.spring.boot.starter.minio.params.Base64UploadParam;
import org.toolkit.spring.boot.starter.minio.params.UploadParams;
import org.toolkit.spring.boot.starter.minio.vo.UploadResultVo;

public interface IMinioUploadService {
	UploadResultVo checkMd5OrUpload(String md5, Supplier<String> md5NotExistsSupplier);

	@NotNull UploadResultVo upload(@NotNull UploadParams arguments);

	UploadResultVo upload(@NotNull Base64UploadParam base64UploadParam);
}
