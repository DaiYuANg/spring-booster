/* (C)2024*/
package org.spring.boost.minio.hook;

import io.minio.ObjectWriteResponse;
import io.minio.PutObjectArgs;
import java.util.Map;

public interface MinioInterceptor {

    default void beforeCreate(
            PutObjectArgs args, String bucket, String objectName, String contentType, Map<String, String> tags) {}

    default void afterCreateSuccess(ObjectWriteResponse response) {}

    default void afterCreateFailure(
            String bucket, String objectName, String contentType, Map<String, String> tags, Exception exception) {}
}
