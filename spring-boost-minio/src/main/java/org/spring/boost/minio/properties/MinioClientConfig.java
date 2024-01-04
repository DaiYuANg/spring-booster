/* (C)2024*/
package org.spring.boost.minio.properties;

import io.minio.admin.QuotaUnit;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Objects;

@Getter
@Setter
@ToString
public class MinioClientConfig {
    private String endpoint;

    private String accessKey;

    private String secretKey;

    private String bucket;

    private long bucketSize;

    private QuotaUnit bucketQuotaUnit;

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

    public boolean isValidQuotaSetting() {
        return this.bucketSize != 0 && Objects.nonNull(bucketQuotaUnit);
    }
}
