/* (C)2024*/
package org.spring.boost.minio.properties;

import io.minio.admin.QuotaUnit;
import java.util.Objects;
import lombok.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class MinioClientConfig {
    private String endpoint;

    private String accessKey;

    private String secretKey;

    private String bucket;

    private long bucketSize = 0L;

    private QuotaUnit bucketQuotaUnit = QuotaUnit.MB;

    private String region;

    private boolean enableAdmin = true;

    private boolean enableTemplate = true;

    private boolean enableTracing = false;

    private boolean preCheckConnection = true;

    private boolean enableDualStackEndpoint = true;

    private boolean enableVirtualStyleEndpoint = false;

    private boolean tracingStream;

    private long connectTimeout = 30000;

    private long writeTimeout = 30000;

    private long readTimeout = 30000;

    public MinioClientConfig(String endpoint, String accessKey, String secretKey, String bucket) {
        this.endpoint = endpoint;
        this.accessKey = accessKey;
        this.secretKey = secretKey;
        this.bucket = bucket;
    }

    public boolean isValidQuotaSetting() {
        return this.bucketSize != 0 && Objects.nonNull(bucketQuotaUnit);
    }
}
