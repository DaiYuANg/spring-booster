package org.toolkit.spring.boot.starter.minio.checker;

import java.util.Optional;

public interface BeforeUploadCheckMd5Exists extends BeforeUploadCheck<String> {

	Optional<String> check(String md5);
}
