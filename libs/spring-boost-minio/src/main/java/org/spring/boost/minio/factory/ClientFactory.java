/* (C)2024*/
package org.spring.boost.minio.factory;

import io.minio.MinioClient;
import lombok.val;
import okhttp3.OkHttpClient;
import org.jetbrains.annotations.NotNull;
import org.spring.boost.minio.autoconfigure.properties.MinioClientConfig;

public abstract class ClientFactory {

  protected MinioClient createClient(@NotNull MinioClientConfig config, OkHttpClient httpClient) {
    val client = MinioClient.builder()
      .endpoint(config.getEndpoint())
      .httpClient(httpClient)
      .credentials(config.getAccessKey(), config.getSecretKey())
      .build();
    client.setTimeout(config.getConnectTimeout(), config.getWriteTimeout(), config.getReadTimeout());

    if (config.isEnableDualStackEndpoint()) {
      client.enableDualStackEndpoint();
    }
    if (config.isEnableVirtualStyleEndpoint()) {
      client.enableVirtualStyleEndpoint();
    }
    return client;
  }
}
