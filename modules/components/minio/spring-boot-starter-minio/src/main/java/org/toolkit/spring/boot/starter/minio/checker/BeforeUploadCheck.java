package org.toolkit.spring.boot.starter.minio.checker;

import java.util.Optional;

public interface BeforeUploadCheck <T>{

    Optional<String> check(T t);
}
