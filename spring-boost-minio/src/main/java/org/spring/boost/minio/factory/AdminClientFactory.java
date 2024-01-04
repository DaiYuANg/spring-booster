/* (C)2024*/
package org.spring.boost.minio.factory;

import io.minio.admin.MinioAdminClient;
import lombok.SneakyThrows;
import lombok.val;
import okhttp3.OkHttpClient;
import org.jetbrains.annotations.NotNull;
import org.spring.boost.minio.properties.MinioClientConfig;

public abstract class AdminClientFactory {

    @SneakyThrows
    protected MinioAdminClient createMinioAdminClient(@NotNull MinioClientConfig config, OkHttpClient okHttpClient) {
        val client = MinioAdminClient.builder()
                .endpoint(config.getEndpoint())
                .httpClient(okHttpClient)
                .credentials(config.getAccessKey(), config.getSecretKey())
                .build();
        client.setTimeout(config.getConnectTimeout(), config.getWriteTimeout(), config.getReadTimeout());
        if (config.isValidQuotaSetting()) {
            client.setBucketQuota(config.getBucket(), config.getBucketSize(), config.getBucketQuotaUnit());
        }
        return client;
    }
}
