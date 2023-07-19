package org.toolkit4j.framework.spring.starter.minio;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class MinioConfig {
    private String endpoint;

    private String accessKey;

    private String secretKey;

    private boolean async;
}
